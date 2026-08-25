package lamda.constructorRef; 
import java.util.function.Function; 
 
class User { 
    String name; 
    public User(String name) { 
        this.name = name; 
    } 
     
    public void printName() { 
        System.out.println("User 이름: " + name); 
    } 
} 
 //////////////////////////////////////////////////
public class ConstructorReferenceWithParams02 { 
    public static void main(String[] args) { 
    
    	//기존방식
    	Function<String, User> beforeUser = new Function<String, User>() {
			@Override
			public User apply(String name) {
				return new User(name);
			}
		};
		
		//1. 람다식으로 변경해보자
		
		
		//2. 생성자 참조로 변경해보자
	
		
    	
        //3. 호출해보자  
       
    } 
}