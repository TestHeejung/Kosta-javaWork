package stream.exam;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 나이가 가장 많은 학생 찾기 (max + Comparator.comparingInt)
 *   List<Student>에서 나이가 가장 많은 학생의 정보를 출력하시오.
 * */
public class Test02 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
        		 new Student("희정", 22, 88.5, "Computer Science"),
                 new Student("가현", 24, 76.2, "Mathematics"),
                 new Student("찬범", 23, 92.3, "Computer Science"),
                 new Student("현솔", 25, 81.7, "Physics")
        );

        
       

    }
}
