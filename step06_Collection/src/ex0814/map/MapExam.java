package ex0814.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExam {
    Map<String, Integer> map = new HashMap<String, Integer>();
	//Map<String, Integer> map = new TreeMap<String, Integer>();
    
    public MapExam() {
    	//추가
    	map.put("희정", 10);
    	map.put("미미", 20);
    	map.put("동혁", 10);
    	map.put("가현", 30);
    	map.put("미미", 30); //key가 중복되면 수정된다)
    	
    	System.out.println("저장된 개수 = "+map.size());
    	System.out.println("map = "+ map);
    	
    	System.out.println("--key와  value 분리 ----");
    	
    	//먼저 key의 정보들을 추출한다.
    	 Set<String> keys = map.keySet();
    	 Iterator<String> it = keys.iterator();
    	 while(it.hasNext()) {
    		 String key = it.next();
    		 Integer value = map.get(key);
    		 System.out.println(key +" = " + value);
    	 }
    	 
    	 System.out.println("---개선된 for -----");
    	 for(String key  : map.keySet() ) {
    		 Integer value = map.get(key);
    		 System.out.println(key +" = " + value);
    	 }
    	 
    	 System.out.println("--Entry 형태로 조회 하기 ----");
    	Set<Map.Entry<String, Integer>> set = map.entrySet();
    	
    	for(Map.Entry<String, Integer> e : set ) {
    		String key = e.getKey();
    		Integer i = e.getValue();
    		System.out.println(key+"==> "+ i);
    	}
    	
    	//삭제 
    	Integer re= map.remove("희정2"); //리턴한 값은 삭제된 객체를 리턴해준다.
    	 System.out.println("re = " + re);
    	 
    	System.out.println("map = " + map);
    	
    	
    }
    
	public static void main(String[] args) {
		new MapExam();

	}

}






