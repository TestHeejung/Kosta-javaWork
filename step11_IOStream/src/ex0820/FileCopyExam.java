package ex0820;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyExam {
    public FileCopyExam(String readFileName , String writeFileName) {
    	FileInputStream fis=null;
    	FileOutputStream fos=null;
    	try {
    		fis = new FileInputStream(readFileName);
    		fos = new FileOutputStream(writeFileName);
    		
    		while(true) {
    			int i = fis.read();
    			if(i==-1)break;
    			fos.write(i);
    		}
    		
    		System.out.println("복사완료되었습니다.^^");
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			  if(fis!=null)fis.close();
			  if(fos!=null)fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    }//생성자끝
	public static void main(String[] args) {
		String readFileName = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFileName = JOptionPane.showInputDialog("저장할 파일명은?");
		
		new FileCopyExam(readFileName , writeFileName);
	}

}
