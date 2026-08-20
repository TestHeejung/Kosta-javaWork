package ex0820;

import java.io.File;

import javax.swing.JOptionPane;

public class FileExam {
    public FileExam() throws Exception{
    	String path = JOptionPane.showInputDialog("파일경로는?");
    	System.out.println(path);
    	
    	File file = new File(path);
    	
    	if(file.exists()) {
    		System.out.println(path+"는 있습니다.^^");
    		
    		if(file.isDirectory()) {
    			System.out.println("폴더안에 정보를 확인 해볼게요!!");
    			String fileNames [] = file.list();
    			for(String fname : fileNames) {
    				System.out.println(fname);
    			}
    			
    		}else {
    			System.out.println("**파일의 정보를 확인해볼께요!!***");
    			System.out.println("file.canRead() = " + file.canRead());
    			System.out.println("file.canWrite() = " + file.canWrite());
    			System.out.println("file.length() = " + file.length());
    			System.out.println("file.getName() = " + file.getName());
    			System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
    			System.out.println("file.lastModified() = " + file.lastModified());
    			
    		}
    		
    	}else {
    		System.out.println(path+"가 없으니 생성할께요.");
    		//파일생성
    		//file.createNewFile();
    		
    		//폴더 생성
    		file.mkdir();
    	}
    	
    	
    }
	public static void main(String[] args)throws Exception {
		new FileExam();

	}

}
