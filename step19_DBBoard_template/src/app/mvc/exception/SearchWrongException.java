package app.mvc.exception;

/**
 *  검색에 관련되 오류가 있을때 발생시킬 예외
 */
//public class SearchWrongException extends RuntimeException {
public class SearchWrongException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public SearchWrongException() {}
	public SearchWrongException(String message) {
		super(message);
	}

}
