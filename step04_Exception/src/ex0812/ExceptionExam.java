package ex0812;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("***Exception Test ***");
		System.out.println("args = " + args);
		try {
		  System.out.println("args[0] = " + args[0]);
		  
		   int convertNo= Integer.parseInt(args[0]);
		   System.out.println("숫자로 변환 = "+ convertNo);
		   
		   int result = 100/ convertNo;
		   System.out.println("나눈결과 = " + result);
		  
		 //catch 여러개 작성할때는 반드시 서브클래스 먼저 작성성한다.  
		}catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			//e 를 출력하면 발생한예외클래스이름:발생한예외메시지
			System.out.println("인수의 값을 전달해주세요~ => " + e);//e.toString()호출
		}catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요 => " + e.getMessage());
		}catch (Exception e) {
			System.out.println("예외가 발생했어요~~");
			
			//개발할때는 사용하지만 배포(운영production환경)모드에서 모두 제거 필수!
			e.printStackTrace();//개발자를 위한 메소드(예외정보를 detail하게  추적할수있다.)
		}finally {
			System.out.println("예외발생여부 상관없이 무조건 실행되어요~");
		}
		
		System.out.println("***Exception End ***");

	}

}





