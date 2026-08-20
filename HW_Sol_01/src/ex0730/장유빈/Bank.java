package ex0730.장유빈;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 0;//지역변수

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");
            System.out.print("선택> ");
            int menu = Integer.parseInt(sc.nextLine());// String -> int로 변환메소드

            if (menu == 1) {
                System.out.print("예금액>");
                int money = Integer.parseInt(sc.nextLine());
                balance += money;
            } else if (menu == 2) {
                System.out.print("출금액>");
                int money = Integer.parseInt(sc.nextLine());
                balance -= money;
            } else if (menu == 3) {
                System.out.println("잔고>" + balance);
            } else if (menu == 4) {
                System.out.println();
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("1~4번 중에서 선택하세요.");
            }
            System.out.println();
        }
    }//mainend
}