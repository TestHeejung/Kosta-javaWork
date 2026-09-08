package app.mvc.exception;

/**
 * 수정할때 발생하는 예외
 * */
public class ModifyException extends Exception {
	public  ModifyException() {
	}
	
	public ModifyException(String message) {
		super(message);
	}

}
