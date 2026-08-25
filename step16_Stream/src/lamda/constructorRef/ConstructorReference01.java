package lamda.constructorRef; 
import java.util.function.Supplier; 
 
class Person { 
    public Person() { 
        System.out.println("새로운 Person 객체 생성!"); 
    } 
} 
 
public class ConstructorReference01 { 
    public static void main(String[] args) { 
     //기존방식 
      Supplier<Person> beforePerson = new Supplier<Person>() {
		@Override
		public Person get() {
			return new Person();
		}
	};
	
	 //1. 람다식으로 변경해보자
	

     //2. 생성자참조로 변경해보자	
	
	
	 //3.호출해보자
	
	
    }
}




