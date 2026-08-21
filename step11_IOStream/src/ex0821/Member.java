package ex0821;

import java.io.Serializable;
/**
 * Serializable 구현한 객체는 직렬화 대상이된다.
 * 즉, 파일에 직렬화해서 저장 할 수 있다.
 * */
public class Member implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 100L;
	
   private String id;
   private int age;
   
   //transient는 직렬화대상에서 제외
   private transient String addr;
   
   
   public Member() {}
   public Member(String id, int age, String addr) {
	super();
	this.id = id;
	this.age = age;
	this.addr = addr;
   }

   public String getId() {
	return id;
   }

   public void setId(String id) {
	this.id = id;
   }

   public int getAge() {
	return age;
   }

   public void setAge(int age) {
	this.age = age;
   }

   public String getAddr() {
	return addr;
   }

   public void setAddr(String addr) {
	this.addr = addr;
   }

   @Override
   public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Member [id=");
	builder.append(id);
	builder.append(", age=");
	builder.append(age);
	builder.append(", addr=");
	builder.append(addr);
	builder.append("]");
	return builder.toString();
   }
 
}
