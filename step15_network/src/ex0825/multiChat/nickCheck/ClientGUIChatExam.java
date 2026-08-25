package ex0825.multiChat.nickCheck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUIChatExam extends JFrame {
	
	JTextArea textArea = new JTextArea();
	JTextField textField = new JTextField();
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	Socket sk;
	PrintWriter pw;
	BufferedReader br;
	
	public ClientGUIChatExam() {
		super();
		
		Container con = getContentPane();
		// 컴포넌트 추가
		con.add(textField, BorderLayout.SOUTH);
		con.add(scrollPane, BorderLayout.CENTER);
		//con.add(textArea);
		
		// 옵션 설정
		textArea.setFocusable(false);	// 커서 놓기 안 됨 (TextArea에 입력 방지)
		textArea.setBackground(Color.CYAN);
		
		
		//////////////////////////////////////////////
		
		//창크기
		setSize(500, 400);
		
		//정중앙 놓기
		setLocationRelativeTo(null);
		
		//보여줘
		setVisible(true);	//super.setVisible(true); super가 생략됨
		
		//x클릭 했을 때 프로그램 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE); 	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	
		//////////////////////////////////////////////////////
	
		// 서버 연결
		connection();
		
		// 서버에 데이터 전송
		// 이벤트 처리 (JTextField 에 값을 입력하고 enter 했을 때 서버에 데이터 전송)
		textField.addActionListener((e)->{
			String inputData = textField.getText();
			pw.println(inputData);
			// 내가 입력한 걸 바로 내 클라이언트에 올리지 않는다. 서버를 거쳐서 찍어야 한다.
			
			//System.out.println(inputData);
			textField.setText("");		// 엔터를 쳤을 때 입력 창을 비우는 용도
		});
		
		
		// 받는 스레드 작성
		// 서버가 보내온 데이터를 받아서 JTextArea에 추가하는 스레드
		new Thread(()->{
			try {
				while (true) {
					String data = br.readLine();
					// setText 는 덮어쓰기
					textArea.append(data + "\n");
					
					// 옵션
					// 채팅 내역이 계속 와도 스크롤이 채팅 내역을 따라가지 않기 때문
					textArea.setCaretPosition(textArea.getText().length());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		
		
	
	} // 생성자 끝

	/**
	 * 서버 접속 요청 메소드
	 */
	public void connection() {
		// 192.168.0.40
		// 192.168.0.11
		// 127.0.0.1
		try {
			sk = new Socket("127.0.0.1", 8000);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw = new PrintWriter(sk.getOutputStream(), true);
			
			/*
			// 대화명 입력 창을 띄운다.
			String name = JOptionPane.showInputDialog(this, "대화명을 입력하세요"); 	// this: 부모프레임
			// 창 무시 불가. 창에서 확인을 눌러야 메인 창에 접근 가능
			 */
			
			// 이름 중복체크 시도
			String name = null;
			while (true) {
				name = JOptionPane.showInputDialog(this, "대화명을 입력하세요");
				pw.println(name);
				
				if ("false".equals(br.readLine())) {	// false : 중복이 아님
					break;
				}else {
					JOptionPane.showMessageDialog(this, "대화명[" + name + "]이 존재합니다. 다시 입력하세요.");
				}
			}
			
			
			
			setTitle("[" + name + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new ClientGUIChatExam();

	}

}
