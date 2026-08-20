package ex0811.board;

public class MainApp {
	//1)필드를 이용한 다형성
	Board board; // FreeBoard or QaBoard or UploadBoard 
	BoardService boardService;// FreeBoardServiceImpl or QaBoardServiceImpl or UploadBoardServiceImpl
	
	public MainApp() {
		board = new FreeBoard(1, "제목1", "작성자1", "내용1");
		boardService = new FreeBoardServiceImpl();
		test(boardService, board);
		//////////////////////////////
		
		board = new QaBoard(2, "제목2", "작성자2", "내용2", false);
		boardService = new QaBoardServiceImpl();
		test(boardService, board);
		///////////////////////////////////////
		
	    board = new UploadBoard(3, "제목3", "작성자3", "내용3", "test.txt");
	    boardService= new UploadBoardImpl();
	    test(boardService, board);
		
		
	}
	
	public void test(BoardService service, Board board) {//2)매개변수를 이용한 다형성
		service.insert(board);
		service.update(board);
		service.selectByNo(5);
		
		service.delete(100);
		BoardService.selectAll();
		
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
		new MainApp();
	}

}



