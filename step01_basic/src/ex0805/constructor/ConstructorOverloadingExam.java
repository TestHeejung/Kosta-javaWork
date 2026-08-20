package ex0805.constructor;
class Puppy3{
	String name;//null
	int age;//0

	/*인수가 없는 생성자작성
		String 타입 전역변수에 "메리" 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/	
    Puppy3(){
      this.name ="메리";
	  System.out.println("puplic Puppy3()호출되었습니다");
	  System.out.println("전역변수 name = "+ this.name +",age = " +age);
	}

		/*
		 * String 타입의 인수 1개를 받는 생성자작성
		String 타입 전역변수에 인수 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
				
    Puppy3(String name){//"true쫑"
		this.name=name;//"true쫑"
		System.out.println("puplic Puppy3(String name)호출되었습니다");
        System.out.println("전역변수 name = "+ this.name +",age = " +age);
	}
		
			
	/*String 타입의 인수 2개를 받는 생성자작성
		인수2개를 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"출력
	*/	
	public Puppy3(String s, String s2){//"Java","Hi"
		//The Java feature 'Flexible Constructor Bodies' is only available with source level 25 and above
		this( s+s2 );//문자열 하나 받는 생성자를 호출Constructor call must be the first statement in a constructor	
		
        System.out.println("puplic Puppy3(String s, String s2)호출되었습니다");
	}



	/*boolean 타입의 인수 1개를 받는 생성자작성
		인수를 "쫑"과 붙여 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"  출력
	*/					
	public  Puppy3(boolean b){//true
       this( b+"쫑");//String한개받는 생성자 호출!!
		System.out.println("puplic Puppy3(boolean b)호출되었습니다");
	}
	
	
	/*char 타입의 인수 1개를 받는 생성자작성
			인수가 없는 생성자를 호출하고
			인수로 받은 data를 int타입 전역변수에 할당	
			"puplic Puppy3()호출되었습니다"출력
			int형 전역변수출력
	*/	
	public 	Puppy3(char ch){//A
	   this();//인수없는 생성자호출(기본생성자)
	   this.age = ch;
	   
	   System.out.println("puplic Puppy3(char ch)호출되었습니다");
	   System.out.println("전역변수 : " + this.age);
	}
	
	/*메소드 printMemberVariable
	리턴 없슴
	전역변수를 출력
	*/		
	public void printMemberVariable(){
	   System.out.println("전역변수  name = " + name);	
	   System.out.println("전역변수  age = " + age +"\n\n");	
	}

}

//////////////////////////////////////////////////////////////
public class ConstructorOverloadingExam{
	public static void main(String [] args){
		System.out.println("=======1.===============");
	   Puppy3 p1 = new Puppy3();//인수없는 생성자 호출	
	   
	   System.out.println("=======2.===============");
		 Puppy3 p2 = new Puppy3("Java");//String받는 생성자 호출됨

		 System.out.println("=======3.===============");
		  Puppy3 p3 = new Puppy3("Java","Hi");//String 2개 받는 생성자 호출됨

		  System.out.println("=======4.===============");
		  Puppy3 p4 = new Puppy3(true);//boolean받는 생성자 호출됨
		  
		  System.out.println("=======5.===============");
		  Puppy3 p5 = new Puppy3('A');//char 받는 생성자 호출됨.
		  
		   System.out.println("======주소값 출력==============");
		  System.out.println("p1 = " + p1);
		  System.out.println("p2 = " + p2);
		  System.out.println("p3 = " + p3);
		  System.out.println("p4 = " + p4);
		  System.out.println("p5 = " + p5);
		  
		  System.out.println("======각 객체의 메소드 호출==============");
		  p1.printMemberVariable();
		  p2.printMemberVariable();
		  p3.printMemberVariable();
		  p4.printMemberVariable();
		  p5.printMemberVariable();

	}
}