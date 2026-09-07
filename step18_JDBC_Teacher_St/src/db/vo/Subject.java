package db.vo;

public class Subject {
   private String sugangCode;
   private String subjectName;
   
   
   public Subject() {}
	public Subject(String sugangCode, String subjectName) {
		super();
		this.sugangCode = sugangCode;
		this.subjectName = subjectName;
	}
	
	public String getSugangCode() {
		return sugangCode;
	}
	
	public void setSugangCode(String sugangCode) {
		this.sugangCode = sugangCode;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subject [sugangCode=");
		builder.append(sugangCode);
		builder.append(", subjectName=");
		builder.append(subjectName);
		builder.append("]");
		return builder.toString();
	}
	
	
   
}
