package ex0812;

import java.io.IOException;

public class ExceptionReturnExam {

	public void aa(int i) {
		try {
			
			if(i==0) {
				//강제로 예외를 발생시켜라
				throw new RuntimeException();
				
			   //return;//메소드 빠져나가라.- finally실행한다.
				//System.exit(0);//프로그램 강제종료 - finally실행안한다.
			}
			System.out.println(i+"입니다.");
			
		}finally {
		  System.out.println("--aa 끝 ---");
		}
		
	}
	public static void main(String[] args) {
		System.out.println("**메인시작***");
		
		//new ExceptionReturnExam().aa(10);
		new ExceptionReturnExam().aa(0);
		
		System.out.println("**메인 끝 ****");

	}

}
