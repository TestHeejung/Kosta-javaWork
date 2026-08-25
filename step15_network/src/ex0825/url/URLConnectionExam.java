package ex0825.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class URLConnectionExam {
    public URLConnectionExam() {
    	try {
    	  URL url = new URI("https://www.daum.net/").toURL();
    	  
    	  InputStream is = url.openStream();
    	  
    	  BufferedReader br = new BufferedReader(new InputStreamReader(is));
    	  
    	  BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0825/url/daum.html"));
    	  
    	  while(true) {
    		  String data = br.readLine();
    		  if(data ==null) break;
    		  bw.write(data);
    		  bw.newLine();
    	  }
    	  
    	  System.out.println("완료되었습니다.");
    	  
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		new URLConnectionExam();

	}

}
