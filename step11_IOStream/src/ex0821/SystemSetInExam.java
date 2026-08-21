package ex0821;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * System.setIn(InputStream in) 메서드는 표준 입력 스트림(System.in)을 새로운 입력 스트림으로 변경할때 사용한다.
 * System.setIn()을 사용하면, 표준 입력을 원하는 InputStream으로 변경할 수 있다.
 * 파일을 입력 스트림으로 사용하거나, 테스트 자동화에서 가상의 입력을 제공할 때 활용
 * 기존 입력 스트림을 변경하므로, 필요하면 원래 상태로 복원해야 함.
 * */
public class SystemSetInExam {

	public static void main(String[] args)throws Exception {
		InputStream originalIn = System.in;  //향후 원래 대로 복원을 위한 준비
		
		//input.txt 파일의 내용을 표준 입력처럼 읽어올 수 있다
		System.setIn(new FileInputStream("src/ex0821/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
		   String data = sc.nextLine();
		   System.out.println(data);
		}
		
		 // System.in을 원래대로 복원
        System.setIn(originalIn);
		
		System.out.println("-------------------");
		 sc = new Scanner(System.in);
		System.out.print("다음 내용은?");
		String message = sc.next();
		System.out.println("message = "+message);
		
		sc.close();

	}

}
