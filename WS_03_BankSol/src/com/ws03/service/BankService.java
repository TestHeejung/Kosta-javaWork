package com.ws03.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;

public class BankService {
	//final은 고정값= 값변경불가 (반드시 초기화 필수)
	final int ACCOUNT_SIZE = 10; /**계좌 최대개수*/
	final int USER_SIZE = 5;/**고객 최대개수 */
	
	int ACCOUNT_CURRENT_SIZE; //0 /** 현재계좌의 개수 - 저장된 계좌의수 */
	int USER_CURRENT_SIZE; //0 /**현재 고객의 개수 - 저장된 고객의 수 */
	
	UserDto [] userList ;//null-> 주소값
	AccountDto [] accountList ; //null
	
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
		 
		 System.out.println("---세팅완료!!----");
		 
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public AccountDto[] getAccountList(int userSeq) { // 100 
		 int searchAccountCount=0; //인수로 전달된 userSeq에 해당하는 계좌의 개수를 체크 
		
		 //리턴해서 나갈 배열의 개수를 미리 알아내여 선언하기 위해 반복문필요 
		 for(int i=0; i < ACCOUNT_CURRENT_SIZE ; i++) {
				if( accountList[i].getUserSeq()  == userSeq) {
					 //찾았다!!
					searchAccountCount++;
				}
		}
			
			//위에서 찾은 정보를 바탕으로  AccountDto배열에서 계좌정보를 찾아서  리턴해준다.
			//찾은 고객의 계좌의 수만큼 배열을 생성해서 그 배열을 리턴
			if(searchAccountCount==0)
				return null;
			
			AccountDto [] searchAccountDtoList =  new AccountDto [searchAccountCount];
			
			int count=0;
			for(int i=0; i < ACCOUNT_CURRENT_SIZE ; i++) {
				if( accountList[i].getUserSeq()  == userSeq) {
					searchAccountDtoList[count++] =  accountList[i];
				}
			}
			
			
			return searchAccountDtoList;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		for(int i=0; i< USER_CURRENT_SIZE ; i++) {
			if(userList[i].getUserSeq() == userSeq) {
				//찾았다.
				return userList[i];
			}
		}
		
		return null;
	}

}










