package db.util;

/**
 *  DB 설정 정보들을 상수로 관리
 * */
public interface DbProperties {
	
	   public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	   String URL="jdbc:mysql://localhost:3306/ex0227";
	   String USER_ID="jang";
	   String USER_PASS="1234";
	   
	//////ORACLE Connection////////////////////
//    public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//    String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//    String USER_ID = "c##exam";
//    String USER_PASS = "1234";
	

		  
}
