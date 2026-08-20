package ex0810.남경은.check06;


//날짜: 26.08.10
//이름: 남경은
//주제: 확인문제 6번
public class Parent {

    //6. parent 클래스를 상속해서 child 클래스를 작성했는데 child 생성자에서 컴파일 에러가 발생한 이유와 해결법
    //이유: 자식 생성자 호출 시, 부모의 기본 생성자(super())가 호출되는데, parent 클래스에
    //인수가 없는 기본 생성자가 정의되지 않아서

    public String name;

    public Parent(){} //기본생성자 정의

    public Parent(String name) {
        this.name = name;
    }
}

