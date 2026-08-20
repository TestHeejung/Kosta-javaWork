package ex0806.enumex.goods;

public enum InsertResult {
	/**
	 * 상품코드 중복
	 * */
    INSERT_DUPLICATE , 
    
    /**
     * 배열의 길이 벗어남
     * */
    INSERT_OUTINDEX , 
    
    /**
     * 등록성공
     * */
    INSERT_SUCCESS ;
}
