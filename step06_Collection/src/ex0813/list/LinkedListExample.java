package ex0813.list;

/**
 * 다음 예제는 ArrayList와 LinkedList에 10000개의 객체를 삽입하는데 
걸린 시간을 측정한 것이다.
 * 0번 인덱스에 String 객체를 10000번 추가하기 위해 
 * List 인터페이스의 add(int index, E element) 메소드를 이용하였다.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {
		//ArrayList 컬렉션 객체 생성
		List<String> list1 = new ArrayList<>();
		
		//LinkedList 컬렉션 객체 생성
		List<String> list2 = new LinkedList<String>();
		
		//시작 시간과 끝 시간을 저장할 변수 선언
		long startTime;
		long endTime;
		
		//ArrayList 컬렉션에 저장하는 시간 측정
		startTime = System.nanoTime();//10억분의 1초(개발한 프로그램의 성능 측정의 위해)
		
		for(int i=0; i< 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		
		endTime = System.nanoTime();//
		System.out.printf("%20s %8d ns \n","ArrayList 걸린 시간: ",(endTime-startTime));
		
		//LinkedList 컬렉션에 저장하는 시간 측정
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("%20s %8d ns \n","LinkedList 걸린 시간: ",(endTime-startTime));
		
		//int i = 100000000;
		int i = 1_000_000_000;
		System.out.print(i);
	}
}










