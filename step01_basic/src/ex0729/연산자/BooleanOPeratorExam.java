package ex0729.연산자;

class BooleanOPeratorExam{
	public static void main(String args[]){
		boolean  t = true ;
		boolean f = false;
		
		//& or && 는 결과가 양쪽이 true일때만 true
		System.out.println("true&false=" + (t&f) ); //true&false=false
		
		System.out.println("true&true="+(t&t));//true&true=true
		System.out.println("false&false="+(f&f));
		System.out.println();
	
		//| or || 는 결과가 한쪽이라도 true이면 true
		System.out.println("true|false="+(t|f));
		System.out.println("true|true="+(t|t));
		System.out.println("false|false="+(f|f));
		System.out.println();

		// XOR인 ^는 양쪽이 같으면 false, 다르면 false
		System.out.println("true^false="+(t^f));
		System.out.println("true^true="+(t^t));
		System.out.println("true^false="+(t^f));
		System.out.println("true^true="+(t^t));
		System.out.println();

		System.out.println("true&&false="+(t&&f));
		System.out.println("true&&true="+(t&&t));
		System.out.println("true&&false="+(t&&f));
		System.out.println("false&&false="+(f&&f));
		System.out.println();

		System.out.println("true||false="+(t||f));
		System.out.println("true||true="+(t||t));
		System.out.println("false||false="+(f||f));
		System.out.println();

		int i=5 , j=3;
		System.out.println("int i="+i+"\t int j="+j);
		System.out.println("i>=j==>>"+  (i>=j) );
		System.out.println("i>j=>>"+(i>j));
		System.out.println("i<=j=>>"+(i<=j));
		System.out.println("i<j=>>"+(i<j));
		System.out.println("i==j=>>"+(i==j));
		System.out.println("i!=j=>>"+(i != j));
		
		////////////////////////////////////////////////
		System.out.println("--------------------");
		// |  or || 비교
		//System.out.println("결과 : " + (true | test()  ) ); //test()호출됨
		//System.out.println("결과 : " + (true || test()  ) );//test()호출안됨!
		
		
		// &  or && 비교
		//System.out.println("결과 : " + (false & test()  ) ); //
		System.out.println("결과 : " + (false && test()  ) );
		

	}//메인메소드 끝
	
	//메소드 작성
	public static boolean test() {
		System.out.println("test call..");
		return true;
	}
	
}













