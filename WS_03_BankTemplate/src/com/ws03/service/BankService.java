package com.ws03.service;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */


//자동 import 단축키 = ctrl + shift + 영문o
public class BankService {
	//final은 고정값= 값변경불가 (반드시 초기화 필수)
	final int ACCOUNT_SIZE = 10; /**계좌 최대개수*/
	final int USER_SIZE = 5;/**고객 최대개수 */
	
	
	int ACCOUNT_CURRENT_SIZE; /** 현재계좌의 개수 */
	int USER_CURRENT_SIZE; /**현재 고객의 개수 */
	
	AccountDto [] accountList;
	UserDto [] userList;
	
    
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankService() {
		//배열 생성
		 userList = new UserDto[USER_SIZE]; //5
		 accountList = new AccountDto [ACCOUNT_SIZE]; //10
		
		// 각 배열방에 고객과 계좌를 생성한다.
		 //고객 4명
		 userList[USER_CURRENT_SIZE++] = new UserDto(100, "장희정", "8253jang@daum.net", "010-8875-8253", false);
		 userList[USER_CURRENT_SIZE++] = new UserDto(200, "이효리", "lee@daum.net", "010-2222-3333", false);
		 userList[USER_CURRENT_SIZE++] = new UserDto(300, "송중기", "song@naver.com", "010-5554-2222", false);
		 userList[USER_CURRENT_SIZE++] = new UserDto(400, "삼순이", "sam@daum.com", "010-2222-2222", false);
		 
		 //계좌는 6개 정도
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(1, "1111-11111", 1000000, 100);
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(2, "2222-22222", 250000, 100);
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(3, "3333-33333", 350000, 100);
		 
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(4, "4444-44444", 150000, 200);
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(5, "5555-55555", 250000, 200);
		 
		 accountList[ACCOUNT_CURRENT_SIZE++] = new AccountDto(6, "6666-66666", 350000, 300);
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public AccountDto[] getAccountList(int userSeq) {
		 
		
		return null;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		
		
		return null;
	}

}










