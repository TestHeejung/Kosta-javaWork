package app.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import app.mvc.model.dao.OrderDAO;
import app.mvc.model.dao.OrderDAOImpl;
import app.mvc.model.dto.Orders;

public class OrderService {
	OrderDAO orderDao = new OrderDAOImpl();
   /**
    * 주문하기
    * */
	 public void insertOrders(Orders orders) throws SQLException{
		int result =  orderDao.orderInsert(orders);
		if(result==0)throw new SQLException("주문하기가 실패하였습니다.");
	 }
	 
	 /**
	  * 주문 내역보기
	  * */
	 public List<Orders> selectOrdersByUserId(String userId)throws SQLException{
		 List<Orders> list = orderDao.selectOrdersByUserId(userId);
		 if(list==null || list.size()==0)throw new SQLException(userId+"의 주문내역이 없습니다.");
		 return list;
	 }
}
