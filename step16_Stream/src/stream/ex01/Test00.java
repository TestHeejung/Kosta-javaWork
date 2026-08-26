package stream.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class Test00 {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList( 
                new Student("희정", 22, 88.5, "Computer Science"), 
                 new Student("가현", 24, 76.2, "Mathematics"), 
                 new Student("찬범", 23, 92.3, "Computer Science"), 
                 new Student("현솔", 25, 81.7, "Physics") 
        ); 
		
		
		/* 문제
		 *  : 점수가 80이상인 학생 -> 점수를 기준으로 오름차순 -> 이름 모아서 List로 만들자.
		 */
		
		List<Student> scoreList = new ArrayList<Student>();
		
		//1.기존방식
		for(Student st : students) {
			if(st.getScore() >=80) scoreList.add(st);
		}
		
		Collections.sort(scoreList, (s1, s2)->{
			 double re = s1.getScore() - s2.getScore();
			 
			if(re==0.0) return 0;
			else if (re > 0.0) return 1;
			else return -1;
			
		});
		
		List<String> names = new ArrayList<String>();
		for(Student st : scoreList) {
			names.add(st.getName());
		}
		
		//출력
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println("------------------");
		////////////////////////////////////////////////////////
		/* 문제
		 *  : 점수가 80이상인 학생 -> 점수를 기준으로 오름차순 -> 이름 모아서 List로 만들자.
		 */
	   //2.Stream이용방식으로 해보자(stream얻기 -> 중간과정 반복-> 최종연산) 
		/*students
		.stream()
		.filter(new Predicate<Student>() {
			 @Override
			public boolean test(Student t) {
				
				return t.getScore() >=80;
			}
		});*/
		
	List<String> namesList = students
					         .stream()
							 .filter((s)-> s.getScore()>80)
							 //.sorted(Comparator.comparingDouble((s)->s.getScore()));
							 .sorted(Comparator.comparingDouble(Student:: getScore))
							 //.map((s)->s.getName());
							 .map(Student:: getName)
							 .toList();
	
	System.out.println("개수 = "+ namesList.size());
	System.out.println(namesList);
		
	
	}

}














