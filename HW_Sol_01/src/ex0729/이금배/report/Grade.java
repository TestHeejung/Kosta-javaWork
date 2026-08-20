package ex0729.이금배.report;

public class Grade {

	public static void main(String[] args) {
		  /*
		String name = "이금배";
	      int lan = (int)(Math.random() * 56 + 45);
	      int eng = (int)(Math.random() * 56 + 45);
	      int mat = (int)(Math.random() * 56 + 45);
	      
	      int total = lan + eng + mat;
	      double average = (double)(total / 3.0);
	      char grade;
	      
	       if문 
	      if (average >= 90) grade = 'A';
	      else if (average >= 80) grade = 'B';
	      else if (average >= 70) grade = 'C';
	      else if (average >= 60) grade = 'D';
	      else grade = 'F';
	      */
		
		// switch문
		String name = "이금배";
	      int lan = (int)(Math.random() * 56 + 45);
	      int eng = (int)(Math.random() * 56 + 45);
	      int mat = (int)(Math.random() * 56 + 45);
	      
	      int total = lan + eng + mat;
	      double average = (double)(total / 3);
	      char grade = 'A'; 
		 
		
	      switch ((int)average) {
	      case 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 : grade = 'A'; break;
	      case 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 : grade = 'B'; break;
	      case 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 : grade = 'C'; break;
	      case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 : grade = 'D'; break;
	      default : grade = 'F';
	      }
	      
	      
	      
	      System.out.println("이름 : " + name + "\n국어점수 : " + lan
	            + "\n영어점수 : " + eng + "\n수학점수 : " + mat);
	      System.out.println("총점 : " + total + "\n평균 : " + average + "\n학점 : " + grade);

	}

}
