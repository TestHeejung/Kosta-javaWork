package ex0824;

public class DaemonThreadExam03 {

	public static void main(String[] args) {
		System.out.println("****메인 시작합니다.****");
		
		Thread th1 = new Thread(()->{
				while(true) {
					System.out.println("곧 집에간다~~~~"); 
					try {
					  Thread.sleep(500);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
		});
		
		th1.setDaemon(true);//메인스레드가 종료될때 th1스레도 함께 종료된다
		
		th1.start();
		
		
		try {
		 Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("****메인 종료합니다.****");

	}

}
