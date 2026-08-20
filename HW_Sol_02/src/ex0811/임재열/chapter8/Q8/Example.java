package ex0811.임재열.chapter8.Q8;

public class Example {
	public static void action(A a) {
		a.method1();
		if(a instanceof C c) {
			c.method2();
		}
	}
	
	public static void main(String[] args) {
		action(new B());
		action(new C());
	}

}
