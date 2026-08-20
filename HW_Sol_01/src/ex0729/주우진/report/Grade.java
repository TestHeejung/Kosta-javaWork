package ex0729.주우진.report;

public class Grade {

	public static void main(String[] args) {
		/*
		 * 국어, 영어, 수학 점수는 45 ~ 100사이의
      난수를 발생해서 저장한다.

      학점
        A : 90 ~100사이
        B: 80 ~ 89
        C : 70 ~ 79
        D : 60 ~ 69 
        F : 나머지 점수...

      위 학점을 if문,  switch문 각각해본다.
      */
		String name = "John";
		int kor = (int)(Math.random()*56 + 45);
		int eng = (int)(Math.random()*56 + 45);
		int math = (int)(Math.random()*56 + 45);
		int total = kor + eng + math;
		double avg = total / 3.0;
		
		
		
		/*switch문*/
		char grade = switch ((int)(avg/10)) {
			case 10, 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
		
		/*if문*/
//		if(avg >= 90) grade = 'A';
//		else if(avg >= 80) grade = 'B';
//		else if(avg >= 70) grade = 'C';
//		else if(avg >= 60) grade = 'D';
//		else grade = 'F';
		
		//소숫점 자리 처리
		System.out.println("전 : avg =" + avg);
		
		avg = (int)(avg*100) / 100.0;
		
		System.out.println("후 : convertAvg =" + avg);
		
		
		
		System.out.println("이름 : "+ name + "\n국어 : " + kor + "\n영어 : " + eng + "\n수학 : " + math + "\n총점 : " + total + "\n평균 : " + avg + "\n학점 : " + grade);
	}

}







