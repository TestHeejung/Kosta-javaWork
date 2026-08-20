package ex0806.enumex.goods;

public enum InsertResult2 {
	/**
	 * 상품코드 중복
	 * */
    INSERT_DUPLICATE(0 , "상품코드가 중복입니다.") , 
    
    /**
     * 배열의 길이 벗어남
     * */
    INSERT_OUTINDEX (-1 , "더이상 등록 할수 없습니다."), 
    
    /**
     * 등록성공
     * */
    INSERT_SUCCESS(1,"상품을 등록했습니다.") ;
	
	private final int code;
	private final String message;
	
	InsertResult2(int code, String message){
		this.code=code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}







