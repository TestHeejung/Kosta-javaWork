package ex0807.sample02;

public  /*abstract*/ class FullTime extends Employee {
	private int salary;
	private int bonus;
	
	public FullTime() {}
	public FullTime(int empNo, String empName, String job, 
			int mgr, String hiredate, String depName,int salary ,int bonus) {
		
		super( empNo,  empName,  job, mgr,  hiredate,  depName);
		this.salary=salary;
		this.bonus=bonus;
		
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( super.toString() );
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", bonus=");
		sb.append(bonus);
		sb.append("]");
		
		return sb.toString();
	}
	
	
	@Override
	public void message() {
		System.out.println(super.getEmpName()+"사원은 정규직입니다.");
	}
	
	
}




