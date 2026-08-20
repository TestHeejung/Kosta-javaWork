package ex0810.차준혁;

public class Quiz10 {
	// 다음과 같이 작성한 Computer 클래스에서 컴파일 에러가 발생했습니다. 그 이유를 설명해 보세요.
	
}

abstract class Machine {
	public void powerOn() {}
	public void powerOff() {}
	public abstract void work();
	
}

class Computer extends Machine {
//abstrract class Computer extends Machine
	
	// 추상 메소드(work())를 재정의하거나 Computer 클래스를 추상 클래스로 선언하면 오류 해결됨.
	public void work() {
		System.out.println("work()");
	}
	
}