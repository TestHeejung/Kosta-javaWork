package stream.exam;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 점수가 80점 이상인 학생 목록 추출 (filter + collect)
 *   List<Student>에서 점수가 80점 이상인 학생들의 목록을 출력하시오.
 * */
public class Test03 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
        		 new Student("희정", 22, 88.5, "Computer Science"),
                 new Student("가현", 24, 76.2, "Mathematics"),
                 new Student("찬범", 23, 92.3, "Computer Science"),
                 new Student("현솔", 25, 81.7, "Physics")
        );

        
      


    }
}
