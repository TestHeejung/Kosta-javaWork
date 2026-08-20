package ex0804.array;

//ObjectInArray.java

class ObjectOne{
	public int a;
}
///////////////////////////////////////////////////////////////////
public class ObjectInArray{
	//메인 메소드에서 
	public static void main(String[] args) {
		//ObjectOne 타입을 5개 까지 저장하는 배열을 선언하고
		ObjectOne [] objArr = new ObjectOne [5];
		 
		//System.out.println("--배열방 기본값 --");
		for(int i=0; i< objArr.length ; i++) {
			System.out.print( "생성전 : " + objArr[i]  +"\t");
			
			objArr[i] = new ObjectOne();
			
			System.out.print( "생성후 : " + objArr[i]  +"\t");
			
			//각객체의 a의 값 출력
			System.out.print( "objArr["+i+"].a= " + objArr[i].a  +"\t");
			
			//각객체의 a의 값을 변경해보자
			objArr[i].a = i+1;
			
			//변경된 a의 값을 출력해보자.
			System.out.print( "후 : objArr["+i+"].a= " + objArr[i].a  +"\n");
		}
		
	    ///////////개선된 for문 변경//////////////////////////
	    System.out.println("----------------------");
		 for(ObjectOne obj  :objArr) {
			 System.out.println(obj +" , " + obj.a);
		 }
	
		
	}
		
	
}
