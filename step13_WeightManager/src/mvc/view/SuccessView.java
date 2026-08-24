package mvc.view;

import java.util.Scanner;

import mvc.dto.Profile;

/**
 * 사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스 
 */
public class SuccessView {
	
	/**
	 * 전달받은 프로필(이름, 몸무게) 출력
	 * @param profile
	 */
    public static void printWeight(Profile profile) {
    	System.out.println("**************************************************");
    	System.out.println("\t" + profile.getName() + "님의 몸무게는 " + profile.getWeight() + "kg 입니다.");
    	System.out.println("**************************************************");
    	System.out.println();
    }
    
    /**
     * 전달받은 프로필(이름, 비밀번호) 출력
     * @param profile
     */
    public static void printPassword(Profile profile) {
    	System.out.println("**************************************************");
    	System.out.println("\t" + profile.getName() + "님의 비밀번호는 " + profile.getPassword() + " 입니다.");
    	System.out.println("**************************************************");
    }
    
    /**
     * 몸무게 변경을 위해 키보드 입력 처리하는 메소드
     * @return
     */
    public static int getNewWeight() {
    	Scanner sc = new Scanner(System.in);
    	
	    System.out.println("변경할 몸무게를 입력하여 주십시오.");
	    System.out.print("변경할 몸무게: ");
	    
	    return Integer.parseInt(sc.nextLine());
    }
    
    /**
     * 비밀번호 변경을 위해 키보드 입력 처리하는 메소드
     * @return
     */
    public static String getNewPassword() {
    	Scanner sc = new Scanner(System.in);
    	
	    System.out.println("변경할 비밀번호를 입력하여 주십시오.");
	    System.out.print("변경할 비밀번호: ");
	    
	    return sc.nextLine();
    }

    /**
     * 성공에 관련된 메세지 출력 
     * @param message
     */
    public static void printMessage(String message) {
         System.out.println(message+"\n");
    }
}
