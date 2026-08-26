package stream.exam;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 전공이 'Computer Science'인 학생이 한 명이라도 있는지 확인(anyMatch)
 *  List<Student>에서 전공이 'Computer Science'인 학생이 한 명이라도 있는지 확인하고, 그 결과를 출력하시오.
 * */
public class Test10 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
        		 new Student("희정", 22, 88.5, "Computer Science"),
                 new Student("가현", 24, 76.2, "Mathematics"),
                 new Student("찬범", 23, 92.3, "Computer Science"),
                 new Student("현솔", 25, 81.7, "Physics")
        );

        
        



    }
}
