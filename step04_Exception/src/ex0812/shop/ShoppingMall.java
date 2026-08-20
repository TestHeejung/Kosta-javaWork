package ex0812.shop;

public class ShoppingMall {

	public void enter(int age)throws NoKidsException {
		if(age < 18) {
		    //예외발생시켜라
			//try {
			   throw new NoKidsException(age +"살 NoNo~ 성인만 오세요.");
			//}catch (NoKidsException e) {
			//	System.out.println(e.getMessage());
			//}
			
		}else {
			System.out.println(age+"살 님 환영해요");
		}
		
	}
}
