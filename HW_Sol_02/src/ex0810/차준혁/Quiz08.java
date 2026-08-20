package ex0810.차준혁;

public class Quiz08 {
	// Tire 클래스를 상속받아 SnowTire 클래스를 다음과 같이 작성했습니다.
	// SnowTireExample 클래스를 실행했을 때 출력 결과를 작성해 보세요.
	
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire; // 타입 변환
		
		snowTire.run();
		tire.run(); // 실제 바라보는 객체는 sownTire
		
		/*
		 * 스노우 타이어가 굴러갑니다.
		 * 스노우 타이어가 굴러갑니다.
		 * 
		 */
		
	}
	
}

class Tire {
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
		
	}
	
}
////////////////////////////////////////////////////////
class SnowTire extends Tire {
	
	@Override
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다.");
	}
	
}