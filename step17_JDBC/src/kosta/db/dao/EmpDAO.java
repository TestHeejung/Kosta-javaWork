package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kosta.db.dto.EmpDTO;
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
	 
	 /**
	  * 모든 사원의 정보 검색하기
	  * select empno, ename, job, sal, hiredate from emp
	  * */
	 public List<EmpDTO> selectAll(){
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 String sql="select empno, ename, job, sal, hiredate from emp";
		 List<EmpDTO> list = new ArrayList<EmpDTO>();
		 try {
			 con = DbManager.getConnection();
			 ps = con.prepareStatement(sql);
			 //?의 개수만큼 순서대로 ps.setXxx() 필수 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 //열을 조회
				 int empno = rs.getInt(1);
				 String ename = rs.getString(2);
				 String job = rs.getString("job");
				 int sal = rs.getInt("sal");
				 String hiredate = rs.getString("hiredate");
				 
				 EmpDTO dto = new EmpDTO(empno, ename, job, sal, hiredate);
				 list.add(dto);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		 return list; 
	 }
	 
	 /**
	  * 사원번호에 해당하는 사원정보 검색하기
	  * select empno, ename, job, sal, hiredate from emp where empno=?
	  * */
	  public EmpDTO selectByEmpno(int empno) {
		     Connection con=null;
			 PreparedStatement ps=null;
			 ResultSet rs=null;
			 String sql="select empno, ename, job, sal, hiredate from emp where empno=?";
			 EmpDTO  empDTO= null;
			 try {
				 con = DbManager.getConnection();
				 ps = con.prepareStatement(sql);
				 //?의 개수만큼 순서대로 ps.setXxx() 필수 
				 ps.setInt(1, empno);
				 rs = ps.executeQuery();
				 if(rs.next()) {
					 empDTO = new EmpDTO(
							 rs.getInt(1), rs.getString(2),
							 rs.getString("job"), rs.getInt("sal"), 
							 rs.getString("hiredate")); 
				 }
			 }catch (Exception e) {
				e.printStackTrace();
			}finally {
				DbManager.dbClose(con, ps, rs);
			}
			 return empDTO; 
	  }
	 
	 
	 /**
	  * 사원정보등록하기 
	  * insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?, now())
	  * */
	  public int insert(EmpDTO empDTO) {
		 Connection con=null;
		 PreparedStatement ps=null;
		 String sql="insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?, now())"  ;	
		 int result=0;
		 try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			
			//?의 개수만큼 순서대로 setXxx()설정 필수
			ps.setInt(1, empDTO.getEmpno());
			ps.setString(2, empDTO.getEname());
			ps.setString(3, empDTO.getJob());
			ps.setInt(4, empDTO.getSal());

			//실행요청
			result = ps.executeUpdate();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps);
		}
			 
		  return result;
	  }
	
}

















