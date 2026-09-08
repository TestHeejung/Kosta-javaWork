package app.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import app.mvc.model.dto.Customer;
import app.mvc.model.dto.Orders;
import app.mvc.model.service.OrderService;
import app.mvc.view.EndView;
import app.mvc.view.FailView;
import app.mvc.view.MenuView;

public class OrderController {
    private static OrderService orderService = new OrderService();
	/**
	 * 주문하기
	 * */
	public static void insertOrders(Orders order) {
		try {
		  orderService.insertOrders(order);
		  EndView.printMessage("주문 되었습니다.\n");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 주문내역보기
	 * */
	public static void selectOrdersByUserId(String userId) {
		try {
			 List<Orders> orderList = orderService.selectOrdersByUserId(userId);
             EndView.printOrderByUserId(orderList);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
}




