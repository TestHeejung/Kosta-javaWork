package mvc.exception;

/**
 * 모델번호가 중복인경우....
 * */
public class DuplicateModelNoEexepction extends Exception {
	public DuplicateModelNoEexepction() {}
	public DuplicateModelNoEexepction(String message) {
		super(message);
	}

}
