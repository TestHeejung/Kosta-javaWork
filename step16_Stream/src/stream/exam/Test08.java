package stream.exam;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 90점 이상 학생의 전공(Major)을 대문자로 변환하여 출력 (filter + map + collect)
 *  List<Student>에서 90점 이상인 학생들의 전공(Major)을 대문자로 변환하여 리스트로 출력하시오.
 * */
public class Test08 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
        		 new Student("희정", 22, 88.5, "Computer Science"),
                 new Student("가현", 24, 76.2, "Mathematics"),
                 new Student("찬범", 23, 92.3, "Computer Science"),
                 new Student("현솔", 25, 81.7, "Physics")
        );

        
       





    }
}
