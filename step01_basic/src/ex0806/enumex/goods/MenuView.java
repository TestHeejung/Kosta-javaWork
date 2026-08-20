package ex0806.enumex.goods;
import java.util.Scanner;
/**
 키보드 입력을 받아 각 기능을 호출해줄 View
*/
public class MenuView{

	 private Scanner sc = new Scanner(System.in);
	 private GoodsService service ; //null

	 
	 public MenuView(String [][] data) {
		 service =  new GoodsService(data); //전역변수 초기화
	 }
	 
  /**
    전체 메뉴를 출력하는 메소드 
  */
   public void printMenu(){//메인에서 전달한 2차원배열의 주소값전
      
	  while(true){
         System.out.println("---------------------------------------------------------------------------");
		 System.out.println("1.등록     2.전체검색      3.상품코드검색    4. 수정하기   5. 삭제하기   9.종료");
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
				 this.inputSelectByCode();
				 break;
			 case 4 : 
				 this.inputUpdate() ; 
				 break;
			 case 5:
				 this.inputDeleteCode();
					break;	 
			 case 9 : 
				 System.out.println("다음에 또 이용해ㅜㅈ세요. 프로그램 종료합니다.");
				 System.exit(0); //프로그램종료 메소드 
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

       Goods goods = new Goods(code, name, price,explain);
       
       /*InsertResult result = service.insert(goods);
	   if(result==InsertResult.INSERT_OUTINDEX)
		  EndView.printMessage("더이상 등록할 수 없습니다.");
	   
	   else if(result==InsertResult.INSERT_DUPLICATE)
		  EndView.printMessage(code+"는 중복이므로 등록할수 없습니다.");
	   else 
           EndView.printMessage("상품이 등록되었습니다.");*/
       
       ////////////////////////////////////
       InsertResult2 result = service.insert2(goods);
       EndView.printMessage(result.getMessage());
	   
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
       //키보드입력 3개 받기 
	   System.out.print("수정하려는 상품코드 > ");
	   String code = sc.nextLine();

	   System.out.print("변경 상품가격 > ");
	   int price = Integer.parseInt(sc.nextLine());

	   System.out.print("변경 상품설명 > ");
	   String explain = sc.nextLine();
	   

	   //위 3개의 정보를 하나의 Goods객체로 만든다.
	   
	   Goods goods = new Goods(code,price, explain);
	   boolean re = service.update(goods);
	   
	   if(re){
          EndView.printMessage("상품이 수정되었습니다.");
	   }else{
          EndView.printMessage("상품이 수정되지않았습니다.");
	   }


  }//메소드끝

//상품 코드로 현재 위치 찾기 입력
	public void inputDeleteCode() {
		System.out.print("삭제하려는 상품코드 > ");
		String code = sc.nextLine();
		
		//삭제하려는 상품코드에 해당하는 위치(index) 찾기 
		//int delIndex = service.findLocate(code);
	    if( service.delete(code) == -1)
	    	EndView.printMessage(code+"오류로 삭제할 수 없습니다.");
	    else {
		 
		  EndView.printMessage("삭제되었습니다.");
	    }
		
	}
	
	

}//클래스끝