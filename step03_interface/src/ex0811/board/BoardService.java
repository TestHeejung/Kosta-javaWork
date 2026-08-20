package ex0811.board;

/**
 * 모든 게시판 유형이 공통을 사용할 메소들 정의(규격서 역할)
 * */
public interface BoardService {
 /**
  * 등록
  * 
  * @param: Board
  * 
  * @return: int (0이면 등록실패, 1이면 성공) 
  * 
  * */
	int  insert(Board board);// Qa or Free or Upload 허용
	
	
	/**
	 * 수정
	 * : 글번호에 해당하는 게시물의 제목, 내용 수정 
	 * @param:Board
	 * @return:boolean (true이면 수정완료, false이면 수정실패)
	 * */
	 boolean update(Board board);
	
	/**
	 * 글번호에 해당하는 게시물 검색
	 * @param : int  - 글번호
	 * @return:Board  - 글번호에 하다는 게시물이 있으면 Board 리턴하고
	 *                  없으면 null리턴
	 * */
	 Board selectByNo(int no);
	 ////////////////////////////////////////////
	 /**
		 * java 1.8 version 이후 추가
		 *  : interface 안에 있는 메소드에 static or default 제한자를 추가하면
		 *    body있는 메소드를 만들수 있다.
		 *    body가 있는 메소드는 구현객체들이 재정의 선택적으로 할수 있다.
		 *    
		 *    1) static
		 *         : 구현객체없이 바로 interface이름.메소드이름() 호출
		 *    
		 *    2) default
		 *         : 반드시 구현 객체가 있어야 호출할 수 있다 .
		 *         
		 * java 1.9 version 이후 private 메소드
		 *   - 인터페이스 내부 코드의 중복 제거를 위한 helper 메서드
		 *     private이기 때문에 구현 클래스에게도 상속되지 않고 직접 호출할 수도 없다.
		 *     인터페이스의 private 메서드는 구현 클래스에게 제공하려는 메서드가 아니라, 
		 *     인터페이스 내부의 default/static 메서드에서 공통 로직을 재사용하기 위한 내부용 메서드
	*/	 
	 
	 /**
	  * 삭제기능(Free, Qa 만)
	  * */
	 default int delete(int no) {
		 System.out.println("BoardService 의 delete call");
		 
		 //글번호에해당하는 정보 찾기
		 findByNo(no);
		 findByNo2(no);
		 
		 return 0;
	 }
	 
	 /**
	  * 전체검색
	  * */
	 static void selectAll() {
		 System.out.println("BoardService 의 selectAll call");
		//글번호에해당하는 정보 찾기
		 findByNo2(2);
		 
	 }
	 
	 /**
	  * 글번호에해당하는 정보 찾기 - 내부에서만 사용
	  * */
	 private void findByNo(int no) {
		 
	 }
	 
     private static void findByNo2(int no) {
		 
	 }
	 
	 
	 
}
















