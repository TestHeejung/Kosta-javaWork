package stream.ex02;

public class Student {
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
        return 
        		"Student{name='" + name + "', age=" + age + ", score=" + score + ", major='" + 
major + "'}"; 
    } 
}
