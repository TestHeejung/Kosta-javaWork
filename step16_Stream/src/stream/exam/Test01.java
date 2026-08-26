package stream.exam;
import java.util.*;
import java.util.stream.*;

/**
 * 평균 점수 구하기 (filter + mapToDouble + average)
 *  List<Student>에서 전공이 "Computer Science"인 학생들의 평균 점수를 구하시오.
 * */
public class Test01 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("희정", 22, 88.5, "Computer Science"),
            new Student("가현", 24, 76.2, "Mathematics"),
            new Student("찬범", 23, 92.3, "Computer Science"),
            new Student("현솔", 25, 81.7, "Physics")
        );

       

       // System.out.println("Computer Science 전공 평균 점수: " + ?);
    }
}
