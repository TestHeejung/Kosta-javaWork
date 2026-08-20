package ex0729.연산자;
class MathOperatorExam{
	public static void main(String []args){
		int i=5;
		int j=2;
		System.out.println("i+j=" + (i + j) );
		System.out.println("i-j="+ (i-j));
		System.out.println("i*j="+ (i*j));
		System.out.println("i/j="+ (i/j));
		System.out.println("i%j="+ (i%j));

		System.out.println("i="+i);//5
		
		int k = i++; //선대입 후증가 
		System.out.println("k="+k);
		System.out.println("i="+i);
		
		int p=++i;//선증가  후대입
		System.out.println("p="+p);
		System.out.println("i="+i);

		int x = 19 + 4 * 3 / 2 - 10 * 2 + 4;

		System.out.println("19+4*3/2-10*2+4="+x);
		
		System.out.println("---------------------");
		
		System.out.println("x = " + ++x   +" , " + x++ );
		System.out.println(x);
		
		x+=10; // x = x+10;
		System.out.println(x); //21
		
	}	
}







