package ex0807.overriding;

class ObjectExam{
	String str;
	public ObjectExam(){   }
	public ObjectExam(String str){
		this.str=str;
	}
	
	@Override
	public String toString() {
		
		return super.toString() +" = " + str ;
	}
}
/////////////////////////////////////////////

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03 = new String("월요일");
			
			ObjectExam oe1 = new ObjectExam("집에가요~~");
			ObjectExam oe2 = new ObjectExam("안녕");
			
			System.out.println(c);//  a
			
			/*System.out.print(객체) or System.out.println(객체) ; 일때 , 
			 * 인수 객체가 오면 객체.toString() 호출됨.
			 */
			
			System.out.println(s01.toString());//장희정
			System.out.println(s02);//
			System.out.println(s03);// 월요일
			
			System.out.println(oe1);// 주소 = 집에가요~~
			
			System.out.println(oe2);// 주소 = 안녕
			
	}
}
