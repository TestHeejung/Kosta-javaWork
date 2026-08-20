package ex0810.남경은.check10;

//날짜: 26.08.10
//이름: 남경은
//주제: 확인문제 10번
public class Computer extends Machine {

    //10. Computer 클래스에서 컴파일 에러가 발생하는 이유
    // 에러가 나는 이유 :
    // 추상 클래스를 상속 받는 자식 클래스는 추상 메서드를 구현해야 하는데, 구현하지 않았기 때문에 에러가 남
    // 아래와 같이 코드를 추가해야 함 or 자식 클래스도 abstract

    @Override
    public void work() {

    }
}
