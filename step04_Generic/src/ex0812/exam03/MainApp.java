package ex0812.exam03;

public class MainApp {

	public static void main(String[] args) {
		Rentable<Car> carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
		System.out.println("----------");
		
		Rentable<Home>  homeAgency= new HomeAgency();
		Home home = homeAgency.rent();
		home.room();
		

	}

}
