package ex0811.exam;

public class Elec {
   private String code;
   private int cost;
   
   public Elec() {}
   public Elec(String code, int cost) {
	this.code = code;
	this.cost = cost;
   }
   public String getCode() {
	return code;
   }
   public void setCode(String code) {
	this.code = code;
   }
   public int getCost() {
	return cost;
   }
   public void setCost(int cost) {
	this.cost = cost;
   }
   
   @Override
   public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("code=");
	builder.append(code);
	builder.append(", cost=");
	builder.append(cost);
	
	return builder.toString();
   }
   
   
   
}
