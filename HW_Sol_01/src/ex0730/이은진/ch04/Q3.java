package ex0730.이은진.ch04;

public class Q3 {
	public static void main(String[] args) {
        int sum = 0;

        for(int i=1; i <= 100; i++){
            if (i % 3 == 0) sum += i;
        }
        System.out.println("3의 배수의 총합은 " + sum + "입니다.");
    }
}