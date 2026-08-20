package ex0729.casting;

class CastingExam{
	//실행을위해서 반드시 필요(시작점 메소드)
	public static void main(String []args){
		byte b1;
		byte b2,b3; 
		int i1=7;
		System.out.println("int i1="+i1);

		b1 = (byte)i1 ;//4byte를 1byte담을 수 없다. 캐스팅필요하다.
		System.out.println("byte b1="+b1);

		b2=20; //byte -128 ~ 127 저장가능
		System.out.println("byte b2="+b2);
		
		b3 = (byte)(b2+b1); //20 + 7

		System.out.println("byte b3="+b3); //27
		
		long lo = 56897l;
		System.out.println("long lo="+lo);

		//int i4 = (int)lo+i1; 
		int i4 = (int)(lo+i1); 
		System.out.println("int i4="+i4);
		
		boolean boo;
		 boo=false; 
		System.out.println("boolean boo="+boo);

		double d = 4.67e-3; // 0.00467
		System.out.println("double d="+d);

		float f1 = lo; //에러 발생안함
		System.out.println("float f1="+f1);
				
		
	    float f2 =(float)d;
		System.out.println("float f2="+f2);

		char c1,c2, c3;
		c1='\u0042';
		System.out.println("char c1="+c1);

		 b2 = (byte)c1; 
		System.out.println("byte b2="+b2);
		
		c2='A';
		System.out.println("char c2="+c2);
		
		
		c3=(char)(c2+2);   // "A" + 1 -> A1      'A' + 1 -> 66
		System.out.println("char c3="+c3);
		
		
	}

}