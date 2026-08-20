package ex0811.board;

/**
 * 질의 응답 게시판 속성 관리하는 객체
 * 
 * */
public class QaBoard extends Board {
	private boolean replyState; //답변여부
	
	public QaBoard() {}
	public QaBoard(int no, String subject, String writer, 
			String content , boolean replyState) {
		
		super(no, subject, writer, content);
		this.replyState=replyState;
	
	}
	public boolean isReplyState() {
		return replyState;
	}
	public void setReplyState(boolean replyState) {
		this.replyState = replyState;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString() );
		
		builder.append(", replyState=");
		builder.append(replyState);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
