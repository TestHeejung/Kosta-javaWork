package ex0804.array;

class MultiArray{
  //정수형 2차원 배열 8*9
	int [][] arr = new int [8][9] ;
	
   //메소드이름 :array99
	public void array99() {
	   /*System.out.println(arr);//주소
	   
	   System.out.println(arr[0]);
	   System.out.println(arr[1]);
	   
	   System.out.println(arr[0][0]);*/
		
		for(int i=0; i < arr.length ; i++) {
			for(int j=0; j < arr[i].length ; j++) {
				arr[i][j] = (i+2)*(j+1);
				
				System.out.print(arr[i][j] +"\t");
			}
			System.out.println();
		}
		
	}// array메소드 end
			
}//class end
//////////////////////////////////////////////////////
public class MemoryApart{
	public static void main(String[] args) {
		/*MultiArray m = new MultiArray();
		m.array99();*/
		
		new MultiArray().array99(); //호출
	}
	
}