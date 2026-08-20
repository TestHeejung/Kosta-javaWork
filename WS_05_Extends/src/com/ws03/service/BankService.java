package com.ws03.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.dto.InstallAccountDto;
import com.ws03.dto.LoanAccountDto;
import com.ws03.dto.SavingAccountDto;
import com.ws03.dto.UserDto;

public class BankService {
	
	List<UserDto>  userList ;//null-> 
	List<AccountDto>  accountList ; //null
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankService() {
		//배열 생성
		 userList = new ArrayList<UserDto>(); 
		 accountList = new ArrayList<AccountDto>();
		
		// 각 배열방에 고객과 계좌를 생성한다.
		
		userList.add( new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false) );
		userList.add( new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true) );
		userList.add( new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false) );
		
		accountList.add( new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000) );
		
		accountList.add( new SavingAccountDto(10, "00100101001001", 500, 111, 100) );
		
		accountList.add( new LoanAccountDto(60, "00600606006006", 500, 333, "House") );
		accountList.add( new LoanAccountDto(30, "00300303003003", 0, 111, "Building") );
		
		accountList.add( new SavingAccountDto(70, "00700707007007", 500, 333, 200) );
		
		accountList.add( new LoanAccountDto(50, "00500505005005", 200, 222, "Car") );
		accountList.add( new SavingAccountDto(40, "00400404004004", 1000, 222, 50) );
		 
		 System.out.println("---세팅완료!!----");
		 
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public List<AccountDto> getAccountList(int userSeq) { // 100 
		List<AccountDto> findAccountList = new ArrayList<AccountDto>();
		
		 for(AccountDto ad : accountList) {
			if( ad.getUserSeq()  == userSeq) {
				 //찾았다!!
				findAccountList.add(ad);
			}
		 }
		
			return findAccountList;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		for(UserDto dto : userList) {
			if(dto.getUserSeq() == userSeq) {
				//찾았다.
				return dto;
			}
		}
		
		return null;
	}

	///////추가사항 ////////////
	/// 
	/**
	 * 3) 신규로, 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
	 * */
	public List<AccountDto> getAccountList() {
		return accountList;
	}
	
	
	/**
	 * 4) 신규로, 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
       : Comparable Interface 를 이용한다.
	 * */
	public List<AccountDto> getAccountListSortByBalance() {
		List<AccountDto> shallowCopyList = new ArrayList<AccountDto>(accountList);
		Collections.sort(shallowCopyList);
		
		return shallowCopyList;
	}

	
	/**
	 * 5)  신규로, 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
	 *     만약 사용자 일련번호 같으면 잔액을 기준으로 내림차순!
	 *  
       : Comparator Interface 를 이용한다.
	 * */
	public List<AccountDto> getAccountListSortByUserSeq() {
		List<AccountDto> shallowCopyList = new ArrayList<AccountDto>(accountList);
		
		Collections.sort(shallowCopyList, 
				(a,b)-> a.getUserSeq() == b.getUserSeq() ? 
						  b.getBalance()-a.getBalance() : a.getUserSeq() - b.getUserSeq());
		
		return shallowCopyList;
	}

	

}










