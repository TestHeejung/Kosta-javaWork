package ex0810.남경은.check07;

//날짜: 26.08.10
//이름: 남경은
//주제: 확인문제 7번
public class Child extends Parent{

    public String name;

    public Child(){
        this("홍길동");
        System.out.println("Child() call");
    }

    public Child(String name){
        this.name = name;
        System.out.println("Child(String name) call");
    }
}
