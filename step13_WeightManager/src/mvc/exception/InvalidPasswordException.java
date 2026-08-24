package mvc.exception;

/**
 * 비밀번호가 틀렸을 때 발생하는 예외..
 */
public class InvalidPasswordException extends Exception {
	static int chance;

	public InvalidPasswordException() {
		super();
	}
	
	public InvalidPasswordException(String message) {
		super(message);
	}
}
