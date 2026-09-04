package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kosta.db.util.DbManager;

public class EmpDAO {
  /**
   * emp테이블에서 사원의 모든 이름 검색
   * select * from emp
   * */
	public void selectNames() {
		//로드 연결 실행 닫기
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		  con = DbManager.getConnection();
		  st = con.createStatement();
		  rs = st.executeQuery("select ename from emp");
		  while(rs.next()) {//앞으로 커서가 이동한다면(이동 할수 있을동안 반복한다)
			  //열을 조회한다.
			  String ename =rs.getString("Ename");
			  System.out.println(ename);
		  }
		  System.out.println("**완료***");
		  
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, st, rs);
		}
	}
	
	/**
	 * 사원번호에 해당하는 레코드 삭제
	 * delete from emp where empno=1000
	 * */
	 public void deleteByEmpno(int empno) {// 1000 or 1=1
		 Connection con=null;
		 Statement st=null;
		 String sql="delete from emp where empno=" + empno ;		 
		 try {
			con = DbManager.getConnection();
			st = con.createStatement();
			int re = st.executeUpdate(sql);
			
			if(re==0)System.out.println(re+" 삭제되지 않았습니다.");
			else System.out.println(re+" 삭제되었습니다.");
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, st);
		}
		 
	 }
	 
	 ////위 delete를 PreparedStatement방식으로 변경해보자///////////////
	 public void deleteByEmpno2(int empno) {
		 Connection con=null;
		 PreparedStatement ps=null;
		 String sql="delete from emp where empno=?"  ;		 
		 try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			
			//?의 개수만큼 순서대로 setXxx()설정 필수
			ps.setInt(1, empno);

			//실행요청
			int re = ps.executeUpdate();
			if(re==0)System.out.println(re+" 삭제되지 않았습니다.");
			else System.out.println(re+" 삭제되었습니다.");
			 
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps);
		}
	 }
	
}

















