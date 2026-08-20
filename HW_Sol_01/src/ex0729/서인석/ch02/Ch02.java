package ex0729.서인석.ch02;

public class Ch02 {
    public static void main(String[] args) {
        int v1 = 1;
        System.out.println("v1 = " + v1);   // v1 == 1

        if(true) {
            int v2 = 2;
            if(true) {
                int v3 = 2;
                System.out.println("v1 = " + v1);   // v1 == 1
                System.out.println("v2 = " + v2);   // v2 == 2
                System.out.println("v3 = " + v3);   // v3 == 3
            }
            System.out.println("v1 = " + v1);   // v1 == 1
            System.out.println("v2 = " + v2);   // v2 == 2
           //System.out.println("v3 = " + v3);   // error why? 2번째 if문 안에서만 유효
        }
        System.out.println("v1 = " + v1);   // v1 == 1
//        System.out.println("v2 = " + v2);   // error why? 첫번째 if문 안에서만 유효
    }
}
/**
 * if문 안에서 선언된 변수가 밖에서는 동일하게 선언되어 있지도 않고 사용 할 수도 없다
 * */