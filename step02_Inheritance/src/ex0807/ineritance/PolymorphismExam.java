package ex0807.ineritance;

class CarCenter{
	public void engineer(Car cd){ // Car cd = ef or c or ex or ca ; 
		System.out.println("cd ="  +cd);
		
		//System.out.println( cd.i );// 부모타입으로는 자식부분 접근 불가
		
		//부모타입을 자식타입변수에 담는다.
		//EfSonata e = cd; //에러(개념적으로 부모 > 자식)
		
		//부모타입을 자식타입으로 ObjectDownCasting 해야한다.
		if(cd instanceof EfSonata) {
			System.out.println("-------------");
			EfSonata e = (EfSonata)cd;
			System.out.println("e = "+ e);
			System.out.println( e.i );
			System.out.println("-------------");
		}
		
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
		System.out.println();
		
	}
	

}
//////////////////////////////////////////////////
public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc = new CarCenter();
		
		EfSonata ef= new EfSonata();
		Carnival ca= new Carnival();
		Excel ex= new Excel();
		Car c= new Car();
		
		System.out.println("c = " + c);
		System.out.println("ef = " + ef);
		System.out.println("ca = " + ca);
		System.out.println("ex = " + ex);
	
		System.out.println("ef.i = " + ef.i);
		
		cc.engineer(c);//
		
		cc.engineer(ef);//
		
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		
	
	}
}
