package app.mvc.controller;

import java.util.List;

import app.mvc.model.dto.Goods;
import app.mvc.model.service.GoodsService;
import app.mvc.view.EndView;
import app.mvc.view.FailView;

public class GoodsController {
	static GoodsService goodsService = new GoodsService();
  /**
   * 전체 상품 조회
   * */
	public static void goodsSelect() {
		try {
			List<Goods> list = goodsService.goodsSelect();
			EndView.printGoodsList(list);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 
	 * */
}
