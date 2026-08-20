package ex0806.차준혁.ch06;

public class Quiz16 {

}

class PrinterExample {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}

class Printer {
	public void println(int a) {
		System.out.println(a);
	}
	
	public void println(boolean b) {
		System.out.println(b);
	}
	
	public void println(double d) {
		System.out.println(d);
	}
	
	public void println(String s) {
		System.out.println(s);
	}
}