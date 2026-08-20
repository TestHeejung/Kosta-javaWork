package ex0810.차준혁;
class Parent07 {
	public String nation;
	
	public Parent07() { // 2
		this("대한민국");
		System.out.println("Parent07() call");
		
	}
	
	public Parent07(String nation) { // 1
		this.nation = nation;
		System.out.println("Parent07(String nation) call");
	}
	
}

class Child07 extends Parent07 {
	public String name;
	
	public Child07() { // 4
		this("홍길동");
		System.out.println("Child() Call");
		
	}
	
	public Child07(String name) { // 3
		this.name = name;
		System.out.println("Child(String name) call");
		
	}
	
}
///////////////////////////////////////
public class Quiz07 {
	// Parent 클래스를 상속받아 Child 클래스를 다음과 같이 작성했습니다.
	// ChildExample 클래스를 실행했을 때 호출되는 각 래스의 생성자의 순서를 생각하면서 출력 결과를 작성해 보세요.
	public static void main(String[] args) {
		Child07 child = new Child07();
		
		/*
		 * Parent07(String nation) call
		 * Parent07() call
		 * Child(String name) call
		 * Child() Call
		 * 
		 */
		
	}
	
}

