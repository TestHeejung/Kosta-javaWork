package ex0812.exam01;

public class MainApp {

	public static void main(String[] args) {
		//제너릭이 없는 경우
		/*Box box = new Box();
		box.setContent("상품1");//저장
		
		if(box.getContent() instanceof String) {
		   String content = (String)box.getContent();
		   System.out.println(content);
		}
		
		 box.setContent(new Board());
		if(box.getContent() instanceof Board) {
		 
		  Board content = (Board)box.getContent();
		  System.out.println(content.getBno());
	
		}*/
		///////////////////////////////////////////////
		System.out.println("**제네릭 사용한경우***");
		Box<String> box = new Box<>();
		box.setContent("안녕");
		
		String content = box.getContent();
		System.out.println("content = "+ content);
		
		///////////////////////////////////////////////
		Box<Board> box2 = new Box<Board>();
		box2.setContent(new Board());
		
		Board board = box2.getContent();
		System.out.println(board.getBno());
	
	 //////////////////////////////////
	  int i=5;
	  
	  Integer it = i; //AutoBoxing
	  
	  int j = it; //unboxing
	  
	  
	  Integer a = 5;
	  int b = a;
	  
	  //new Inte
	
	}

}













