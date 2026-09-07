package db.view;

import java.util.List;

import db.dao.StudentTeacherDAO;
import db.dao.StudentTeacherDAOImpl;
import db.vo.Student;
import db.vo.Teacher;

public class MainView {

	public static void main(String[] args) {
		StudentTeacherDAO dao = new StudentTeacherDAOImpl();
		System.out.println("1.성별이 여자인 학생정보 --------------");
		List<Student> list = dao.getGenderByWomen();
		
		/*for(Student st:list) {
			System.out.println(st); //st.toString();
		}*/
		list.forEach(System.out::println);
		
		////////////////////////////////////////////////////////////////////////
		System.out.println("\n2. \"구\"를 인수로 전달받아 구에 거주하는 강사의 정보 검색  -------------");
		List<Teacher> teacherList = dao.getTeacherInfoByAddr("서울");
		/*for(Teacher te : teacherList) {
			System.out.println(te);
		}*/

		teacherList.forEach(System.out::println);
		
		/////////////////////////////////////////////////////////////////////////
		System.out.println("\n3. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리)  ");
		 Teacher teacher = dao.getTeacherInfoBySubject("sql");
		 if(teacher==null)
			 System.out.println("과목명에 해당하는 강사의 정보가 없습니다.");
		 else 
			 System.out.println(teacher);

   ///////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n4-1.  뷰에서 강사번호에 해당하는 강사의 정보 검색하기 ------------");
		 teacher = dao.getTeacherInfoByNo(3);
		if(teacher==null)
			System.out.println("강사의 정보가 없습니다.");
		else {
			System.out.println("------강사 정보 --------------");
			System.out.print(teacher.getTeacherNo() +" | ");
			System.out.print(teacher.getTeacherName() +" | ");
			
			System.out.print(teacher.getSubject().getSugangCode() +" | ");
			System.out.print(teacher.getSubject().getSubjectName() +" | ");
			
			System.out.print(teacher.getRoom().getRoomNo() +" | ");
			System.out.print(teacher.getRoom().getRoomCount() +"\n");
		}
		
	}

}
















