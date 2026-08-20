package mvc.exception;

/**
 * Electronics배열의 저장공간을 벗어 났을때 처리 할 예외 클래스 
 * */
public class ElectronicsArrayBoundsException extends Exception {
	public ElectronicsArrayBoundsException() {}
	public ElectronicsArrayBoundsException(String message) {
		super(message);
	}

}
