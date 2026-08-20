package mvc.exception;

/**
 * 모델번호가 중복되었을때 발생한 예외..
 * */
public class DuplicateModelNoException extends Exception{

	public DuplicateModelNoException() {}
	public DuplicateModelNoException(String message) {
		super(message);
	}
}
