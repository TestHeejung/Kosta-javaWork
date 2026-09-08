package app.mvc.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import app.mvc.controller.OrderController;
import app.mvc.model.dto.Goods;
import app.mvc.model.dto.OrderLine;
import app.mvc.model.dto.Orders;
import app.mvc.session.Session;
import app.mvc.session.SessionSet;

public class EndView {
  /**
   * 상품 전체 출력
   * */
	public static void printGoodsList(List<Goods> list) {
		System.out.println("-----상품 "+ list.size() +"개 -------------");
		for(Goods goods : list) {
			System.out.println(goods);
		}
		
		System.out.println();
	}
	
	
	
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * 장바구니 보기
	 * */
	public static void printViewCart(String id , Map<Goods,Integer> cart) {
		System.out.println("장바구니내용....");
		
		for(Goods goods: cart.keySet()) {
			String goodsId = goods.getGoodsId();//상품번호
			String name = goods.getGoodsName();//상품이름
			int price = goods.getGoodsPrice();//상품가격
			
			int quantity = cart.get(goods);//key에 해당하는 value즉 수량 
			System.out.println(goodsId+" : "+name+" : "+price+" \t "+quantity);
		}
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.주문하기  |  9.나가기");
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			
			 System.out.print("배송주소 : ");
			 String address = sc.nextLine();
			
			 Orders orders = new Orders(0, null, id, address, 0);
			 
			 List<OrderLine> orderLineList = orders.getOrderLineList();
			 
			 for(Goods goodsKey : cart.keySet()) {
				 int qty = cart.get(goodsKey);//map에서 key=Goods에 해당하는 value=수량 조회
				 OrderLine orderLine = new OrderLine(0, 0, goodsKey.getGoodsId() , 0, qty, 0);
				 orderLineList.add(orderLine);
			 }
			 
			 
			 System.out.println("orderLineList 개수 : " + orderLineList.size());
			 
			 OrderController.insertOrders(orders);// 주문 + 주문상세
			 
			 //장바구니비우기
			 SessionSet ss = SessionSet.getInstance();
			 Session session = ss.get(id);
			 session.removeAttribute("cart");
			break;
			
		case 9:
			break;
		}
		
		//System.out.println(id);
	
	}
 
	/**
	 * 주문 상세보기
	 * */
	public static void printOrderByUserId(List<Orders> orderList) {
	   for(Orders order : orderList) {
		   System.out.println(order.getOrderId()+ " | " + order.getOrderDate() +" | " + order.getTotalAmount() +" | " + order.getAddress());
		   
		   for(OrderLine orderLine : order.getOrderLineList()) {
			   System.out.println("  ▶ "+orderLine);
		   }
		   System.out.println();
	   }
		
	}
}












