package mvc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mvc.dto.Profile;
import mvc.exception.DuplicateNameException;
import mvc.exception.InvalidPasswordException;
import mvc.exception.SearchNotFoundException;

public class ProfileServiceImpl implements ProfileService {
	private static ProfileService instance = new ProfileServiceImpl();
	
	private ProfileServiceImpl() {
		
	}
	
	public static ProfileService getInstance() {
		return instance;
	}

	@Override
	public void createNewFile(Profile profile) throws DuplicateNameException {
		
		// 이름이 중복인지 아닌지 확인
		try {
			this.searchByName(profile.getName());
			throw new DuplicateNameException("이미 존재하므로 다시 입력하세요.");
		} catch (SearchNotFoundException e) {
			// 중복이 아닌 경우 이름.txt 파일 추가
			String path = "resources/" + profile.getName() + ".txt";
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
				// profile 객체 저장
				oos.writeObject(profile);
				oos.flush();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	@Override
	public Profile searchByName(String name) throws SearchNotFoundException {
		String path = "resources/" + name + ".txt";
		
		if (new File(path).exists()) {
			// 해당 파일에서 Profile 오브젝트 정보 읽어와서 리턴
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
				return (Profile) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("무슨 오류예요 이거");
			}
		}
		
		throw new SearchNotFoundException(name + "에 해당하는 정보가 없습니다.");
	}

	@Override
	public boolean isCorrectPassword(Profile profile, String password) 
			throws InvalidPasswordException {
		if (profile.getPassword().equals(password))
			return true;
		throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
	}

	@Override
	public void updateWeight(Profile profile, int weight) {
		profile.setWeight(weight);
		
		// 이름.txt 에 덮어쓰기
		String path = "resources/" + profile.getName() + ".txt";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			// profile 객체 저장
			oos.writeObject(profile);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePassword(Profile profile, String password) {
		profile.setPassword(password);
		
		// 이름.txt 에 덮어쓰기
		String path = "resources/" + profile.getName() + ".txt";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			// profile 객체 저장
			oos.writeObject(profile);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
