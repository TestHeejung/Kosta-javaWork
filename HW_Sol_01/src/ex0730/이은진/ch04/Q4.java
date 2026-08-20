package ex0730.이은진.ch04;

public class Q4 {
	public static void main(String[] args) {
		while (true) {
            int num1 = (int) (Math.random() * 6) + 1;
            int num2 = (int) (Math.random() * 6) + 1;
            
            System.out.println("(" + num1 + ", " + num2 + ")");
            
            if (num1 + num2 == 5) break;
        }
        System.out.println("합이 5가 되었습니다.");
        System.out.println("종료합니다.");
	}
}