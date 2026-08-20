package ex0803.array;
class ArrayExam{
	//각int,double,char,boolean ,String type별로 총 5개씩 저장하는  배열을 생성하세요
	int [] intArr = new int [5]; //0
	double [] doubleArr = new double [5]; //0.0
	char [] chArr = new char[5];// \u0000 -> 공백
	boolean [] booleanArr = new boolean[5]; //false
	String [] strArr = new String [5]; //null
	

	//메소드 : printArrayValue01	
	//위의 배열들에 자동으로 초기화 된값을 출력하세요
	public void printArrayValue01(){
		System.out.println(intArr);
		System.out.println(doubleArr);
		
		System.out.println("dd = "+chArr);
		
		System.out.println(booleanArr);
		System.out.println(strArr);
		
       System.out.println("##################");
		
		/*for(int index=0; index < 5 ; index++){
               System.out.println(intArr[index]);
			   System.out.println(doubleArr[index]);
			   System.out.println(chArr[index]);
			   System.out.println(booleanArr[index]);
			   System.out.println(strArr[index]);
			   System.out.println("---------------");
		}*/

		System.out.println("****intArr 배열 방 ******");
		System.out.println("intArr = " + intArr);
		for(int index=0; index< intArr.length  ; index++){
		   System.out.println("intArr["+ index+ "] = " + intArr[index]);
		}
		
		
		System.out.println("\n****doubleArr 배열 방 ******");
		System.out.println("doubleArr = " + doubleArr);
		
		for(int index=0; index< doubleArr.length  ; index++){
		   System.out.println("doubleArr["+ index+ "] = " + doubleArr[index]);
		}
		
		
		System.out.println("\n****chArr 배열 방 ******");
		
		System.out.println( chArr); //공백(모든 배열방의 값을 하나의 문자열)
		
		System.out.println( "chArr= "+ chArr); //주소값
		
		for(int index=0; index< chArr.length  ; index++){
		   System.out.println("chArr["+ index+ "] = " + chArr[index]);
		}
		
		System.out.println("\n****booleanArr 배열 방 ******");
		System.out.println("booleanArr = " + booleanArr);
		for(int index=0; index< booleanArr.length  ; index++){
		   System.out.println("booleanArr["+ index+ "] = " + booleanArr[index]);
		}
		
		System.out.println("\n****strArr 배열 방 ******");
		System.out.println("strArr = " + strArr);
		for(int index=0; index< strArr.length  ; index++){
		   System.out.println("strArr["+ index+ "] = " + strArr[index]);
		}		
      
	}

	//메소드 : printArrayValue02	
	//위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.
	public void printArrayValue02(){   
			
		 for(int i=0; i< this.intArr.length ; i++){ 
			 
	            intArr[i] = (i+10); //
	            
				doubleArr[i] = i*0.5;
				
				chArr[i] = (char)('A'+i); 
				
				if(i%2==0)booleanArr[i] =true; 
				
				strArr[i]= "A"+i;
		}
 
			 
		 System.out.println("값 변경 완료하였습니다.");
	}
	
	
	//메소드 : printArrayValue03	
	//새롭게 할당된값을 출력하세요
	public void printArrayValue03(){
	   System.out.println("****변경된 값 확인해보자 *******");

	   this.printArrayValue01();
	   

	}
	
	//메인메소드에서
	//ArrayExam의 메소드들을 순서대로 호출하세요.
	public static void main(String []args){
        ArrayExam ae = new ArrayExam();//맴버필드 초기화

		ae.printArrayValue01();
		
		ae.printArrayValue02();
		ae.printArrayValue03();

	}
}