package com.ws03.service;

import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;
import com.ws03.exception.BalanceLackException;
import com.ws03.exception.UserAccountNotFoundException;

public interface BankService {
	/**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	 List<AccountDto> getAccountList(int userSeq) ;
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	 UserDto getUserDetail(int userSeq);
	
  /**
   *  3) 신규로, 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
   * */
	 List<AccountDto> getAccountList() ;
	
	/**
	 * 4) 신규로, 잔고(balance) 기준으로 정렬한 
	 * 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
     : Comparable Interface 를 이용한다.
	 * */
	 List<AccountDto> getAccountListSortByBalance() ;
	/**
	 *  5)  신규로, 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 
	 *  리턴 하는 메소드를 작성한다. 
     : Comparator Interface 를 이용한다.
	 * */
	 List<AccountDto> getAccountListSortByUserSeq() ;
	 
	 //////WS_07에 추가된 메소드////////////////////////////////////
	 AccountDto getUserAccount(int userSeq, int accountSeq) 
			 throws UserAccountNotFoundException;
	 
	int withdraw(int userSeq, int accountSeq, int amount) 
			 throws BalanceLackException, UserAccountNotFoundException;
}









