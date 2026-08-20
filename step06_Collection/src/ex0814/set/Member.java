package ex0814.set;

public class Member {
   private String name;
   private int age;
   private String addr;
   
  public Member() {}
  public Member(String name, int age, String addr) {
	super();
	this.name = name;
	this.age = age;
	this.addr = addr;
 }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
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
	builder.append("Member [name=");
	builder.append(name);
	builder.append(", age=");
	builder.append(age);
	builder.append(", addr=");
	builder.append(addr);
	builder.append("]");
	return builder.toString();
  }
  
   @Override
	public int hashCode() {
		System.out.println(1);
		
		return name.hashCode()+ age;
	}
   
   @Override
	public boolean equals(Object obj) {
	  System.out.println(2);
	   if(obj instanceof Member m) {
		   return name.equals(m.getName()) && age == m.getAge();
	   }
	  
		return false;
	}
  
}





















