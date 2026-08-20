package ex0729.서인석.ch03;

public class Ch03 {
    public static void main(String[] args) {
        // 1번 출력 결과
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);  // z = 11 + 20
        System.out.println("z = " + z); // 31

        /// ///////////////////////////////////////////////////////////////////////////////////////////
        // 2번 출력 결과
        int score = 85;
        String result = (!(score > 90)) ? "가" : "나";    // (!(false)) => (true) ! 얘가 반대로 부정의 의미
        System.out.println("result = " + result);   // 가 정답

        /// ///////////////////////////////////////////////////////////////////////////////////////////
        // 3번 출력 결과
        int pencils = 534;
        int students = 30;

        // 학생 한 명ㅇ ㅣ가지는 연필 수
        int pencilsPerStudents = pencils / students;    // 534 / 30
        System.out.println("pencilsPerStudents = " + pencilsPerStudents); // 17
        
        // 남은 연필 수
        int pencilsLeft = pencils % students;   // 534 % 30
        System.out.println("pencilsLeft = " + pencilsLeft); // 24

        /// ///////////////////////////////////////////////////////////////////////////////////////////
        // 4번 출력 결과
        int value = 356;
        System.out.println("value = " + (value - 56));    // 따로 변수 지정 하지 않고 -56을 한다.

        /// ///////////////////////////////////////////////////////////////////////////////////////////
        // 5번 출력 결과
        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        double area = ((lengthTop+lengthBottom)*height) / 2;    // 사다리꼴 공식 (윗변 + 아랫변)*높이 / 2
        System.out.println("area = " + area);   // 정답은 50

        /// ///////////////////////////////////////////////////////////////////////////////////////////
        // 6번 출력 결과
        int x1 = 10;
        int y1 = 5;
        System.out.println( (x1 > 7) && (y1 <= 5) );   // 10 > 7 == (true) &&  5 <= 5 (true) == true 두개 다 만족하여 true
        System.out.println( (x1 % 3 == 2) || (y1 % 2 != 1) );    // 10 % 3 == 1 (fasle) || 5 % 2 != 1 (false) == false
        // 정답은 1. true, 2. false

        /// ///////////////////////////////////////////////////////////////////////////////////////////
        // 7번 출력 문제
        double x2 = 5.0;
        double y2 = 0.0;
        double z2 = 5 % y2;   // 5 / 0.0 == NaN
        if (Double.isNaN(z2)) {   // 어떤 수도 0으로 나눌 수 없음. 결과값은 NaN ==> 처리방법은 조건식에 Double.isNaN(변수) 로 치환
            System.out.println("0.0으로 나눌 수 없습니다.");
        } else {
            double result1 = z2 + 10;
            System.out.println("result1 = " + result1); // 정답은 41
        }


    }

}
