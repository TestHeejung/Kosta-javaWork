package ex0824;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadExam extends JFrame{//창역할 - Container
	
	JTextField text1 = new JTextField(5);
	JTextField text2 = new JTextField(5);
	
	JButton btn1 = new JButton("눌려봐");
	
	public GUIThreadExam() {
		super("여기에 시계달거여요~");
		
		//JFrame의 레이아웃(배치도) 변경
		super.setLayout(new FlowLayout());
		
		//component를 JFrame위에 올리기
		Container con = super.getContentPane();
		
		con.add(btn1 );
		con.add(text1);
		con.add(text2);
		
		
		//창크기 설정
		super.setSize(500, 400);
		super.setLocationRelativeTo(null);//정중앙에 놓기
		
		//창 보이기
		super.setVisible(true);
		
		//x를 클릭했을때 프로그램 종료
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//스레드 시작 
		new NowTimeThread().start();
		
		
	}//생성자 끝 
  public static void main(String[] args) {
	 new GUIThreadExam();
	 
  }
    
/////////////////////////////////////////////
	/**
	 * 현재 시간을 구해서 JFrame title에 1초마다 시간 갱신하는 스레드
	 */
 class NowTimeThread extends Thread {

		@Override
		public void run() {
       //현재 시간 구한다.
			Calendar now = Calendar.getInstance();

			int y = now.get(Calendar.YEAR);
			int m = now.get(Calendar.MONTH) + 1;
			int d = now.get(Calendar.DATE);

			int h = now.get(Calendar.HOUR);
			int mm = now.get(Calendar.MINUTE);
			int sec = now.get(Calendar.SECOND);

			StringBuilder sb = new StringBuilder();
			sb.append(y);
			sb.append("년 ");
			sb.append(m);
			sb.append("월 ");
			sb.append(d);
			sb.append("일 ");

			sb.append(h);
			sb.append("시 ");
			sb.append(mm);
			sb.append("분 ");
			sb.append(sec);
			sb.append("초 ");

          //JFrame의 title에 시계 넣기 
       	 GUIThreadExam.this.setTitle(sb.toString());
		
		}
		
	}//inner클래스 끝

  
  
}//클래스 끝




















