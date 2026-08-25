package stream.ex05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GroppingStreamExam {

	public static void main(String[] args) {
		 List<Student> students = Arrays.asList( 
		            new Student("희정", 22, 88.5, "Computer Science"), 
		            new Student("찬범", 24, 76.2, "Mathematics"), 
		            new Student("가현", 23, 92.3, "Computer Science"), 
		            new Student("현솔", 25, 81.7, "Physics"), 
		            new Student("현준", 21, 85.4, "Mathematics") 
		       );
		
		
		 System.out.println("1. 전공별 그룹핑......");
		
		
		
		System.out.println("2. 전공별 학생수 계산(counting)- {Computer Science=2, Mathematics=2, Physics=1}");
		
		
		
		System.out.println("3. 전공별 점수의 평균(ex) {Computer Science=90.4, Mathematics=80.80000000000001, Physics=81.7})");
		
		

	}

}

















