package ex0730.제어문;

public class DoWhileExam01 {
	public static void main(String[] args) {
		// 1. 1~100까지 출력
		int i = 1;
		do { //무조건 한번은 실행한다. 
			System.out.print(i + " ");
			i++;
		} while (i <= 100);
		System.out.println();
		
		

		System.out.println("\n 2. A~Z까지 출력====");
		// 2. A~Z까지 출력
		
		i = 65; //'A'
		do {
			System.out.print((char)i++ + " ");
			//i++;
			
		} while (i <= 90);
		
		
		System.out.println();
		
		System.out.println("\n 3. 1~10사이의 합 구해서 출력====");
		// 3. 1~100사이의 3의 배수의 합 구해서 출력
		i = 1;
		int sum = 0;
		do {
		    sum += i++; //sum = sum+i;
			//i++;
		} while (i <= 10);
		
		System.out.println(" 합 = " + sum);
		
		

		System.out.println("\n 4. 1~100을 10행 10열로 출력(do while문 안에 do while문 이용)====");
		// 4. 1~100을 10행 10열로 출력(do while문 안에 do while문 이용)
		i = 0;
		do {
			int j = 1;
			do {
				System.out.print((i + j) + " ");
				j++;
			} while (j <= 10);
			
			i += 10;//증감식 -> i=i+10     0  10 20 30 40 
			
			System.out.println();
		} while (i < 100);
		

		
		// 5. 구구단 출력
		System.out.println("\n5. 구구단 출력(9행 8열)========");
		i = 1;
		do {//9행
			
			int j = 2;
			do {//8열
				System.out.print(j + "*" + i + "=" + (j * i) + "\t");
				j++;
			} while (j <= 9);
			
			i++;
			System.out.println();
		} while (i <= 9);

	}

}
