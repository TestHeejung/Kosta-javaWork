package ex0812;

public class ThrowsException {
	
    public void aa(int i)throws ArithmeticException {
    	System.out.println("aa 시작");
    	try {
    	  this.bb(i);
    	}finally {
    	  System.out.println("aa 끝");
    	}
    }
    
    public void bb(int i) throws ArithmeticException {
        System.out.println("bb 시작");
        try {
	    	//try {
		        int result = 100/i; //ArithmeticException가능성
		        System.out.println("나눈 결과 = " + result);
	    	//}catch (ArithmeticException e) {
			//	e.printStackTrace();
			//}
        }finally {
    	  System.out.println("bb 끝");
        }
    	
    }

	public static void main(String[] args)/*throws ArithmeticException*/ {
		System.out.println("***메인 시작 ****");
		
		ThrowsException te = new ThrowsException();
		try {
		  te.aa(0);
		}catch (ArithmeticException e) {
			System.out.println("메인이 예외처리 했어요.");
			//e.printStackTrace();
		}
		System.out.println("***메인 끝 ****");

	}

}







