package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.mvc.model.dto.Customer;
import app.mvc.util.DbManager;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer login(String userId, String userPwd) throws SQLException {
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  Customer customer=null;
		 try {
		   con = DbManager.getConnection();
		   ps= con.prepareStatement("select * from customer where user_id=? and user_pwd=?");
		   ps.setString(1, userId);
		   ps.setString(2, userPwd);
		   
	        rs = ps.executeQuery(); 
	        
	        if(rs.next()) {
	        	customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	        }
        }finally {
        	DbManager.close(con, ps, rs);
        }
		return customer;
	}

}
