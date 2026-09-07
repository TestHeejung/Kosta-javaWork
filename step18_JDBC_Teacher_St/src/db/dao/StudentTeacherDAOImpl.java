package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DbManager;
import db.vo.Room;
import db.vo.Student;
import db.vo.Subject;
import db.vo.Teacher;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {

	/**
	 * 1번 : 성별이 여자인 학생의 정보 검색
       select * from student where  수_주민등록번호 like '%-2%'
	 * */
	public List<Student> getGenderByWomen(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Student> list = new ArrayList<Student>();
		String sql="select * from student where  수_주민등록번호 like '%-2%'";
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 setXxx() 필요하다
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Student st = new Student(rs.getInt(1), rs.getString(2),  rs.getString(3),
						rs.getString(4),  rs.getString(5),  rs.getString(6));
				
				list.add(st);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return list;
		
	}//메소드끝
	
	/**
	 * 2.  "구"를 인수로 전달받아 구에 거주하는 강사의 정보 검색
	 *      select * from teacher  where 주소 like ?
	 * */
	public List<Teacher> getTeacherInfoByAddr(String gu){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql="select * from teacher  where 주소 like ? " ;
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			
			//?가 있다면 setXxx() 필요하다
			ps.setString(1, "%"+gu+"%"); //주소 like ? 인경우 
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2),  rs.getString(3),
						rs.getString(4),  rs.getString(5),  rs.getString(6) , rs.getString(7));
				
				list.add(teacher);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return list;
		
	}
	
	/**
	 * 5. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리) 
         select * from teacher where 수강코드 = 
          (select 수강코드 from subject where upper(과목)=upper( ? ))
	 * */
	
	public Teacher getTeacherInfoBySubject(String subject){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Teacher teacher = null;
		String sql="select * from teacher where 수강코드 = "
				+ "(select 수강코드 from subject where upper(과목)=upper( ? ))" ;
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 setXxx() 필요하다
			ps.setString(1, subject);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				 teacher = new Teacher(rs.getInt(1), rs.getString(2),  rs.getString(3),
						rs.getString(4),  rs.getString(5),  rs.getString(6) , rs.getString(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return teacher;
		
	}
	
	/**
	 * 8번 먼저 뷰를 생성한다.
   CREATE or replace VIEW v_tear
	as
	select  te.강사번호 ,강사이름, te.수강코드, 과목, ro.강의실번호, 수용인원
	   from teacher te
			inner join subject su on te.수강코드=su.수강코드
			inner join sugangtb sug on su.수강코드=sug.수강코드
			inner join room ro on sug.강의실번호=ro.강의실번호;


		 위의 쿼리를 실행해서 뷰로 만든다.
		
		 그리고나서 
		   강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다.

	 * */
	
	
	/**
	 * 강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다
	 *   select * from v_teacherINfo  where 강사번호=?
	 * 
	 * */
	
	public Teacher getTeacherInfoByNo(int teacherNo){//teacherNo는 pk
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Teacher teacher = null;
		String sql="select * from v_teacher  where 강사번호=?" ;
		
		/*String sql="select  te.강사번호 ,강사이름, te.수강코드, 과목, ro.강의실번호, 수용인원\r\n"
				+ "   from teacher te\r\n"
				+ "		inner join subject su on te.수강코드=su.수강코드\r\n"
				+ "		inner join sugangtb sug on su.수강코드=sug.수강코드\r\n"
				+ "		inner join room ro on sug.강의실번호=ro.강의실번호 
				where te.강사번호=?";*/
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 setXxx() 필요하다
			ps.setInt(1, teacherNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				 teacher = new Teacher();
				 
				 teacher.setTeacherNo(rs.getInt(1));
				 teacher.setTeacherName(rs.getString(2));
				 
				 Subject subject = new Subject(rs.getString(3), rs.getString(4));
				 
				 teacher.setSubject(subject );
				 
				 teacher.setRoom( new Room(rs.getInt(5), rs.getInt(6))  );
				 
			}//if문
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return teacher;
	}
}














