package ex0807.sample01;

public class FullTime {
	private int empNo;  
	private String eName; 
	private String job;
	private int mgr;
	private String hiredate;
	private String depName;
	
	private int salary;
	private int bonus;
	
	public FullTime() {}
	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int salary,
			int bonus) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.depName = depName;
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public void message() {
		System.out.println(eName+"은 정규직사원입니다.");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FullTime [empNo=");
		builder.append(empNo);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append(", depName=");
		builder.append(depName);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", bonus=");
		builder.append(bonus);
		builder.append("]");
		
		
		return builder.toString();
	}

	
	
	
	

}






