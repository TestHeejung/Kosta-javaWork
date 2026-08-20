package ex0813.list;

/**
 * 사원정보
 * */
public class Emp implements Comparable<Emp>{
  private int empno;//사원번호
  private String ename;//사원이름
  private int age;//나이
  private String addr;//주소
  
  public Emp() {}
  public Emp(int empno, String ename, int age, String addr) {
	super();
	this.empno = empno;
	this.ename = ename;
	this.age = age;
	this.addr = addr;
  }
  public int getEmpno() {
	return empno;
  }
  public void setEmpno(int empno) {
	this.empno = empno;
  }
  public String getEname() {
	return ename;
  }
  public void setEname(String ename) {
	this.ename = ename;
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
	builder.append("Emp [empno=");
	builder.append(empno);
	builder.append(", ename=");
	builder.append(ename);
	builder.append(", age=");
	builder.append(age);
	builder.append(", addr=");
	builder.append(addr);
	builder.append("]");
	return builder.toString();
  }
  @Override
  public int compareTo(Emp o) {
     System.out.println("111 => " + o);
     
    /* if(empno == o.getEmpno())
    	 return 0;
     else if(empno > o.getEmpno())
     return 1;
     else
    	return -1;*/
     
	//return empno - o.getEmpno();
     return  o.getEmpno() - empno;//내림차순
  }
  
}










