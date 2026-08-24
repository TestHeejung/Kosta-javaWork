package mvc.view;

import java.util.Scanner;

import mvc.controller.ProfileController;
import mvc.dto.Profile;

public class MenuView {
	Scanner sc = new Scanner(System.in);
	ProfileController controller = new ProfileController();

	/**
	 * 전체 메뉴를 출력하는 메소드
	 */
	public void printMenu() {
		while(true) {
			System.out.println("다음 사항에 맞게 입력하여 주십시요");
			System.out.println("\t몸무게 입력은  1 번");
			System.out.println("\t몸무게 검색은  2 번");
			System.out.println("\t몸무게 변경은  3 번");
			System.out.println("\t비밀번호 변경은 4 번");
			System.out.println("\t프로그램 종료는 5 번");
			System.out.println("을 입력 후 Enter 을 눌러 주십시요");
			System.out.print("메뉴 선택: ");
			
			String menu = sc.nextLine();
			switch(menu) {
			case "1":
				this.inputInsert();
				break;
			case "2":
				this.inputSearch();
				break;
			case "3":
				this.inputUpdate("Weight");
				break;
			case "4":
				this.inputUpdate("Password");
				break;
			case "5":
				System.exit(0);
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요!!!!");
			} // switch end
		} // while end
	} // printMenu() end

	/**
	 * 등록할 때 키보드 입력을 처리하는 메소드
	 */
	private void inputInsert() {
		System.out.println("이름을 입력하여 주십시오.");
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		System.out.println("\n몸무게를 입력하여 주십시오.");
		System.out.print("몸무게: ");
		int weight = Integer.parseInt(sc.nextLine());
		
		System.out.println("\n비밀번호를 입력하여 주십시오.");
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		
		controller.create(new Profile(name, weight, password));
	}

	/**
	 * 이름에 해당하는 프로필을 찾기 위해서 이름과 비밀번호 키보드 입력 처리하는 메소드
	 */
	private void inputSearch() {
		System.out.println("\n이름을 입력하여 주십시오.");
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		System.out.println("\n비밀번호를 입력하여 주십시오.");
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		
		controller.searchByName(name, password);
	}

	/**
	 * 이름에 해당하는 몸무게 or 비밀번호를 수정하기 위해 키보드 입력처리하는 메소드
	 * @param field
	 */
	private void inputUpdate(String field) {
		System.out.println("\n이름을 입력하여 주십시오.");
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		System.out.println("\n비밀번호를 입력하여 주십시오.");
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		
		if (field.equals("Weight"))
			controller.updateWeight(new Profile(name, password));
		else if (field.equals("Password"))
			controller.updatePassword(new Profile(name, password));
		
	}
}
