package app.mvc.exception;

/**
 * 검색했을때 찾고자하는 정보가 없는 경우 예외
 * */
public class NotFoundException extends Exception {
	public  NotFoundException() {
	}
	
	public NotFoundException(String message) {
		super(message);
	}

}
