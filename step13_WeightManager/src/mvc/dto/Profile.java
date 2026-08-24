package mvc.dto;

import java.io.Serializable;

/**
 * 프로필의 속성을 관리하는 객체 
 */
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int weight;
	private String password;
	
	public Profile() {}
	
	public Profile(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Profile(String name, int weight, String password) {
		this.name = name;
		this.weight = weight;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name=");
		builder.append(name);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", password=");
		builder.append(password);
		return builder.toString();
	}
	
	
	
}
