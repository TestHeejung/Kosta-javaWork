package mvc.view;

import java.util.Scanner;

public class FailView {
	/**
     * 실패  관련된 메세지 출력 
     * @param message
     */
    public static void errorMessage(String message) {
         System.out.println(message+"\n");
    }
    
    /**
     * 비밀번호가 틀렸을 때 새로운 비밀번호를 입력 받는 메소드
     * @param count
     * @return
     */
    public static String tryPassword(int count) {
    	Scanner sc = new Scanner(System.in);
    	
	    System.out.println("비밀번호 입력 기회가 " + count + "회 남았습니다.");
	    System.out.print("비밀번호: ");
	    
	    return sc.nextLine();
    }
}
