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
		Function<Integer, Integer> beforeSquare2 =(t)->Utils.square(t);
		
    	
    	//2. static 메소드 참조 문법  : 람다식을 더욱 간결
		Function<Integer, Integer> beforeSquare3 =  Utils ::square;
		
   
        //3.호출해보자
		System.out.println("결과1 : " +  beforeSquare.apply(5) );
		
		System.out.println("결과2 : " +  beforeSquare2.apply(5) );
		
		System.out.println("결과3 : " +  beforeSquare3.apply(5) );
		
    } 
} 





