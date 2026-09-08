package app.mvc.model.service;

import java.sql.SQLException;

import app.mvc.exception.NotFoundException;
import app.mvc.model.dao.CustomerDAO;
import app.mvc.model.dao.CustomerDAOImpl;
import app.mvc.model.dto.Customer;
import app.mvc.session.Session;
import app.mvc.session.SessionSet;

public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();
	
	
  /**
   * 로그인
   * */
	public Customer login(String userId, String userPwd)throws NotFoundException , SQLException{
		Customer customer=customerDao.login(userId, userPwd);
		if(customer==null) {
			throw new NotFoundException("정보를 다시 확인해주세요.");
		}
		
		//로그인 된 정보 저장하기
		
		Session session = new Session(userId);
		
		SessionSet sessionSet = SessionSet.getInstance();
		
		sessionSet.add(session); //인증된사용자를 SessionSet에 저장한다.
		
		return customer;
	}
}
