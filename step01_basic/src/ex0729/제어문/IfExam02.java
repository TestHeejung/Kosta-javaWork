package ex0729.제어문;

public class IfExam02 {
	public static void main(String[] args) {
		//1~ 12사이 난수 발생 해서 변수에 담는다. 
		 int day = (int)(Math.random() * 12 + 1);
		
		//발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일, 4이면 수요일
		// 5이면 목요일 6이면 금요일, 이외의 수는 토요일 출력한다.
		 
		 String yoil="토";
		 
		 if(day==1)yoil="일";
		else if(day==2)yoil="월";
		else if(day==3)yoil="화";	
		else if(day==4)yoil="수";
		else if(day==5){
			yoil="목";
		}else if(day==6){
			yoil="금";
		}/*else{
			yoil="토";
		}*/
		 
		 //모니터 출력
		 System.out.println(day + "는 " + yoil +"요일");

	}

}
