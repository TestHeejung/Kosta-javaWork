package ex0812.shop;
/**
 * 나이가 18보다 작을때 발생시킬 예외 클래스 
 * */
public class NoKidsException extends Exception {//체크예외 이므로 예외처리 필수 
//public class NoKidsException extends RuntimeException {//비체크예외 이므로 예외처리 선택
	
	static int count;
   public NoKidsException() {
	  super("애들은 안돼요~~");
	  count++;
   }
   
   public NoKidsException(String message) {
	   super(message);
	   count++;
	   
   }
   
}
