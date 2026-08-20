package ex0814.map;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
	
	Properties pro = new Properties();
	
	public PropertiesExam() {
		//저장
		pro.setProperty("id","jang");
		pro.setProperty("age", "20");
		pro.setProperty("name", "희정");
		
		
		for(String key : pro.stringPropertyNames()) {
		  //조회
		  String value = pro.getProperty(key);
		  System.out.println(key + " = " + value);
		}
	}//생성자 end
	////////////////////////////////////////
	/**
     * 외부의 ~.properties파일을 로딩하는 방법 2가지
     * 1) IO를 이용한 방법
     * 2) ResourceBundle을 이용한 방법
     * 
     * 
     *  1. this.getClass().getResourceAsStream("info.properties") 
		    -> 현재 클래스가 있는 위에서부터 경로를 설정
		
		2. this.getClass().getClassLoader().getResourceAsStream("a.properties"); 
		   -> this.getClass() 호출하면 classes폴더를 기준(bin)으로 경로를 잡는다.
		
		3. 프로젝트 내 resources폴더 존재 ==> 정적문서(환경설정문서, schema, xml 문서)
		
		
		웹프로젝트 
		  1) back - resources
		  2) front  - resources/css, js,img
     * */
	
	
	// 1) IO를 이용한 방법
    public void test01() throws Exception {
    	System.out.println("=======================");
    	pro.clear();//초기화
    	
    	
    	//load는 a.properties의 key와 value를 Map형태로 만들어준다.
    	//pro.load(new FileInputStream("src/ex0814/map/a.properties"));
    	
    	
    	  //2. 클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
    	   //PropertiesExam.class 클래스가 있는 위치(폴더)가 기준이된다!!!
		  /*  InputStream inputStream =
		     PropertiesExam.class.getResourceAsStream("a.properties");
		     pro.load(inputStream);*/
		
			 //3.클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
			/* InputStream inpupStream = 
			this.getClass().getResourceAsStream("a.properties"); 
			 pro.load(inpupStream);*/
			  
		
			 //4.ClassLoader의 모든 경로에서 파일 읽음. 보통 resources 폴더의 파일 읽을때 사용.
			 InputStream inpupStream = 
			//this.getClass().getClassLoader().getResourceAsStream("ex0220/map/info.properties"); 
			 this.getClass().getClassLoader().getResourceAsStream("dbInfo.properties"); 
			 
			 pro.load(inpupStream);
			 
			
    	
    	//모든 key정보 가져오기
    	for(String key : pro.stringPropertyNames()) {
    		//저장된 정보 조회
        	String value = pro.getProperty(key);
        	System.out.println(key+" = "+ value);
    	}
    }//test01 End
    
    
    //2) ResourceBundle을 이용한 방법
    public void test02() {
    	System.out.println("---test02() -----");
    	
    	//ResourceBundle 는 ~.properties파일을 로딩하는 전용 클래스 
    	ResourceBundle rb = ResourceBundle.getBundle("dbInfo");//classes폴더를 기준으로 a.properties 로딩
        for(String key : rb.keySet()) {
        	String value = rb.getString(key);
        	System.out.println(key+" = " + value);
        }
    
    }

	public static void main(String[] args)throws Exception {
		PropertiesExam pe = new PropertiesExam();
		System.out.println("-------");
	
		//pe.test01();
		pe.test02();
	

	}

}





