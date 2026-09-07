package db.vo;

public class Student {
	private int studentNo;
	private String studentName;
	private String studentJumin;
	private String studentPhone;
	private String studentAddr;
	private String studentEmail;

	public Student() {}
	public Student(int studentNo, String studentName, String studentJumin, String studentPhone, String studentAddr,
			String studentEmail) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentJumin = studentJumin;
		this.studentPhone = studentPhone;
		this.studentAddr = studentAddr;
		this.studentEmail = studentEmail;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentJumin() {
		return studentJumin;
	}

	public void setStudentJumin(String studentJumin) {
		this.studentJumin = studentJumin;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentAddr() {
		return studentAddr;
	}

	public void setStudentAddr(String studentAddr) {
		this.studentAddr = studentAddr;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [studentNo=");
		builder.append(studentNo);
		builder.append(", studentName=");
		builder.append(studentName);
		builder.append(", studentJumin=");
		builder.append(studentJumin);
		builder.append(", studentPhone=");
		builder.append(studentPhone);
		builder.append(", studentAddr=");
		builder.append(studentAddr);
		builder.append(", studentEmail=");
		builder.append(studentEmail);
		builder.append("]");
		return builder.toString();
	}

}
