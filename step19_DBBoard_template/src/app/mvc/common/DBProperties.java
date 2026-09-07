package app.mvc.common;
/**
 * DB의 설정 정보들 상수로 관리
 * */
public interface DBProperties {
//  public static final String DRVIER_NAME="oracle.jdbc.driver.OracleDriver";
//   String URL="jdbc:oracle:thin:@localhost:1521:XE";
//   String USER_ID="c##scott";
//   String USER_PASS="TIGER";
	
	
  public static final String DRVIER_NAME="com.mysql.cj.jdbc.Driver";
  String URL="jdbc:mysql://localhost:3306/mytest";
  String USER_ID="jang";
  String USER_PASS="1234";
   
}
