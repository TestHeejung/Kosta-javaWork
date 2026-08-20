package ex0731.유정현.report;

import java.util.Scanner;

/**
 *  성적 계산을 담당하는 클래스
 */
class ScoreProgram {

    /** 1. 총점 구하기
     * 
     * @param : 국어, 영어,수학
     * @return : 국어,영어,수학을 더한 결과 리턴된다.
     * */
    private int total(int kor, int eng, int math) {
        return kor + eng + math;
    }

    /**
     *  2. 평균 구하기
     * @param total
     * @param subjectCount
     * @return
     */
    private double average(int total, int subjectCount) {
        return (double) total / subjectCount;
    }

    /**
     *  3. 등급 구하기
     * @param average
     * @return
     */
    private char grade(double average) {

        switch ((int) average / 10) {
        case 10:
        case 9:
            return 'A';
        case 8:
            return 'B';
        case 7:
            return 'C';
        case 6:
            return 'D';
        default:
            return 'F';
        }
    }

    // 4. 성적표 출력하기
    public void printScore(String name, int kor, int eng, int math) {

        int totalScore = this.total(kor, eng, math);
        
        double avg = average(totalScore, 3);
        
        char gradeResult = grade(avg);

        System.out.println("====================");
        System.out.println("이름 : " + name);
        System.out.println("국어 : " + kor);
        System.out.println("영어 : " + eng);
        System.out.println("수학 : " + math);
        System.out.println("총점 : " + totalScore);
        System.out.println("평균 : " + avg);
        System.out.println("등급 : " + gradeResult);
        System.out.println("====================");
    }
}

// 메인 메서드를 가진 클래스
public class ReportExamV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScoreProgram scoreProgram = new ScoreProgram();
        
        boolean state=true;
        while (state) {

            System.out.println("1. 성적표 구하기");
            System.out.println("2. 종료");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();

            switch (menu) {

            case 1:
                System.out.print("이름 입력 : ");
                String name = sc.next();

                System.out.print("국어 점수 : ");
                int kor = sc.nextInt();

                System.out.print("영어 점수 : ");
                int eng = sc.nextInt();

                System.out.print("수학 점수 : ");
                int math = sc.nextInt();
                
                scoreProgram.printScore(name, kor, eng, math);
                break;

            case 2:
                System.out.println("프로그램을 종료합니다.");
                sc.close();
               // return ;//함수=메소드를 빠져나가라.
                state=false;
                break;
            default:
                System.out.println("1번 또는 2번을 입력하세요.");
            }//switch end
        }//while end
    }//main end
}//class end