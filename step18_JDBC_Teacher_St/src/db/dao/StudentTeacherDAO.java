package db.dao;

import java.util.List;

import db.vo.Student;
import db.vo.Teacher;

public interface StudentTeacherDAO {
	/**
	 * 1번 : 성별이 여자인 학생의 정보 검색
       select * from student where  수_주민등록번호 like '%-2%'
	 * */
	public List<Student> getGenderByWomen();
	
	/**
	 * 3.  "구"를 인수로 전달받아 구에 거주하는 강사의 정보 검색
	 *      select * from teacher  where 주소 like ?
	 * */
	public List<Teacher> getTeacherInfoByAddr(String gu);
	
	/**
	 * 5. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리) 
         select * from teacher where 수강코드 = 
          (select 수강코드 from subject where upper(과목)=upper( ? ))
	 * */
	
	public Teacher getTeacherInfoBySubject(String subject);
	
	

	/**
	 * 8강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다
	 *   select * from v_teacher  where 강사번호=?
	 * 
	 * */
	public Teacher getTeacherInfoByNo(int teacherNo);
}


