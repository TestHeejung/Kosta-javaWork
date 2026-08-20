package ex0803.ch5;

public class Exam07 {
	public static void main(String[] args) {
		int[] array = {1, 5, 3, 8, 2};
		
		int maxValue = Integer.MIN_VALUE;
		
		for (int i=0; i < array.length; i++) {
			if (maxValue < array[i]) {
				maxValue = array[i];
			}
		}
		
		System.out.println(maxValue);
	}
}
