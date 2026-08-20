package ex0731.method;

class Methodinvoke01{
	//다음과 같이 메소드를 작성하세요.
	
	/*method 이름 : method01
	어디서나 누구나 접근가능
	정수 리턴
	인수로 정수2개 받음
	인수로 들어온 정수 2개를 곱해서 출력하고 리턴*/
	public int 	method01(int i, int j) {//5  4 
		System.out.println("두정수의 곱 = "+ (i*j) );
		return i*j;
	}
	
}
///////////////////////////////////////////////////////
 //The public type Methodinvoke02 must be defined in its own file
 /*public*/ class Methodinvoke02{
	
	//method 이름 : method02
	//어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능
	//정수 리턴
	//인수로 정수2개 받음
	
	//인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴
	 public static 	int method02(int i, int j) { //5  4
		 System.out.println("두정수의 합 = "+ (i+j) );
			return i+j;
	 }
}//
//////////////////////////////////////////////////////////////////
 public class MethodInvokeExam{
	 public static void main(String []args){
			System.out.println("시작....");
			
			Methodinvoke01 m = new Methodinvoke01();
			int re = m.method01(5, 4);//메소드 호출
            System.out.println("리턴값 = " + re);
            

            System.out.println("--static 메소드 호출 ---");
            re = Methodinvoke02.method02(5, 4);
            System.out.println("리턴값 = " + re);
            
            
            System.out.println("-----------------");
            //Methodinvoke02 m2 = new Methodinvoke02();
            
            /*
             * The static method method02(int, int) 
             * from the type Methodinvoke02 should be accessed in a static way
             * */
            //m2.method02(2, 4);
            
		}//메인끝
}
 
 
 
 
 
 
 
 
 
