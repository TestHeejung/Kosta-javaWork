package ex0730.제어문;

public class ForExam02 {

	public static void main(String[] args) {
		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		System.out.println("1.1 ~ 100가지 10행 10열로 출력 --");
		
		int sum=1;
		for(int a=1; a<=10 ; a++) {//a=1 ~ 10까지 - 10행
			for(int b=1; b<=10 ; b++) {//b=1 ~ 10까지 - 10열
				System.out.print(sum++ +" ");
			}
			System.out.println();
		}
		
		System.out.println("\n.1 ~ 100가지 10행 10열로 출력 --");
		for(int a=0; a<100 ; a+=10) {//a=0 ,10,20,30,,,,100까지 - 10행
			for(int b=1; b<=10 ; b++) {//b=1 ~ 10까지 - 10열
				System.out.print( (b+a)  +" ");
			}
			System.out.println();
		}
		
		
		System.out.println("\n.2 ~ 100가지 10행 10열로 출력(for문 안에  if문이용) --");
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)
		for(int a=1; a<=100 ; a++) {
			System.out.print(a+" ");
			if(a%10==0)System.out.println();
		}

		//3. 구구단 출력  -  for 문안에 for문이용
		/*
				 * 
				 *  2*1=2  3*1=3 ..... 9*1=9
				 *  2*2=4  3*2=4  4*2=4
				 *  2*3=6
				 *  ..
				 *  
				 *  2*9=18              9*9=81
				 * 
				 * */	
		
		  for(int row=1; row <=9 ; row++) {//9행
			  for(int col=2; col<=9 ; col++) {//8열
				  System.out.print(col + "*"+ row +"="+(col*row) +"\t");
			  }
			  System.out.println();
		  }

	}

}







