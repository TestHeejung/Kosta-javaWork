package ex0810.남경은.check12;

//날짜: 26.08.10
//이름: 남경은
//주제: 확인문제 12번
public class Example {

    //12.매개값이 c일경우에만 method02가 호출되도록 하는 코드 완성하기
    public static void action(A a){

        a.method1();

        if(a instanceof C c){ //타입 확인
            c.method02();
        }
    }
    public static void main(String[] args) {
        action(new A());
        action(new B());
        action(new C());
    }
}
