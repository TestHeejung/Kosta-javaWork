
package ex0820.exam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Profile {
	Scanner sc = new Scanner(System.in);

	/**
	 * 메뉴를 출력 하는 기능
	 * */
	public Profile() {
		while(true) {
			try {
               System.out.println("1. 프로필 저장 \t 2. 프로필 불러오기 \t3. 종료");
				
				switch(sc.nextInt()) {
					case 1:
						this.saveProfile();
						break;
					case 2:
						this.loadProfile();
						break;
					case 3:
						System.exit(0);//프로그램 종료
					default: 
						System.out.println("1 또는 2의 숫자를 입력해주세요.");
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage()+"\n");
			}
		}
	}
	
	
	/**
	 * 저장기능
	 * */
	public void saveProfile() throws IOException{ //IOExecption은 FileNotFoundException의 부모 class
		System.out.print("이름> ");
		String name = sc.next(); //name.txt
		
		System.out.print("몸무게> ");
		int weight = sc.nextInt();
		
		System.out.print("비밀번호> ");
		String pw = sc.next();
		
		
		File file = new  File("C:\\Edu\\test\\"+ name +".txt");
		
		if(file.exists()) {
			throw new IOException("이미 존재하므로 다시 입력하세요.");
		}
		
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));) {
			 String data = weight + ":" + pw; 
			 
			 bos.write(data.getBytes()); //String을 byte []로 변환해서 저장한다.
			
			 bos.flush();
			System.out.println(name +".txt로 정보가 저장되었습니다.");
		}
	}
	
	
	/**
	 * 조회기능
	 * */
	public void loadProfile() throws IOException{
		System.out.print("이름> ");
		String name = sc.next();
		
		File file = new File("C:\\Edu\\test/" + name + ".txt");
		
		if(!file.exists()) {
		   throw new IOException( name+"에 해당하는 정보는 없습니다.");	
		}
		
		
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));){
			byte b [] = new byte [bis.available()];
			bis.read(b);
			
			String data = new String(b);//byte배열을 String으로 변환  --> 40:1231
			String [] dataArr = data.split(":");

			System.out.println(name + "님 몸무게는 " + dataArr[0] + "kg 이고 비번은 " + dataArr[1] + " 입니다.");
		}
	}
	
	////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
			new Profile();
	}

}





