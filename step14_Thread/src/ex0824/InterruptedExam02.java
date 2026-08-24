package ex0824;

public class InterruptedExam02 {

	public static void main(String[] args) {
		System.out.println("****메인 시작합니다.****");
		
		Thread th1 = new Thread(()->{
			
				while(true) {
					if(Thread.interrupted()) {
						break;
					}
					System.out.println("곧 집에간다~~~~");
					 
				}
			
		});
		th1.start();
		
		
		try {
		 Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//3초 후에 th1스레드 멈추게하고 싶다!!!
		th1.interrupt(); //InterruptedException 발생하려면 잠시라도 일시정지상태가 되어야 한다.
		
		
		System.out.println("****메인 종료합니다.****");

	}

}
