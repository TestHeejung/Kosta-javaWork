package ex0805.constructor;
class Puppy{
	//String,int  타입 전역 변수 선언(member변수 = 전역변수 = Field 선언)
	String name;//null --> 메리
	int age;//0 -> -98998
	
	/*	메소드 printPuppyName작성
		인수없음, 리턴안함
		"public void printPuppyName() 호출되었습니다!"출력
		전역변수를 출력
	*/	
	public void printPuppyName() {
		System.out.println("public void printPuppyName() 호출되었습니다!");
		System.out.println("전역변수 this.name = " + this.name);
		System.out.println("전역변수 age = " + age);
		
	}
	
	
	/*인수가 없는 생성자 작성
		"생성자 public Puppy() 호출되었습니다!"출력
		
		printPuppyName메소드 호출
		
			전역변수 String에"메리" 할당
		전역변수 int에 -98998 할당
	*/
	public Puppy() {
		System.out.println("생성자 public Puppy() 호출되었습니다!");
		
		this.printPuppyName();
		
		this.name="메리";
		this.age=-98998;
		
	}
}

/////////////////////////////////////////////////
public class ConstructorExam{
	public static void main(String [] agrs){
		//Puppy객체 생성(객체가 생성되는 시점, 맴버필드  초기화->명시적초기화 ,생성자홏
		Puppy p = new Puppy();//생성자가 호출된다!!!
	    
		System.out.println("--------------");
		p.printPuppyName();
		
	
		
	}
}
