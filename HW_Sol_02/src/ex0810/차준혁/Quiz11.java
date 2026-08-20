package ex0810.차준혁;

public class Quiz11 {
	// MainActivity의 onCreate()를 실행할 때 Activity의 onCreate()도 실행시키고 싶습니다.
	// 밑줄에 들어갈 코드를 작성해 보세요.
	
}

class Activity {
	public void onCreate() {
		System.out.println("기본적인 실행 내용");
		
	}
}

class MainActivity extends Activity { 
	
	@Override
	public void onCreate() {
		// [     ]. onCreate();
		super.onCreate();
		System.out.println("추가적인 실행 내용");
		
	}
	
}