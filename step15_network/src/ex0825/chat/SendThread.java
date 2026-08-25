package ex0825.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대측(client or server)에게 데이터 전송하는 스레드 
 * */
public class SendThread extends Thread{
	private Socket sk;
	private String name;
	public SendThread(Socket sk, String name) {
		this.sk=sk;
		this.name=name;
	}
	
	 @Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
		  PrintWriter pw = new PrintWriter(sk.getOutputStream() , true);
		  while(true) {
			  String input = sc.nextLine();
			  if(input.equals("exit")) {
				  pw.println(input); //input 값은 exit이다. 
				  break;
			  }
			  
			  pw.println(name+" 보낸 내용 = " + input);
		  }
		  
		  System.out.println(name+"의 보내는 스레드 종료됩니다^^");
		  
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("--모든 프로그램 종료합니다.---");
			System.exit(0);
		}
	}
}











