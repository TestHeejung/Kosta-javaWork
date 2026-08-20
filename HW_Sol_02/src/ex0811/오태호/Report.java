package ex0811.오태호;
/*
* 작성자:  오태호
* 날짜: 2026.08.11
* 주제: p.390 확인문제
*/
public class Report {
	/*
	 * 1. 1 인터페이스는 객체 생성 불가
	 * 2. 3 기본 메소드는 abstract 메소드
	 * 3. 4
	 * 4. 1, 2, 3,4 
	 * 5. implement Remocon 
	 * public void powerOn(){System.out.println("Tv를 켰습니다.");}
	 * 6.public class Cat implements Soundable{
		public String sound() {
			return "야옹";
		}
		
	}
	public class Dog implements Soundable{
		public String sound() {
			return "야옹";
		}
	} 
	 */
	//7
	public interface DataAccessObject{
		void select();
		void insert();
		void update();
		void delete();
	}
	class OracleDao implements DataAccessObject{
		public void select() {
			System.out.println("Oracle DB에서 검색");
		}public void insert() {
			System.out.println("Oracle DB에서 삽입");
		}public void update() {
			System.out.println("Oracle DB에서 수정");
		}public void delete() {
			System.out.println("Oracle DB에서 삭제");
		}
	}
	class MySqlDao implements DataAccessObject{
		public void select() {
			System.out.println("MySql DB에서 검색");
		}public void insert() {
			System.out.println("MySql DB에서 삽입");
		}public void update() {
			System.out.println("MySql DB에서 수정");
		}public void delete() {
			System.out.println("MySql DB에서 삭제");
		}
	}
	//8 a instanceof C c
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
