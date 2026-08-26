package stream.ex02;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String[] args) {
		System.out.println("1.String Array Stream ------------");
		String [] strArr = {"희정","현준","정화","민지","경찬"};
		for(String s:strArr) { //자료구조의 Iterator를 이용한 방식
			System.out.println(s);
		}
		
		System.out.println("---Stream 이용 ---");
		//Stream을 이용해서  출력해보자
		Stream<String> stream = Arrays.stream(strArr);
		
		 //1) 람다식
		/*stream.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
		});*/
		
		//stream.forEach((t)->System.out.println(t));
		
		System.out.println("---메소드 참조 ----");
		//2) 메소드 참조
		stream.forEach(System.out:: println);
		
		
		//3) 한번 사용한 Stream을 다시 사용해보자(사용불가x)
		
		
		System.out.println("2.int Array Stream ------------");
		int [] intArr = {1,2,3,4,5,6,7,8,9};
		Arrays
		.stream(intArr)
		.filter((i)-> i%2==0)
		.forEach(System.out::println);
		
		
		System.out.println("3.range()  vs rangeClosed() ------------");
		IntStream.
		range(0, 10)
		.forEach(System.out::println);
		
	    System.out.println("----------------");
		
		//1~10의 합을 구한다.
	    int re = IntStream.rangeClosed(1, 10).sum();
	    System.out.println("결과 = " + re);
		

	}

}









