package ex0807.ineritance;

class Car {// Object 상속
	public String carname;
	public int cost;

	protected void printAttributes() {
		System.out.println("carname=" + carname + "\tcost=" + cost);
	}
}

///////////////////////////////////////////////////
//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
//각 클래스에 인수를 받지않는 생성자 작성
//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
class EfSonata extends Car { // EfSonata는 Car를 상속받는다.	
	int i=10;
	
	EfSonata() {// 생성자
		carname = "EfSonata";
		this.cost = 3500;
	}
}

//////////////////////////////////
class Excel extends Car { // Excel is a Car
	Excel() {
		this.carname = "Excel";
		super.cost = 100;
	}
}

/////////////////////////////
class Carnival extends Car { // Carnival is a Car
	Carnival() {
		super.carname = "Carnival";
		this.cost = 4000;
	}
}

///////////////////////////////////////////////////////////
public class InheritanceExam {
//메인메소드에서 
	public static void main(String[] args) {
		// Car, EfSonata, Excel, Carnival 네개의 객체를 생성
		// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Carnival cn = new Carnival();

		System.out.println("------------------");
		System.out.println("car = " + car);
		System.out.println("ef = " + ef);
		System.out.println("ex = " + ex);
		System.out.println("cn = " + cn);

		System.out.println("---------------");
		car.printAttributes();
		ef.printAttributes();
		ex.printAttributes();
		cn.printAttributes();

	}

}
