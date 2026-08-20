package ex0805.constructor.goods;
import java.util.Scanner;
/**
 키보드 입력을 받아 각 기능을 호출해줄 View
*/
public class MenuView{

 private Scanner sc = new Scanner(System.in);
 private GoodsService service = new GoodsService(); //전역변수 초기화

  /**
    전체 메뉴를 출력하는 메소드 
  */
  public void printMenu(String [][] data){

      //전달 받은 초기치 데이터를 서비스에 전달해서 배열에 저장한다.
      service.init(data);


	  while(true){
         System.out.println("---------------------------------------------------------------------------");
		 System.out.println("1.등록     2.전체검색      3.상품코드검색    4. 수정하기     9.종료");
		 System.out.println("----------------------------------------------------------------------------");

         System.out.print("메뉴 선택 > ");
		 int menuChoice = Integer.parseInt( sc.nextLine());

		 switch(menuChoice){
             case 1 : 
				 this.inputInsert() ; break;
			 case 2 : 
				 Goods [] goodsArr = service.selectAll(); 
			     EndView.printSelectAll(goodsArr);
			      break;
			 case 3 : 
				 this.inputSelectByCode(); break;
			 case 4 : 
				 this.inputUpdate() ; break;
			 case 9 : 
				 System.out.println("다음에 또 이용해ㅜㅈ세요. 프로그램 종료합니다.");
				 System.exit(0); 
			 break;
			 default: System.out.println("메뉴는 1~4 or 9 만 입력해주세요.");

		 }//switch문

	  }//while문

  } //printMenu끝

  /**
     등록관련 키보드 입력
  */
  public void inputInsert(){
       //키보드입력 4개 받기 
	   System.out.print("상품코드 > ");
	   String code = sc.nextLine();

	   System.out.print("상품이름 > ");
	   String name = sc.nextLine();

	   System.out.print("상품가격 > ");
	   int price = Integer.parseInt(sc.nextLine());

	   System.out.print("상품설명 > ");
	   String explain = sc.nextLine();


	 //생성자를 추가하여 값을 전달하자(데이터 초기화)
      // Goods goods = new Goods();

	   int result = service.insert(null);

	   if(result==-1)
		  EndView.printMessage("더이상 등록할 수 없습니다.");
	   else if(result==0)
		  EndView.printMessage(code+"는 중복이므로 등록할수 없습니다.");
	   else 
           EndView.printMessage("상품이 등록되었습니다.");
  }

  /**
    상품코드 검색 키보드 입력
  */
  public void inputSelectByCode(){
       System.out.print("검색하려는 상품코드 > ");
	   String code = sc.nextLine();

	  Goods goods = service.selectByCode( code );
	  if(goods==null){
          EndView.printMessage(code+"는 잘못되어 검색할수 없습니다.");
	  }else{
          EndView.printSelectByCode(goods);
	  }
  }

  /**
    수정하기 키보드 입력 
  */
  public void inputUpdate(){
       //키보드입력 4개 받기 
	   System.out.print("수정하려는 상품코드 > ");
	   String code = sc.nextLine();

	   System.out.print("변경 상품가격 > ");
	   int price = Integer.parseInt(sc.nextLine());

	   System.out.print("변경 상품설명 > ");
	   String explain = sc.nextLine();

	   //위 3개의 정보를 하나의 Goods객체로 만든다.
	  
	  

	   if(service.update(null) ){
          EndView.printMessage("상품이 수정되었습니다.");
	   }else{
          EndView.printMessage("상품이 수정되지않았습니다.");
	   }


  }//메소드끝



}//클래스끝