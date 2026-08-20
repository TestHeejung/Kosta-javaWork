package ex0804.array.student;

/**
 * 사용자 요청에 대한 최종 결과를
 * 모니터에 출력을 담당하는 클래스 
 * */
public class EndView {

	/**
	 * 전체 학생의 정보 모니티에 출력
	 * */
	public static void printSelectAll(Student[] stArr) {
		System.out.printf("***학생의 정보 (%d)명*****%n", StudentService.count  );
		
		for(int i=0; i< StudentService.count ; i++) {
			System.out.printf("이름 : %s | 나이 : %d  | 주소 : %s%n", 
					   stArr[i].getName() , stArr[i].getAge(), stArr[i].getAddr());
		}
	}
	
	/**
	 * 이름에 해당하는 학생정보 출력
	 * */
	public static void printSelectByName(Student student) {
		System.out.printf("%s님의 기본 정보%n", student.getName() );
		System.out.printf("나이 : %d  | 주소 : %s%n",  student.getAge(), student.getAddr());
	}
	
	/**
	 * 성공 or 실패에 대한 메시지 출력 
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}






