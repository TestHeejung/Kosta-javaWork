package ex0821;

class Test implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("close 호출됨...^^");
	}
}

////////////////////////////////////////////
public class AutoCloseableExam {
	public static void main(String[] args) {
		System.out.println("---시작하기 ---");
		/*Test t=null;
		try {
			t= new Test();
			System.out.println("되니?");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			  t.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
		///////////////////////////////////////////////
		
		try(Test t = new Test();){
			
			System.out.println(t);
			System.out.println("즐거운 금요일!!");
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---끝 ---");
	}

}
