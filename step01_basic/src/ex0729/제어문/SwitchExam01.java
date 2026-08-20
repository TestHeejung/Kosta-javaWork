package ex0729.제어문;

public class SwitchExam01 {
	public static void main(String[] args) {
		//1~ 12사이 난수 발생 해서 변수에 담는다. 
		 int day = (int)(Math.random() * 12 + 1);
		
		//발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일, 4이면 수요일
		// 5이면 목요일 6이면 금요일, 이외의 수는 토요일 출력한다.
		 char ch='토';
		 
		 switch(day){// 비교대상에 표현식이 올 수 있고 그 값이 case에 비교된다.(byte, short, char, int ,  java 1.7에서 String 지원)
		    case 1 : ch='일' ; break;
		    case 2 : ch='월' ; break;
		    case 3 : ch='화' ; break;
		    case 4 : ch='수' ; break;
		    case 5 : ch='목' ; break;
		    case 6 : ch='금' ; break;
		    default : ch='토';
		}
		 
		 //모니터출력
		 System.out.println(day+"는 "+ ch +"요일");

	}

}
