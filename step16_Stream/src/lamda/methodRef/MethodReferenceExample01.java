package lamda.methodRef; 
import java.util.function.Function; 
 
class Utils { 
    public static int square(int x) { 
        return x * x; 
    } 
} 
 ///////////////////////////////////////////////////

 
public class MethodReferenceExample01 { 
    public static void main(String[] args) { 
    	//기존방식
    	Function<Integer, Integer> beforeSquare = new Function<Integer, Integer>() {		
			@Override
			public Integer apply(Integer t) {			
				return Utils.square(t);
			}
		};
		
		//1. 람다식으로 변경해보자
		
		
    	
    	//2. static 메소드 참조 문법  : 람다식을 더욱 간결
		
		
   
        //3.호출해보자
    } 
} 





