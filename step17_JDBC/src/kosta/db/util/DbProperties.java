package kosta.db.util;

/**
 * Db설정 정보를 상수로 관리
 * */
public interface DbProperties {
	public static final String DRVIER_NAME="com.mysql.cj.jdbc.Driver";
	
    String URL="jdbc:mysql://localhost:3306/mytest";
    String USER_ID="jang";
    String USER_PASS="1234";
}
