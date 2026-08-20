package ex0806.constructor;

/**
 * 싱글톤 클래스 작성
 * 1) private  생성자 만든다.
 * 2) 객체를 static 맴버필드로 선언한다.
 * 3) 객체를 직접 생성해서 반환해주는 메소드를 작성한다.
 * */

class Test{
	static Test instance = new Test();
	private Test() {}
	
	public static Test getInstance() {
		
		return instance;
	}
}

///////////////////////////////////////////////////
public class PrivateConstructorExam {
	public static void main(String[] args) {
		 //new Test(); //private 생성자이므로 외부에서 객체생성 못한다.
		
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		Test t3 = Test.getInstance();
		System.out.println("t1 = "+ t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);

	}

}





