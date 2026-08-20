package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam01 extends ArrayList<Integer> {
    public ListExam01() {
    	super(5);//5개 공간을 만든다.
    	
    	//데이터를 추가
    	super.add(5);
    	this.add(10);
    	add(3);
    	add(7);
    	add(1);
    	add(2);
    	add(8);
    	add(9);
    	
    	
    	//몇개 저장했는지 알고싶다.
    	System.out.println("저장된 객체의 개수 = " + super.size());
    	
    	//요소 꺼내기
    	for(int i=0; i< super.size() ; i++) {
    	    int value = super.get(i);
    	    System.out.println(value);
    	}
    	
    	System.out.println("--개선된 for--");
    	//개선된 for
    	for(int i : this) {
    		System.out.println(i);
    	}
    	
    	System.out.println("this = "+ this);//this.toString()호출된다.
    	
    	//제거
    	super.remove(2);//index로 제거
    	System.out.println("제거 후 this = "+ this);
    	
    	//정렬
    	Collections.sort(this);//올림차순
    	System.out.println("정렬 후 this = "+ this);
    	
    	//내림차순으로 정렬
        Collections.sort(this, Collections.reverseOrder());
        System.out.println("정렬 후 this = "+ this);
    
    }
	public static void main(String[] args) {
		new ListExam01();

	}

}









