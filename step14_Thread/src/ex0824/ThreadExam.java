package ex0824;

import java.util.Random;

public class ThreadExam {
	public static void main(String[] args) {
		System.out.println("*** 메인 시작합니다. ****");
		
		NumberThread th1 = new NumberThread("첫번째 Thread");
		NumberThread th2 = new NumberThread("두번째 Thread");
		
		AlphaThread alpha = new AlphaThread();
		Thread th3 = new Thread(alpha, "세번째 Thread");
		
		//run을 직접호출하면 싱글메인스레드로 동작한다.
		/*th1.run();
		th2.run();
		th3.run();*/
		
		//각 thread의 start()를 호출해서 실행준비 상태로 만든다.
		//실행준비상태에 있는 스레드중에 가장 우선순위가 높은
		//스레드가 runing 상태가 되어 일을 한다.- 서로 번갈아가면서..
		th1.start();
		th2.start();
		th3.start();
		/*try {
		  th1.join();//th1스레드가 마무리 할때까지 현재스레드(메인) 정지상태
		
		}catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		  
		System.out.println("총합 = " + th1.sum );
		
		System.out.println("*** 메인 끝입니다. ****");

	}

}
///////////////////////////////////////////////
/**
 * 1~ 100까지 출력하는 스레드 -  상속
 * */
class NumberThread extends Thread{
	int sum;
	public NumberThread(String name) {
		super(name);
	}
	
	/**
	 * Thread로 작업할 기능 작성 - run()메소드 재정의 
	 * */
	@Override
	public void run() {
		Random r = new Random();
		for(int i=0; i<=100 ; i++) {
			System.out.println(super.getName() + "==> "+ i);
			sum+=i;
			
			int no = r.nextInt(100); //0 ~ 99
			
			/*try {
			  Thread.sleep(no);//no초 대기
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();//양보하는것으로 현재 스레드가 Runnable상태로 간다.
		}
		System.out.println(super.getName()+" End~~~~");
	}
}
///////////////////////////////////////////////////////////////////

/**
 * A~Z 출력하는 스레드  - 구현 
 * */
class AlphaThread implements Runnable{
	@Override
	public void run() {
		Thread th = Thread.currentThread();
		
		for(char ch='A' ; ch <='z' ; ch++) {
			System.out.println(th.getName()+"==> " + ch);
			/*try {
			  Thread.sleep(10);//0.01초대기 
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();
		}
		System.out.println(th.getName()+"End ---");
	}
	
}














