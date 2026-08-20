package ex0807.sample02;

public class PartTime extends Employee{
	private int timePay;
	
	public PartTime() {}

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int timePay) {
		super(empNo, eName, job, mgr, hiredate, depName);
		this.timePay = timePay;
	}
	
	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" | ");
		builder.append(timePay);
		return builder.toString();
	}

	@Override
	public void message() {
		System.out.println(super.getEmpName()+"사원은 비정규직입니다.");
	}
	

}
