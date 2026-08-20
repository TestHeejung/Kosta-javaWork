package ex0729.서인석.report;

public class Report {
    public static void main(String[] args) {
        String str = "서인석";
        int kor = (int)(Math.random()*56 + 45); // 45 ~ 100
        int eng = (int)(Math.random()*56 + 45);
        int mat = (int)(Math.random()*56 + 45);

        int score = kor + eng + mat;
        double avg = (kor + eng + mat) / (double)3;
        char grade='F';

        if(avg >= 90) {
            grade = 'A';
        } else if (avg >= 80 ) {
            grade = 'B';
        } else if (avg >= 70 ) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        }/* else {
            grade = 'F';
        }*/

        System.out.println("-------------------------------------------------------------");
        System.out.println("** 국어점수는 " + kor + ", 영어점수는 " + eng + ", 수학점수는 " + mat);
        System.out.println("-------------------------------------------------------------");
        System.out.println("** 총점은 " + score + ", 평균점수는 " + avg + ", 학점은 " + grade);
        System.out.println("-------------------------------------------------------------");
    }
}
