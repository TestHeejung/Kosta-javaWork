package ex0810.남경은.check11;

//날짜: 26.08.10
//이름: 남경은
//주제: 확인문제 11번
public class MainActivity extends Activity{

    //11. Activity의 onCreate도 실행시키는 방법

    @Override
    public void onCreate(){
        super.onCreate(); //부모의 oncreate 호출
        System.out.println("추가적인 실행 내용");
    }
}
