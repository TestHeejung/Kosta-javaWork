package ex0810.차준혁;

public class Quiz02 {
	/*
	 * 클래스 타입 변환에 대한 설명 중 틀린 것?
	 * 
	 * 1. 자식 객체는 부모 타입으로 자동 타입 변환된다.
	 * 2. 부모 객체는 어떤 자식 타입으로도 강제 타입 변환된다.
	 * 3. 자동 타입 변환을 이용해서 필드와 매개변수의 다형성을 구현한다.
	 * 4. 강제 타입 변환 전에 instanceof 연산자로 변환 가능한지 검사하는 것이 좋다.
	 * 
	 * 답은 2번.
	 * 
	 */
	
	public static void main(String[] args) {
		   Car car = new Car();
		   Sonata so =(Sonata)car; //ClassCastException
	}
	
}

class Car{}
class Sonata extends Car{
	
}

  









