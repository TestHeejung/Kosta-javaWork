package ex0729.제어문;

public class IfExam01 {
	public static void main(String[] args) {
		//난수발생
		double nansu = Math.random(); // 0.0 ~~ 0.99999사이의 임의수 를 만든다.
        System.out.println("전 nansu = " + nansu);
        
        //1~ 10사이
        nansu = nansu*10  + 1;
        System.out.println("후 nansu = " + nansu);
        
        int convertNansu = (int)nansu;
        System.out.println("convertNansu = " + convertNansu);
		
		//1. 정수형 변수를 선언하고 적당히 초기화한다.
		 int no =  (int)(Math.random()*56 + 45); // 45~ 100사이의 난수 저장
		
		//2. 선언한 정수의 값이 짝수이면 짝입니다. 아니면 홀수입니다. 출력
		 if(no%2==0) {
			 System.out.println(no+"는 짝수");
		 }else {
			 
			 System.out.println(no+"는 홀수");
		 }
		

	}

}
