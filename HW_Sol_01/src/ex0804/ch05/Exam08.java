package ex0804.ch05;
/**
 *  작성일: 
 *	작성자: 
 */
public class Exam08 {
	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		int sum = 0;
		int totalLength = 0;
		
		for(int i=0; i < array.length ; i++) { //3
			int rowLen = array[i].length;
			totalLength +=rowLen;
			
			for(int j=0; j < rowLen ; j++) {
				sum += array[i][j];
			}
		}
		
		double mean = sum/(double)totalLength;
		System.out.printf("총점: %d, 평균: %.2f", sum, mean);
		
		System.out.println("\n----------------------------");
		 sum = 0;
		 totalLength = 0;
		for (int[] is : array) {
			totalLength += is.length;
			for (int i : is) {
				sum += i;
			}
		}
		 mean = (double)sum/totalLength;
		System.out.printf("총점: %d, 평균: %.2f", sum, mean);
		
	}
}
