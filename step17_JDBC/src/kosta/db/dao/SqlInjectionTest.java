package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kosta.db.dto.EmpDTO;
import kosta.db.util.DbManager;

public class SqlInjectionTest {
	
	/**
	 * Statement인경우
	 *  select empno, ename,job, sal, hiredate from emp where sal > '2000'
	 * */
	public static void statementTest(String param) {
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		String sql="select empno, ename,job, sal, hiredate from emp where sal > " + param +" order by sal";
		try {
			con =  DbManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDTO emp = 
				  new EmpDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				
				System.out.println(emp);//emp.toString() 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, st, rs);
		}
	}
	
	/**
	 * PreparedStatement인경우 
	 *  select empno, ename,job, sal, hiredate from emp where sal > '2000'
	 * */
    public static void preparedStatementTest(String param) {
    	Connection con=null;
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	String sql="select empno, ename,job, sal, hiredate from emp where sal > ? order by sal";
		try {
			
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			//?의 값 설정 필요
			ps.setString(1, param);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EmpDTO emp = 
				  new EmpDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				
				System.out.println(emp);//emp.toString() 
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
	}

	public static void main(String[] args) {
		System.out.println("--1. Statement인경우-------------- ");
		//statementTest("2000"); // 5000 or 1 =1 
		//statementTest("5000 or 1 =1");
		
		//System.out.println("\n--2. PreparedStatement인경우 ------------");
		//preparedStatementTest("2000"); // 5000 or 1 = 1 
		
		//SQLInjection을 방어할 수 있음
		//preparedStatementTest("2000 or 1 =1");
		preparedStatementTest("1=1 or 2000");

	}

}











