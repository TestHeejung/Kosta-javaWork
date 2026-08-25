package stream.ex04;

public class Student {
   private String name;
   private String gender;
   private int score;
   
public Student(String name, String gender, int score) {
	super();
	this.name = name;
	this.gender = gender;
	this.score = score;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Student [name=");
	builder.append(name);
	builder.append(", gender=");
	builder.append(gender);
	builder.append(", score=");
	builder.append(score);
	builder.append("]");
	return builder.toString();
}
   
   
   
}
