package mvc.exception;

/**
 * 수정, 삭제, 등록에서 실패했을때...
 * */
public class DMLException extends Exception {
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}

}
