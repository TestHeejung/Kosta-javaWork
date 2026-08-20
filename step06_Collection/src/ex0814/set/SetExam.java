package ex0814.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	//Set<String> set = new HashSet<String>();
	Set<String> set = new TreeSet<String>(Collections.reverseOrder());

	public SetExam(String [] data) {
		for(String s : data) {
			//데이터 추가
			boolean re = set.add(s); //중복안된다!!
			System.out.println(s+"의 값 add 후 결과 = " + re);
		}
		
		System.out.println("최종결과 = " + set);//set.toString() 
		System.out.println("저장된 개수 = " + set.size());
		
		//요소를 하나씩 꺼내보자 
		System.out.println("--요소를 하나씩 꺼내보자---");
		
		//Iterator는 자료구조안에 있는 데이터를 꺼낼수 있는 메소드 제공
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){//hasNext()는 다음요소가 있다면  true리턴
	    	String s = it.next();
		    System.out.println(s);
		}
		
		/////////////////////////////////////
		System.out.println("--개선된 for 변경 ---");
		for(String s : set) {
			System.out.println(s);
		}
		
		System.out.println("---요소 제거하기 ---");
		boolean re = set.remove("미미2");
		System.out.println("re = "+ re);
		
		System.out.println("제거 후 = " + set);
		
		re=set.contains("희정");
		System.out.println("re = "+ re);
		
		
	}
	public static void main(String[] args) {
		new SetExam(args);

	}

	
	
}



