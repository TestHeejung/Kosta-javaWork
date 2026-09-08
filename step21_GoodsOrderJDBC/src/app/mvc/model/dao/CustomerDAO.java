package app.mvc.model.dao;

import java.sql.SQLException;

import app.mvc.model.dto.Customer;

public interface CustomerDAO {
  /**
   * 로그인하기
   * */
	Customer login(String userId, String userPwd)throws SQLException;
}
