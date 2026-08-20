package ex0807.superkeyword;

class Parent{
//	Parent(){
//		System.out.println(1);
//	}
	Parent(int i){
		System.out.println(2);
	}
	Parent(String s){
		System.out.println(3);
	}
}
////////////////////////////////////////
class Child extends Parent{//Child is a Parent 성립
	Child(){
		this(2); //현재클래스의 int형 하나받는 생성자 호출 
		System.out.println(4);
	}
	Child(int i){
		super(i);
		System.out.println(5);
	}
	Child(boolean b){
		super("하이");
		System.out.println(6);
	}
}
/////////////////////////////////////////////////

public class SuperConstructorExam {
	public static void main(String[] args) {
		 //new Child(); // 1 4
		 //new Child(10); // 1 5
		
		//결론 : 자식생성자 구현부 첫번째 줄에 super() 생략되어 있다.
		
		/////////////////////////////////////
		//만약, 부모의 생성자가 한개도 없다면....
		//new Child();//4
		//new Child(10); //5
		//new Child(true); //6

		//결론 : 생성자를 한개도 작성하지 않으면 
		         //기본생성자가 자동으로 삽입되어진다.
		
		//////////////////////////////////////////////////
		//부모의 기본생성자는 없고, 인수 있는 생성자가 있는경우
		//=> 자식생성자 구현부 첫번째 줄에서 모두 에러발생
		//=> 반드시 자식생성자 구현부 첫번째 줄에서 super()아닌
		 //   다른생성자를 인위적으로 호출해야한다.
		
		new Child();
	}

}





