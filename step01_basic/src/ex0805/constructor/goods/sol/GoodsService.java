package ex0805.constructor.goods.sol;
/**
  각 요청에 대한 로직(기능)을 담당할 클래스
  (등록 , 전체검색, 부분검색, 수정, 삭제 등등.....)
*/
public class GoodsService{

	//상품을 관리할 배열 선언
	private Goods [] goodsArr = new Goods [6];
	public static int count;//0 배열방에 저장 객체의 개수 

   /**
      초기치 데이터를 세팅하는 메소드
	  String [][] data = new String [][]{
			 {"A01" , "새우깡" , "2500" , "짜고 맛나다."},  //---> Goods 
			 {"A02" , "고구마깡" , "3500" , "고구맛이고 달다."},  //---> Goods 
			 {"A03" , "감자깡" , "5000" , "감자맛에 고소한맛."}, // ---> Goods 
			 {"A04" , "허니버터칩" , "2200" , "달콤 하다."},
			 {"A05" , "콘칩" , "3000" , "고소하다."}
			 
		};
   */
	
	public GoodsService(String [][] data) {
		for(int i=0; i< data.length ; i++){ //5
			goodsArr[count++] = this.create( data[i] );	
		 }
		
		///////////////////////////////
		/*System.out.println("-------");
		for(Goods g : goodsArr) {
			System.out.println(g);
		}*/
	}


   /**
      Goods를 생성해서 값을 설정하고 생성된 Goos를 리턴하는 메소드 
   */
   private Goods create(String [] row){//{"A01" , "새우깡" , "2500" , "짜고 맛나다."}
         Goods goods = new Goods(row[0], row[1],Integer.parseInt(row[2]),row[3]);
		 return goods;
   }


   /**
     등록(등록실패 - 중복인경우, 배열의 길이 벗어난경우)
	 @return : 
			 0이면 상품코드 중복 ,
			 1이면 등록성공, 
			 -1이면 배열의 길이 벗어남
   */
   public int insert(Goods goods){
	   // 배열의 길이 체크
	   if(goodsArr.length == GoodsService.count){
            return -1;
	   }

	   //중복체크 
	  Goods searchGoods = this.selectByCode( goods.getCode() );//null or 주소리턴
	  
       if(searchGoods!=null){ //찾았다 그러니까 중복이다.
          return 0; 
	   }

	   goodsArr[GoodsService.count++] = goods;
      return 1;
   }


   /**
     전체검색
   */
   public Goods[]  selectAll( ){
     // System.out.println("servier의 goodsArr  = " + goodsArr);
      return goodsArr;//주소값
   }

   /**
     상품코드에 해당하는 상품 검색
	 @return : 만약 code에 해당하는 값이 있으면 Goods를 리턴하고
	           없으면 null 리턴
   */
   public Goods selectByCode(String code){//A09
        for(int i=0; i< GoodsService.count ; i++){
			Goods goods = goodsArr[i]; //배열방에 있는 주소값
 
            String c = goods.getCode();//저장되어있는 상품코드 꺼내기 
            
            
            String converUpper = c.toUpperCase(); //저장되어 있는 코드를 대문자로 

			if(converUpper.equals( code.toUpperCase() ) ){
                 //있다. ==찾았다.
                 return goods;//주소값이 리턴된다. 
			}
		}
        
       
       return null;//못찾았다.
   }


   /**
    상품코드에 해당하는 가격, 설명 수정하기 
	@return : true이면 수정완료, false이면 수정실패
   */
   public boolean update(Goods goods){ //수정하려는 코드, 변경값 - 가격, 설명
        
	   Goods searchGoods = this.selectByCode(goods.getCode());
	   
		  if(searchGoods != null){ //있다..
	          //수정하자.
	          searchGoods.setPrice( goods.getPrice() );
			  searchGoods.setExplain( goods.getExplain() );

			  return true;
		  }

       return false;
   }
   
  /**
   * 삭제하려는 상품코드에 해당하는 배열의 위치(index) 찾기
   * @param code
   * @return
   */
 	public int findLocate(String code) {
 		for (int i = 0; i < count ; i++) {
 			if(goodsArr[i].getCode().equals(code) ) {
 				return i; //i는 배열의 위치
 			}
 		}
 		return -1; //못찾았다!
 	}
 	
 	/**
 	 * 삭제하려는 상품코드를 입력 받아 
 	 *  - 상품코드에 해당하는 정보를 찾고 있으면 index(번지수)를 받는다.
 	 *  - index에 해당하는 상품을 배열에서 null바꾼다.
 	 *  - index 이후부터 앞으로 하나씩 옮긴다.
 	 *  - count변수의 위치의 배열공간 null 변경하다
 	 *  - count 감소한다.
 	 * */
 	public int delete(String code) {
 		
 		int locate = this.findLocate(code);
 		
 		if(locate == -1)return -1;
 		
 		goodsArr[locate]=null; //위치를 null로 초기화
 		
 		for (int i = locate; i < count-1; i++) { //count = 5  -1 = 4
 			goodsArr[i] = goodsArr[i+1];
 		}
 		
 		goodsArr[--count]=null;
 		
 		return 1;
 	}
 	
 
}