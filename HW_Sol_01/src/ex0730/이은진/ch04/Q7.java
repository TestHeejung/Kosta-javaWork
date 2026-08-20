package ex0730.이은진.ch04;
import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int balance = 0;
		
		outer:
		while(true) {
			System.out.println("----------------------------------------");
			System.out.println("1. 예금 | 2.출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------------");
			
			System.out.print("선택> ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1: {
					System.out.print("예금액> ");
					balance += sc.nextInt();
					break;
				}
				case 2: {
					System.out.print("출금액> ");
					balance -= sc.nextInt();
					break;
				}
				case 3 : {
					System.out.println("잔고> " + balance);
					break;
				}
				case 4: {
					System.out.println();
					System.out.println("프로그램 종료");
					System.exit(0);
					//break outer;
					//break;//switch 문 탈출
				}
				default: 
					System.out.println();
					System.out.println("메뉴를 다시 골라주세요.");
			}
			System.out.println();
		}
	}
}