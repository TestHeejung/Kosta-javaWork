package ex0803.overloading;

public class VariableArgsExam {
	
	public void aa(int ... i) {//i는 배열이된다.
		System.out.println("i = " + i);
		
		System.out.println("\n*****************");
	}
	
	//The variable argument type String of the method bb must be the last parameter
	public void bb( int i, String ... s ) {
		
	}

	public static void main(String[] args) {
		System.out.println("--메소드 호출해보자 ---");
		
		VariableArgsExam ve = new VariableArgsExam();
		ve.aa(5);
		
		ve.aa(5,3,1);
		ve.aa();
		ve.aa(5,1,2,3,4,5,6,7);
		
		//ve.aa("안녕");

	}

}
