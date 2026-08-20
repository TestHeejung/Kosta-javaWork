package ex0805.constructor.goods.sol;
/**
  요청 결과를 출력할 view
*/
public class EndView{
   /**
     성공여부 메시지를 출력하는 메소드 
   */
   public static void printMessage(String message){
      System.out.println(message+"\n");
   }

   /**
     전체검색 결과를 출력하는 메소드
   */
   public static void printSelectAll(Goods [] arr){//service에 있는 주소가 전달되었다.
	   //System.out.println("arr = " + arr);
      System.out.println("*******상품 LIST ("+GoodsService.count+")개 ************");
   
       //정보 출력
	   for(int i=0; i < GoodsService.count ; i++){
             System.out.println( arr[i].getCode() +" | " + arr[i].getName()  +" | "
		                  + arr[i].getPrice() +" | " + arr[i].getExplain() );
		   
		  // System.out.println("test....");
             
	   }

		   System.out.println();

   }

   /**
     상품코드에 해당하는 상세정보 출력하는 메소드 
   */
   public static void printSelectByCode(Goods goods){//주소전달
      System.out.println("******" + goods.getCode() +"의 상세보기 *****");
      System.out.println(  goods.getName()  +" | " + goods.getPrice() +" | " + goods.getExplain() );
   
   }



}








