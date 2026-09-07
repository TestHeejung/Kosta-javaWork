package app.mvc.dto;

public class ReplyDTO {
   private int replyNo;//댓글 글번호
   private String replyContent;//댓글 내용
   
   private int boardNo;//부모글번호
   //BoardDTO dto;
   
   private String replyRegdate;//등록일
   
   
   
   public ReplyDTO() {}
   
   public ReplyDTO( String replyContent, int boardNo) {
		this.replyContent = replyContent;
		this.boardNo = boardNo;
   }

   public ReplyDTO(int replyNo, String replyContent, int boardNo, String replyRegdate) {
	this(replyContent, boardNo);
	
	this.replyNo = replyNo;
	this.replyRegdate = replyRegdate;
  }

	public int getReplyNo() {
		return replyNo;
	}
	
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	
	public String getReplyContent() {
		return replyContent;
	}
	
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getReplyRegdate() {
		return replyRegdate;
	}
	
	public void setReplyRegdate(String replyRegdate) {
		this.replyRegdate = replyRegdate;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyDTO [replyNo=");
		builder.append(replyNo);
		builder.append(", replyContent=");
		builder.append(replyContent);
		builder.append(", boardNo=");
		builder.append(boardNo);
		builder.append(", replyRegdate=");
		builder.append(replyRegdate);
		builder.append("]");
		return builder.toString();
	}
	
	
   
  
}


