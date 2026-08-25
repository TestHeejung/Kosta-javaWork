package stream.ex01;

import java.util.Arrays;
import java.util.List;

public class ParalleStramExam01 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie",
				"David","Charlie","Charlie", "Charlie"); 
		
		//기존방식
		for (String name : names) { 
		    if (name.startsWith("C")) { 
		        System.out.println(Thread.currentThread().getName() + " - " + name); 
		    } 
		} 
		
		
		System.out.println("--Stream을 이용한 처리 -----------");
		//names.stream() 
		names.parallelStream()
	     .filter(name -> name.startsWith("C")) 
	     .forEach(name ->  
	         System.out.println(Thread.currentThread().getName() + " - " + name) 
	     );

	}

}
