package app.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import app.mvc.model.dto.Goods;
import app.mvc.model.service.GoodsService;
import app.mvc.session.Session;
import app.mvc.session.SessionSet;
import app.mvc.view.EndView;
import app.mvc.view.FailView;

public class CartController {
  private static GoodsService goodsService = new GoodsService();
  
   public static void putCart(String id, String goodsId, int quantity) {
		
		try {
			//상품번호에 해당 상품찾기
			Goods goods = goodsService.goodsSelectBygoodsId(goodsId);
			
			//A01	새우깡	1500	5	2026-09-08 09:32:20
			
			if(goods.getStock() < quantity) {
				throw new SQLException("재고량 부족으로 장바구니에 담을수 없습니다.");
			}
			
			//id에 해당하는 세션찾기
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(id);	
			
			//세션에서 장바구니 찾기
			Map<Goods, Integer> cart =	(Map<Goods,Integer>)session.getAttribute("cart"); //상품 , 수량 저장 
			//{A01 | 새우깡 | 1500 | 5 | 2026-09-08 09:32:20=2}
			
			//장바구니가 없으면 장바구니 생성
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}
			
			
			
			//장바구니에서 상품찾기
			Integer oldQuantity = cart.get(goods);//goods는 장바구니 Map의 key
			if(oldQuantity != null) { //장바구니에 이미 상품이 있다면
				quantity += oldQuantity; //수량을 누적 => quantity = quantity + oldQuantity
			}
			
			cart.put(goods, quantity); //장바구니에 상품 넣기
			
			//System.out.println("cart = " + cart);
			EndView.printMessage("장바구니에 담았습니다");
			
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
   
   //map toString 재정의 : key=value 출력
   
   /**
    * 장바구니 보기
    * */
   public static void viewCart(String id) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(id);
		
		Map<Goods,Integer> cart = (Map<Goods, Integer>) session.getAttribute("cart");
		if(cart == null ) { // 장바구니가 없는 고객
			FailView.errorMessage("장바구니가 비었습니다");
		}else {
			EndView.printViewCart(id , cart);
		}
	}
}












