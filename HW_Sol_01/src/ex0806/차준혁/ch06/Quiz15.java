package ex0806.차준혁.ch06;

public class Quiz15 {
	
}
////////////////////////////////////////////
class MemberServiceExample {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		
		boolean result = memberService.login("hong", "12345");
		
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
////////////////////////////////////////////////////////
class MemberService {
	public boolean login(String id, String password) {
		if("hong".equals(id) && "12345".equals(password)) return true;
		
		//if(id.equals("hong") && password.equals("12345")) return true;
		
		else return false;
	}
	
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
	
}