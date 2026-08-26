package lamda.constructorRef; 
import java.util.function.Function; 
 
class User { 
    String name; 
    public User(String name) { 
    	System.out.println("생성자 call");
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
		Function<String, User> beforeUser2 = (name)-> new User(name);
		
		
		//2. 생성자 참조로 변경해보자
		Function<String, User> beforeUser3 = User :: new;
		
    	
        //3. 호출해보자  
		User user1 = beforeUser.apply("희정");
		user1.printName();

		User user2 = beforeUser.apply("희정2");
		user2.printName();
		
		User user3 = beforeUser.apply("희정3");
		user3.printName();
		
		
       
    } 
}