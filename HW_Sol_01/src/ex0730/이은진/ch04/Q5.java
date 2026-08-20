package ex0730.이은진.ch04;

public class Q5 {
	 public static void main(String[] args) {
		 for (int x = 1; x <= 10; x++){
			 for (int y = 1; y <= 10; y++){
				 if(4 * x + 5 * y == 60) System.out.println("(" + x + ", "+ y + ")");
			 }
		 }
	 }
}