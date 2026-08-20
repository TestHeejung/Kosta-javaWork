package ex0813.exam05;

public class MainApp {

	public static void main(String[] args) {
		Course course=new Course();
		
		System.out.println("--1. ? 모든 타입 허용----");
		/*Applicant<Person> ap = new Applicant<Person>();
		ap.setKind(new Person());*/
		
		course.register01(new Applicant<Person>(new Person()));
		course.register01(new Applicant<Worker>(new Worker()));
		course.register01(new Applicant<Student>(new Student()));
		course.register01(new Applicant<HighStudent>(new HighStudent()));
		course.register01(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		System.out.println("--2. <? super Worker> Worker이상 허용----");
		course.register02(new Applicant<Person>(new Person()));
		course.register02(new Applicant<Worker>(new Worker()));
		//course.register02(new Applicant<Student>(new Student()));
		//course.register02(new Applicant<HighStudent>(new HighStudent()));
		//course.register02(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		
		System.out.println("--3. <? extends Student> Student 이하 허용----");
		//course.register03(new Applicant<Person>(new Person()));
		//course.register03(new Applicant<Worker>(new Worker()));
		course.register03(new Applicant<Student>(new Student()));
		course.register03(new Applicant<HighStudent>(new HighStudent()));
		course.register03(new Applicant<MiddleStudent>(new MiddleStudent()));

	}

}










