package ex0803.sort;


/**
삽입 정렬(insertion sort)은 아직 정렬되지 않은 임의의 데이터를 
이미 정렬된 부분의 적절한 위치에 삽입해 가며 정렬하는 방식이다. 
 => 앞부분은 이미 정렬되어 있다고 가정
    1. 두 번째 값부터 시작
	2. 앞의 값들과 비교
	3. 들어갈 자리를 찾을 때까지 뒤로 밀기
	4. 그 자리에 삽입
*/
import java.util.Arrays;
public class InsertionSort { 
	
	public static void main(String[] args) {
		   int[] array = {5,7,1,2,4,3,8,9,6,10};
		   //int [] array = {15,11,1,3,8};
		   System.out.println("정렬전 = "+Arrays.toString(array));
		   
		 //삽입 정렬 : 타겟(두번째 원소)와 이전 원소를 비교하며 정렬
			for(int i=0 ;i< array.length-1;i++) {// i= 0 1 2 3 4
				
				int target = i+1; //1 , 2 , 3 , ...아직정렬되지않은 임의의 데이터 
				
				for(int j=0 ;j < target ;j++) {//j=0 ~ target
					if(array[j] > array[target]) {//0 > target , 1> target , 2> targaet
						int temp = array[j];
						array[j] = array[target];
						array[target] = temp;
					}
				}
			}
			
			System.out.println("정렬후 = "+Arrays.toString(array));
			
	}
}

