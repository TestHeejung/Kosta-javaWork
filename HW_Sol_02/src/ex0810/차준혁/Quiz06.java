package ex0810.차준혁;

public class Quiz06 {
	// Parent 클래스를 상속해서 Child 클래스를 다음과 같이 작성했는데, Child 생성자에서 컴파일 에러가 발생했습니다.
	// 그 이유와 해결 방법을 설명해 보세요.
	
}

class Parent06 {
	public String name;
	
	public Parent06(String name) { // 부모 클래스 생성자 -> 기본 생성자 자동 생성 X
		this.name = name;
		
	}
	
}

class Child06 extends Parent06 {
	public int studentNo;
	
	public Child06(String name, int studentNo) {
		// 부모 클래스 기본 생성자가 없어서 부모 생성자 호출 X
				// this.name = name;
			
				// 부모 클래스 생성자 호출
				super(name);
		this.studentNo = studentNo;
		
	}
	
}
