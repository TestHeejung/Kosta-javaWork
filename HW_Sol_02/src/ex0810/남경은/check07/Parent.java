package ex0810.남경은.check07;

//날짜: 26.08.10
//이름: 남경은
//주제: 확인문제 7번
public class Parent{

    //7. parent 클래스를 상속받아 child클래스를 다음과 같이 작성했을때,
    // childexample 클래스 실행했을때 호출되는 각 클래스의 생성자의 순서를 생각하면서 출력결과 작성
    public String nation;

    public Parent(){
        this("대한민국");
        System.out.println("Parent() call");
    }

    public Parent(String nation){
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}
