package ex0807.sample02;

public abstract class Employee {//
	private int empNo;
	private String empName;
	private String job;
	private int mgr;
	private String hiredate;
	private String depName;
	
	public Employee() {}
	public Employee(int empNo, String empName, String job, int mgr, String hiredate, String depName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.depName = depName;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empNo=");
		builder.append(empNo);
		builder.append(", empName=");
		builder.append(empName);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append(", depName=");
		builder.append(depName);
		builder.append(", ");
		return builder.toString();
	}
	
	public abstract void message() ;
	
}







