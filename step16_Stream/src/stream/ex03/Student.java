package stream.ex03;

public class Student  implements Comparable<Student>{
	private String name; 
    private int age; 
    private int score; 
    private String major; 
 
    public Student(String name, int age, int score, String major) { 
        this.name = name; 
        this.age = age; 
        this.score = score; 
        this.major = major; 
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



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", score=");
		builder.append(score);
		builder.append(", major=");
		builder.append(major);
		builder.append("]");
		return builder.toString();
	}



	@Override
	public int compareTo(Student o) {
		
		//return score - o.getScore();
		return Integer.compare(score, o.getScore());
	} 
}









