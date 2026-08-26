package stream.exam;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 모든 학생 이름을 쉼표(,)로 연결 (map + collect + joining)
 *   List<Student>에서 모든 학생의 이름을 쉼표(,)로 연결하여 출력하시오.
 * */
public class Test05 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
        		 new Student("희정", 22, 88.5, "Computer Science"),
                 new Student("가현", 24, 76.2, "Mathematics"),
                 new Student("찬범", 23, 92.3, "Computer Science"),
                 new Student("현솔", 25, 81.7, "Physics")
        );

        
       




    }
}
