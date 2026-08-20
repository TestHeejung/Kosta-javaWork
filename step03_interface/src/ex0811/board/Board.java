package ex0811.board;

/**
 * 모든 게시판이 공통으로 갖는 속성을 관리하는 객체(VO=DTO=Domain)
 * : 글번호, 제목, 작성자, 내용
 * */
public class Board {
   private int no;
   private String subject;
   private String writer;
   private String content;
   
   public Board() {}
   public Board(int no, String subject, String writer, String content) {
	super();
	this.no = no;
	this.subject = subject;
	this.writer = writer;
	this.content = content;
   }
   public int getNo() {
	return no;
   }
   public void setNo(int no) {
	this.no = no;
   }
   public String getSubject() {
	return subject;
   }
   public void setSubject(String subject) {
	this.subject = subject;
   }
   public String getWriter() {
	return writer;
   }
   public void setWriter(String writer) {
	this.writer = writer;
   }
   public String getContent() {
	return content;
   }
   public void setContent(String content) {
	this.content = content;
   }
   
   @Override
   public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getClass().getSimpleName() + " [no=");
	builder.append(no);
	builder.append(", subject=");
	builder.append(subject);
	builder.append(", writer=");
	builder.append(writer);
	builder.append(", content=");
	builder.append(content);
	
	return builder.toString();
   }
   
  
}
