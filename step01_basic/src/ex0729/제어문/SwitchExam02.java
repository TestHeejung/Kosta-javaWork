package ex0729.제어문;

public class SwitchExam02 {

	public static void main(String[] args) {
		//1~ 12사이 난수 발생 해서 변수에 담는다. 
		 int month = (int)(Math.random() * 12 + 1);
		 
		 /*
		  *발생한 난수는 월이라고 생각하고 
		  *그 월에 마지막 일수를 출력한다. 
		  * */
		 int endDay=31;
		/* switch(month) {
		   case 2 : endDay=28; break;
		   case 4 : case 6 : case 9 :  case 11 : endDay=30; break;
		   default: endDay=31;
		 }*/
		 
		 ///version 14 이후 ///////////////////////////////
		/* switch(month) {
		   case 2 : endDay=28; break;
		   case 4,6,9,11 : endDay=30; break;
		   default: endDay=31;
		 }*/
		 
		 /*switch(month) {
		   case 2 -> {
			   System.out.println("A");
			   endDay=28;
			   }
		   case 4,6,9,11 -> {
		   System.out.println("B");
		      endDay=30;
		   }
		   default-> endDay=31;
		 }*/
		 /////////////////////////////////
		/* endDay = switch(month) {
		   case 2 -> { yield 28;}
		   case 4,6,9,11 -> 30; 
		   default-> 31;
		 };*/
		 
		 /////////////////////////////////////////////
		 //위 문제를 if문변경 - 그 월에 마지막 일수를 출력한다. 
		 if(month==2) {
			 endDay=28;
		 }else if(month==4 || month==6 || month==9 || month==11) {
			 endDay=30;
		 }else {
			 endDay=31;
		 }
		 
		 
		 //모니터 출력
		 System.out.println(month+"는 " + endDay + "일 까지 있습니다.");

	}

}





