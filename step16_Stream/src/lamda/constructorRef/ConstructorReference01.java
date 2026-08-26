package lamda.constructorRef; 
import java.util.function.Supplier; 
 
class Person { 
    public Person() { 
        System.out.println("새로운 Person 객체 생성!"); 
    } 
} 
 ///////////////////////////////////////////////////////////////
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
	Supplier<Person> beforePerson2 = ()-> new Person();
	

     //2. 생성자참조로 변경해보자
	Supplier<Person> beforePerson3 = Person :: new;
	
	
	 //3.호출해보자
	 Person p1 = beforePerson.get();
	 Person p2 = beforePerson2.get();
	 Person p3 = beforePerson3.get();
	 
	 System.out.println(p1);
	 System.out.println(p2);
	 System.out.println(p3);
	
	
    }
}




