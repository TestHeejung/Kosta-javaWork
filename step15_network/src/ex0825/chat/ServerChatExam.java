package ex0825.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * client와 1 : 1 채팅을 위한 Server
 * */
public class ServerChatExam {
	ServerSocket server;
    public ServerChatExam() {
    	try{
    		 server = new ServerSocket(8001);
    		 System.out.println("클라이언트 접속 대기중..");
    		 Socket sk = server.accept();
    		
    		 System.out.println(sk.getInetAddress()+"님과 대화 시작합니다.");
    		 
    		 // 보내는 스레드
    		 new SendThread(sk, "[SERVER]").start();
    		 
    		 //받는 스레드 
    		 new Thread(()->{
    			 try {
	    			 BufferedReader br = 
	    					 new BufferedReader(new InputStreamReader(sk.getInputStream()));
	    			while(true) { 
	    			 String readData = br.readLine();
	    			 if(readData.equals("exit"))break;
	    			 
	    			 System.out.println(readData);
	    			}
	    			
	    			System.out.println("서버 받는 스레드 종료합니다.^^");
    			 }catch (Exception e) {
					e.printStackTrace();
				}finally {
					System.exit(0);
				}
    			 
    		 }).start();
    		 
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
	public static void main(String[] args) {
		new ServerChatExam();

	}

}
