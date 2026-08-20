package ex0811.임재열.chapter8.exam;

public class RemoteControlExample {
//	public static void main(String[] args) {
//		RemoteControl rc;
//		rc=new Televison();
//		rc.trunOn();
//	}
	
	public static void main(String[] args) {
		RemoteControl rc;
		
		rc = new Televison();
		rc.trunOn();
		
		rc = new Audio();
		rc.trunOn();
	}
}
