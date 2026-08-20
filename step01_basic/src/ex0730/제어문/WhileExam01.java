package ex0730.제어문;

public class WhileExam01 {
	public static void main(String[] args) {
		//1. 1 ~ 100까지 출력 
				System.out.println("1. 1 ~ 100까지 출력 ----");
				//초기화
				int i=0;
				while(i<100) {//i 가 100보다 작을 동안 돌아라.
					//i++; // i= i+1 동일	
					System.out.print( ++i +" ");
					
				}
				
				//2. A ~ Z까지 출력
				System.out.println("\n 2. A ~ Z까지 출력 ----");
				char ch='A';
				while(ch <='Z') {
					System.out.print( ch++  +"\t");
				}
				
				
				//3. 1~ 100 사이의 3의 배수의 합 구해서 출력 
				System.out.println("\n 3. 1~ 10사이의  합 구해서 출력  ----");
				i=1;//초기화
				int sum=0;
				while(i<=10) {
					sum+=i;
					i++;
				}
				System.out.println(" 총합 : " + sum);
				
				
				//4. 1~ 100을 10행 10열로 출력(while문안에 while문이용)
				System.out.println("\n 4. 1~ 100을 10행 10열로 출력(while문안에 while문이용)  ----");
			    i=0; 
				while(i<10) { //10행
					int j=1;
					while(j<=10) {//10열
						System.out.print((i*10+j)+"\t");
						j++;
					}
					System.out.println();
					i++;
				}
			
				//5. 구구단 출력 9행 8열
				System.out.println("\n 5. 구구단 출력 ----");
				int row=1;
				while(row <= 9) {//9행
					int col=2;
					while(col <= 9) {//8열
						System.out.print(col +"*" + row +"=" + (col*row)+" ");
						col++;
					}
					System.out.print("\n");
					row++;
				}
	}

}
