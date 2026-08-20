package ex0807.overriding.goods;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	public Goods() {}
	public Goods(String code, String name , int price ,String explain) {
		this(code, price, explain);
		this.name=name;
	}
	
	public Goods(String code, int price, String explain) {
		this.code = code;
		this.price = price;
		this.explain = explain;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Goods [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", explain=");
		builder.append(explain);
		builder.append("]");
		
		return builder.toString();
	}
	
	
//	@Override
//	public String toString() {
//		 StringBuilder sb =new StringBuilder();
//		
//		return code +" : " + name;
//	}
	
	
	
}









