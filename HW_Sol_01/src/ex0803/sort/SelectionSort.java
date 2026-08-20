package ex0803.sort;

import java.util.Arrays;
/**
선택 정렬(selection sort)은 정렬되지 않은 데이터들에 대해 가장 작은 데이터를 찾아
   가장 앞의 데이터와 교환해나가는 방식이다. 
    : 최솟값과 맨 앞의 값을 비교하는 정렬
*/
class SelectionSort{
	public static void main(String[] args){
		//int arr[] = {5,7,1,2,4,3,8,9,6,10};
       int arr[] = {15,11,1,3,8};
         
     System.out.println("정렬 전 = " + Arrays.toString(arr)+"\n\n");
     
     int len = arr.length;
	   int minIndex = 0; //최소값의 위치 
		int temp = 0; //임시변수
		
    //{15,11,1,3,8}
		for(int i = 0; i < len-1; i++){// i= 0 1 2 3 
			minIndex = i; //0
			for(int j = i+1; j < len; j++){ // j= 1 2 3 4 
				if(arr[minIndex] > arr[j] ){
					minIndex = j; // 가장 작은 데이터의 index를 찾는다.
				}
			}//

			System.out.println("minIndex = " + minIndex  + ", i = " + i );
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			System.out.println("정렬 i = "+i+"일때  : "+Arrays.toString(arr)+"\n");	
			
		}//for문끝

       System.out.println("\n정렬 후 = "+Arrays.toString(arr));	

	}
}


