package ex0812.exam03;

public class HomeAgency implements Rentable<Home> {
  @Override
	public Home rent() {
		
		return new Home();
	}
}
