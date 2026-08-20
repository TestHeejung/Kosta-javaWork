package ex0820;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {
    public FileInputOutputExam() {
    	FileInputStream fis=null;
    	FileOutputStream fos=null;
    	
    	try {
    	   //byte단위로 파일 읽기
    	   fis = new FileInputStream("src/ex0820/a.txt");
    	   /*while(true) {
	    	   int i = fis.read();//1byte씩 읽기
	    	   if(i==-1)break;
	    	   System.out.println(i +" = " + (char)i);
    	   }*/
    	   
    	   //////////////////////////////////////
    	   
    	  int len = fis.available();//읽을수 있는  byte수 반환
    	  System.out.println("len = " + len);
    	  
    	   //byte []크기 만큼 한번에 읽기
    	   byte [] b = new byte [len];
    	   fis.read(b);
    	   
    	   //byte[]을 String 변환 방벙
    	   String str = new String(b);
    	   System.out.println(str);
    	   System.out.println("**완료**");
    	   
    	   //파일에 내용 저장=쓰기
    	   fos = new FileOutputStream("src/ex0820/save.txt");
    	  // fos = new FileOutputStream("src/ex0820/save.txt", true);
    	   /*fos.write(65);
    	   fos.write(66);
    	   fos.write(67);
    	   
    	   fos.write(13);
    	   fos.write(10);
    	   
    	   fos.write(70);
    	   
    	 // String -> byte[]로 변환 
    	   String data="집에 가고싶어요~";
    	   fos.write(data.getBytes());*/
    	   
    	   fos.write(b);
    	   
    	  
    	}catch (IOException e) {
           e.printStackTrace();
 
    	}finally {
    		try {
    	    	if(fis!=null) fis.close();
    	    	if(fos!=null) fos.close();
    		}catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }//생성자 끝
    
	public static void main(String[] args) {
		new FileInputOutputExam();

	}

}
