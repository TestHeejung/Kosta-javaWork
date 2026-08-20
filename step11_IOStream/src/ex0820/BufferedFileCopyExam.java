package ex0820;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class BufferedFileCopyExam {
    public BufferedFileCopyExam(String readFileName , String writeFileName) {
    
    	BufferedInputStream bis=null;
    	BufferedOutputStream bos=null;
    	
    	try {
    		bis = new BufferedInputStream( new FileInputStream(readFileName) );
    		
    		bos = new BufferedOutputStream( new FileOutputStream(writeFileName) );
    		
    		while(true) {
    			int i = bis.read();
    			if(i==-1)break;
    			bos.write(i);
    		}
    		
    		System.out.println("복사완료되었습니다.^^");
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			  if(bis!=null)bis.close();
			  if(bos!=null)bos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    }//생성자끝
	public static void main(String[] args) {
		String readFileName = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFileName = JOptionPane.showInputDialog("저장할 파일명은?");
		
		new BufferedFileCopyExam(readFileName , writeFileName);
	}

}
