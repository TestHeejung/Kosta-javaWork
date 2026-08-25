package ex0825.multiChat.nickCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 클라이언트와 멀티채팅을 위한 Server
 */
public class ServerGUIChatExam {
	Socket sk;
	List<ClientSocketThread> list = new ArrayList<>();
	
	public ServerGUIChatExam() {
		
		try (ServerSocket server = new ServerSocket(8000)) {
			
			while (true) {
				System.out.println("client 접속 대기 중입니다...");
				sk = server.accept();
				System.out.println(sk.getInetAddress() + "님이 접속하셨습니다.");
				
				ClientSocketThread th = new ClientSocketThread();
				list.add(th);
				th.start();
				
				System.out.println("현재 접속 인원: " + list.size() + "명\n");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // constructor end
	
	
	/**
	 * 접속된 모든 클라이언트에게 데이터를 전송하는 메소드
	 */
	public void sendMessage(String message) {
		for (ClientSocketThread th : list) {
			th.pw.println(message);	//다 다른 PrintWriter
		}
	}
	

	//////////////////////////////////////////////////////////
	
	class ClientSocketThread extends Thread {
		PrintWriter pw; // 보낼 때 씀. run 메소드에 얘가 있으면 다른 애들이 사용할 수 없어서
		BufferedReader br;	//읽을 때 씀
		String nickName;
		
		public ClientSocketThread() {
			try {
				//초기화 해주기. 
				//run()에서 해도 상관은 없지만, .start()를 하기 전에 미리 생성자를 통해서 Socket에 대한 값을 세팅한 것
				pw = new PrintWriter(sk.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				////////////////////////////////////////////////////
				// 닉네임 중복 체크
				while (true) {
					boolean isExist = false;	// 중복이면 true, 중복이 아니면 false
					String newName = br.readLine();
					
					for (ClientSocketThread th : list) {
						// Socket을 받고 바로 스레드를 list에 넣어서 자기 자신이 아니라는 것도 체크해야함
						if ((this != th) && newName.equals(th.nickName)) {
							// 이름이 중복일 때
							isExist = true;
							pw.println(isExist);
							break;
						}
					}

					if (!isExist) {
						// 이름이 중복이 아닐 때 (client에 false 전달)
						pw.println(isExist);
						nickName = newName;
						break;
					}
				}	
				
				//////////////////////////////////////////////////////////
				// 접속되어 있는 모든 client 에게 알린다.
				sendMessage("----- [" + nickName + "]님이 입장하셨습니다. -----");
				
				while (true) {
					String inputData = br.readLine();
					if(inputData==null)break;
					sendMessage("[" + nickName + "] " + inputData);
					
				}
				
			} catch (Exception e) {
		
				//e.printStackTrace();
			}finally {
				
				// 현재 스레드를 list 에서 제거한다.
				list.remove(this);
				
				// 남아있는 모든 클라이언트에게 알린다.
				sendMessage("[" + nickName + "]님이 퇴장하셨습니다.");
				
				// 서버 콘솔 창에 출력한다.
				System.out.println("[" + nickName + sk.getInetAddress() + "]님 퇴장."); 
				System.out.println("현재 인원 = " + list.size());
			}
		}
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////

	public static void main(String[] args) {
		new ServerGUIChatExam();
		
		
		
		
		
	}

}
