package ex0810.차준혁;

public class Quiz12 {
	// 다음과 같이 Example 클래스에서 action() 메소드를 호출할 때
	// 매개값이 C 객체일 경우에만 method2()가 호출되도록 밑줄에 들어갈 코드를 작성해 보세요.
	
	public static void action(A a) {
		a.method1();
		
		// if(__________________________)
		if(a instanceof C c) {
			c.method2();
		}
		
	}
	
	public static void main(String[] args) {
		action(new A());
		action(new B());
		action(new C());
		
	}
	
}

class A {
	public void method1() {
		System.out.println("A-method1()");
		
	}
	
}

class B extends A {
	public void method1() {
		System.out.println("B-method1()");
		
	}
	
}

class C extends A {
	public void method1() {
		System.out.println("C-method1()");
		
	}
	
	public void method2() {
		System.out.println("C-method2()");
		
	}
	
}