package mvc.controller;

import mvc.dto.Profile;
import mvc.exception.DuplicateNameException;
import mvc.exception.InvalidPasswordException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ProfileService;
import mvc.service.ProfileServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

public class ProfileController {
	private ProfileService service = ProfileServiceImpl.getInstance();

	/**
	 * 프로필  등록
	 * @param profile
	 */
	public void create(Profile profile) {
		try {
			service.createNewFile(profile);
			SuccessView.printMessage("등록이 완료되었습니다.");
		} catch (DuplicateNameException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 입력받은 이름과 비밀번호가 일치하면 몸무게를 출력한다.
	 * @param name
	 */
	public void searchByName(String name, String password) {
		Profile profile = null;
		String tempPassword = password;
		
		// 이름에 해당하는 파일이 있는지 확인
		try {
			profile = service.searchByName(name);
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
		
		// 비밀번호가 일치하는지 확인. 틀릴 시 비밀번호 입력은 3회까지 가능
		for (int i = 3; i > 0; i--) {
			try {
				service.isCorrectPassword(profile, tempPassword);
				SuccessView.printWeight(profile);
				break;
			} catch (InvalidPasswordException e) {
				FailView.errorMessage(e.getMessage());
				if (i != 1)
					tempPassword = FailView.tryPassword(i-1);
			}
			
		}
	}
	
	public void updateWeight(Profile newProfile) {
		try {
			Profile oldProfile = service.searchByName(newProfile.getName());
			service.isCorrectPassword(oldProfile, newProfile.getPassword());
			
			SuccessView.printWeight(oldProfile);
			service.updateWeight(oldProfile, SuccessView.getNewWeight());
			SuccessView.printMessage("변경이 완료되었습니다.\n");
			
		} catch (SearchNotFoundException | InvalidPasswordException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void updatePassword(Profile newProfile) {
		try {
			Profile oldProfile = service.searchByName(newProfile.getName());
			service.isCorrectPassword(oldProfile, newProfile.getPassword());
			
			SuccessView.printPassword(oldProfile);
			service.updatePassword(oldProfile, SuccessView.getNewPassword());
			SuccessView.printMessage("변경이 완료되었습니다.\n");
			
		} catch (SearchNotFoundException | InvalidPasswordException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
}
