package mvc.exception;

/**
 * 이름이 중복되었을 때 발생하는 예외..
 */
public class DuplicateNameException extends Exception {
	public DuplicateNameException() {}
	public DuplicateNameException(String message) {
		super(message);
	}
}
