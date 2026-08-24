package mvc.service;

import mvc.dto.Profile;
import mvc.exception.DuplicateNameException;
import mvc.exception.InvalidPasswordException;
import mvc.exception.SearchNotFoundException;

public interface ProfileService {
	
	/**
	 * 프로필 등록
	 * 이름.txt 파일 생성
	 * 동일한 이름이 이미 존재할 시 DuplicateNameException 예외발생
	 */
	public void createNewFile(Profile profile) throws DuplicateNameException;

	/**
	 * 이름에 해당하는 이름.txt 파일이 있는지 검색
	 * @param name
	 * @return
	 * @throws SearchNotFoundException
	 *  :이름에 해당하는 파일이 없다면 예외발생
	 */
	public Profile searchByName(String name) throws SearchNotFoundException;
	
	/**
	 * 입력한 비밀번호가 프로필의 비밀번호와 같은지 확인
	 * @param profile
	 * @param password
	 * @return
	 * @throws InvalidPasswordException
	 *  : 비밀번호가 같다면 true 리턴, 틀리면 예외발생
	 */
	public boolean isCorrectPassword(Profile profile, String password) throws InvalidPasswordException;

	/**
	 * 프로필의 몸무게를 변경한다.
	 * @param profile
	 * @param weight
	 */
	public void updateWeight(Profile profile, int weight);
	
	/**
	 * 프로필의 비밀번호를 변경한다.
	 * @param profile
	 * @param password
	 */
	public void updatePassword(Profile profile, String password);
}
