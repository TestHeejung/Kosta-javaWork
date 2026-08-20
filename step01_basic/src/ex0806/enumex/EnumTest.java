package ex0806.enumex;

public class EnumTest {

	public static void main(String[] args) {
		Grade g = Grade.BASIC;
		switch(g) {
		   case BASIC : 
			   System.out.println("일반고객");break;
		   case SILVER:
			   System.out.println("우수고객"); break;
		   case GOLD:
			   System.out.println("최우수고객"); 
		}
		///////////////////////////////////
		
		System.out.println(g.getKind());
		System.out.println(g.getPoint());
		System.out.println(g.getRole());
	

	}
}
