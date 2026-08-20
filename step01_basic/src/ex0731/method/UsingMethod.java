package ex0731.method;
class UsingMethodExam{
	 /*Method이름 :  methodExam03_01
  자기자신만 접근가능
  ReturnType : 정수
  Parameter : 정수 1개
	(구현부에서)하는 일 : 
	methodExam03_01이 호출되었습니다. 출력
	인수로 받은 정수 출력 
	정수*2 리턴. */
		
	private int methodExam03_01(int i) {//9
		System.out.println("methodExam03_01이 호출되었습니다.");
		System.out.println("인수의 값 = " + i);
		return i * 2;
	}
	
	 
	 /*Method이름 :  methodExam03_02
   어디서나 아무나 접근가능
   Return String
   Parameter : String 1개, 정수 1개
	(구현부에서)하는 일 : 
		methodExam03_02가 호출되었습니다. 출력
		
		인수로 받은 String 에 바보를 붙여서 출력
		
		두번째인수로 들어온 값을 methodExam03_01로 넣어 주며 
		methodExam03_01을 호출하고 리턴하는 값을 출력
		인수로 받은 String 에 바보를 붙여서 리턴
	*/	
	public String methodExam03_02(String s, int i) {//"재미있다",9
		System.out.println("methodExam03_02가 호출되었습니다.");
		System.out.println(s + "바보");
		
		System.out.println("this = " + this );//this는 생성된현재객체뜻함
		
		//두번째인수로 들어온 값을 methodExam03_01로 넣어 주며 
		//methodExam03_01을 호출하고 리턴하는 값을 출력
		int j = this.methodExam03_01(i);
		
		System.out.println("리턴값 = "+j);

		return s + "바보";
	}	
	
	 /*Method이름 :  methodExam03_03
   같은 package에서 아무나 접근 가능
   ReturnType : 리턴안함
   Parameter : 정수 1개와 String 1개
   (구현부에서)하는 일 : 
		methodExam03_03이 호출되었습니다. 출력
		인수로 받은 정수 1개와 String 1개를 넘겨주며
		methodExam03_02호출
	*/	
	void methodExam03_03(int i, String s){//9, "재미있다"
		System.out.println("methodExam03_03이 호출되었습니다.");
		
		methodExam03_02(s, i);//"재미있다",9
		
	}
	
   
   /*Method이름 :  methodExam03_04
   상속관계라면 어디서나 접근 가능
   ReturnType : 실수
   Parameter : 첫번째 인수(정수),두번째 인수(실수), 세번째인수(정수)
	(구현부에서)하는 일 : 
		methodExam03_04가 호출되었습니다. 출력
		인수로 들어온 값을 이용해 
		MakeMethodExam02객체의 methodExam02_04메소드 호출하고
		method02_04가 리턴하는 값을 리턴
	*/	
	protected double methodExam03_04(int i, double j, int z) {//5, 10.5, 3
		System.out.println("methodExam03_04가 호출되었습니다.");
		
		MakeMethodExam02 m3 = new MakeMethodExam02();
		double x = m3.methodExam02_04(i, j, z);
		return x;
		
		//return m3.methodExam02_04(i, j, z);
	}
		
} // UsingMethodExam 끝

//////////////////////////////////////////////////////////////////////////////////////

class UsingMethod{
	//메인메소드에서
	public static void main(String[] args) {
		//UsingMethodExam의 호출가능한 메소드들을 호출하고
		// 리턴하는 값 있다면 출력

		UsingMethodExam um = new UsingMethodExam();
		System.out.println("um = " + um);
		
		//The method methodExam03_01(int) from the type UsingMethodExam is not visible
		//um.methodExam03_01(5); //private이므로 다른 객체에서접근 불가(같은 클래스내부에서 접근가능)

		String result = um.methodExam03_02("자바", 5);
		System.out.println("결과 : " + result);

		System.out.println("----------------------");
		um.methodExam03_03(9, "재미있다");

		System.out.println("----------------------");
		double re = um.methodExam03_04(5, 10.5, 3);
		System.out.println("최종 결과 = " + re);
				

	}//메인끝
	
}











