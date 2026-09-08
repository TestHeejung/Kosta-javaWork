package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.mvc.model.dto.Goods;
import app.mvc.model.dto.OrderLine;
import app.mvc.model.dto.Orders;
import app.mvc.util.DbManager;

public class OrderDAOImpl implements OrderDAO {
	
	GoodsDAO goodsDao = new GoodsDAOImpl();
    /**
     * 주문하기 
     *        1) orders테이블에 insert
     *        2) order_line테이블에 insert
     *        3) goods의 재고량 감소(update)
     * */
	@Override
	public int orderInsert(Orders order)throws SQLException {
		 Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  String sql="INSERT INTO ORDERS( ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)" + 
		  		"  VALUES(now(),?,?, ?)";
		  int result=0;
		 try {
			
		   con = DbManager.getConnection();
		   con.setAutoCommit(false);//자동커밋해지
		   
		  // ps = con.prepareStatement(sql);
		   ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS 옵션을 사용하여 AUTO_INCREMENT 값을 가져온다
		   ps.setString(1, order.getUserId());
		   ps.setString(2, order.getAddress());
		   
		   int totalAmount =  this.getTotalAmount(order) ;//총결재금액을 계산하는 메소드 
		   ps.setInt(3, totalAmount);//총구매금액구하는 메소드 호출
		   
		   result = ps.executeUpdate();
		   if(result==0) {
			   con.rollback();
			   throw new SQLException("주문 실패...");
		   }
		   else {
			   rs = ps.getGeneratedKeys();//ps.getGeneratedKeys()를 사용해 order_id 값을 획득한다.
			   int orderId = -1;
			   
			   if(rs.next()) {
				   orderId= rs.getInt(1);
			   }
			   System.out.println("orderId = " + orderId);
			   int re [] = this.orderLineInsert(con, order, orderId); //주문상세 등록하기 
			   for(int i : re) {
				   if(i != 1) {//
					   con.rollback();
					   throw new SQLException("주문 할수 없습니다....");
				   }
			   }
			   
			   
			   //주문수량만큼 재고량 감소하기
			   this.decrementStock(con, order.getOrderLineList());
			   
			   con.commit();
		   }
		   
      }finally {
    	  con.commit();
      	DbManager.close(con, ps , rs);
      }
		
		return result;
	}
	
	/**
	 * 주문상세 등록하기 
	 * */
	public int[] orderLineInsert(Connection con  , Orders order, int orderId) throws SQLException{
		
		  PreparedStatement ps=null;
		  String sql="insert into order_line(order_id, goods_id,unit_price, qty, amount)" + 
		  		"  values(? , ?, ? , ? , ? )";
		  int result [] =null;
		 try {
			 ps = con.prepareStatement(sql);
			 
		  for( OrderLine orderline : order.getOrderLineList() ) {
			 Goods goods = goodsDao.goodsSelectBygoodsId(orderline.getGoodsId());
			   ps.setInt(1, orderId); //주문번호
			 
			   ps.setString(2, orderline.getGoodsId()); //상품코드
			   ps.setInt(3, goods.getGoodsPrice());//가격
			   ps.setInt(4, orderline.getQty());//구매수량
			   ps.setInt(5,  goods.getGoodsPrice()*orderline.getQty());//총구매금액
			   
			   //ps.executeUpdate();
			   
			   ps.addBatch(); //일괄처리할 작업에 추가
			   ps.clearParameters();
		  }
		  
		  result = ps.executeBatch();//일괄처리
		  
		   
    }finally {
    	DbManager.close(null, ps , null);
    }
		
		return result;
		
	}
	
	/**
	 * 상품으로 재고량 감소시키키
	 * */
	public int[] decrementStock(Connection con , List<OrderLine> orderLineList)throws SQLException {
		 PreparedStatement ps=null;
		  String sql="update goods set stock = stock-? where goods_id=?";
		  int result [] =null;
		 try {
		  ps = con.prepareStatement(sql);
		  for( OrderLine orderline : orderLineList ) {
			   ps.setInt(1, orderline.getQty());
			   ps.setString(2, orderline.getGoodsId());
			   
			   ps.addBatch(); //일괄처리할 작업에 추가
			   ps.clearParameters();
		  }
		  
		  result = ps.executeBatch();//일괄처리
		  
		 }finally {
			 DbManager.close(null, ps, null);
		 }
		
		return result;
	}
	
	/**
	 * 상품 총구매금액 구하기
	 * */
	public int getTotalAmount(Orders order) throws SQLException { //상품가격 , 수량
		List<OrderLine> orderLineList= order.getOrderLineList();//주문하려는 상품들
	    int total=0;
		for(OrderLine line : orderLineList) {
			Goods goods = goodsDao.goodsSelectBygoodsId(line.getGoodsId());//상품에해당하는 정보 검색
			
			if(goods==null)throw new SQLException("상품번호 오류입니다.... 주문 실패..");
			else if(goods.getStock() <  line.getQty())throw new SQLException("재고량 부족입니다...");
			
	    	total += line.getQty() * goods.getGoodsPrice() ; //주문수량 * 가격
	    }
		
		return total;
	}
	
	/**
	 * 주문내역 보기
	 * select * from orders join order_line using(order_id) where user_id=?
	 * */
	public List<Orders> selectOrdersByUserId(String userId)throws SQLException{
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Orders> list = new ArrayList<>();
		 try {
		   con = DbManager.getConnection();
		   ps= con.prepareStatement("select * from orders where user_id=? order by order_id desc");
		   ps.setString(1, userId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Orders orders  = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
	        	
	        	//주문번호에 해당하는 상세정보 가져오기
	        	List<OrderLine> orderLineList = this.selectOrderLine(orders.getOrderId());//메소드 호출
	        	orders.setOrderLineList(orderLineList);
	        	
	        	list.add(orders);
	        }
    }finally {
    	DbManager.close(con, ps, rs);
    }
		return list;
		
	}
	
	/**
	 * 주문번호에 해당하는 주문상세 가져오기
	 * */
	public List<OrderLine> selectOrderLine(int orderId)throws SQLException{
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<OrderLine> list = new ArrayList<>();
		 try {
		   con = DbManager.getConnection();
		   ps= con.prepareStatement("select * from order_line where  order_id=?");
		   ps.setInt(1, orderId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	OrderLine orderLine  = new OrderLine(rs.getInt(1), rs.getInt(2), 
	        			rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
	        	list.add(orderLine);
	        }
    }finally {
    	DbManager.close(con, ps, rs);
    }
		return list;
		
	}
}







