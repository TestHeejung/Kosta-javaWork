package ex0729.이금배.ch03;



public class Exam03 {

	public static void main(String[] args) {
		//1. 다음 코드를 실행 했을 때 출력 결과를 작성해 보세요.
	    //  z = 11 + 20 = 31 
		/*int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);
		*/
		
		//2. 다음 코드를 실행 했을 때 출력 결과를 작성해 보세요.
		// ??
		int score = 85;
		String result = (!(score>90))? "가":"나";
		System.out.println(result);
		
		//3.
		
		int pencils = 534;
		int students = 30;
		
		//학생 한 명이 가지는 연필 수
		int pencilsPerStudents = pencils / students;
		System.out.println(pencilsPerStudents);
		
		//남은 연필수
		int pencilsleft = pencils % students;
		System.out.println(pencilsleft);
		
		//4.
		int value = 350;
		System.out.println(value/100*100); 
		
		//5. 사다리꼴 넓이 구하는 코드
		// 4번
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (double)((lengthTop + lengthBottom) * height / 2);
				
		//6. 연산식의 출력결과
		
		int X = 10;
		int Y = 5;
		System.out.println((X>7) && (Y<=5)); //true
		System.out.println((X % 3 == 2) || (Y % 2 != 1)); //false
		
		//7. ( ) 코드작성
		
		/*double x = 5.0;
		double y = 0.0;
		double z = 5 % y;
		
		if (  ?  ) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		}else {
			double result = z + 10;
			System.out.println("결과 : " + result);
		}*/
		

	}

}
