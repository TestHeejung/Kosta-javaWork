package com.ws03.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.dto.InstallAccountDto;
import com.ws03.dto.LoanAccountDto;
import com.ws03.dto.SavingAccountDto;
import com.ws03.dto.UserDto;
import com.ws03.exception.BalanceLackException;
import com.ws03.exception.UserAccountNotFoundException;

public class BankServiceImpl implements BankService {

	List<UserDto> userList;
	
	List<AccountDto> accountList ;
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankServiceImpl() {
        userList = new ArrayList<UserDto>(); 
		 accountList = new ArrayList<AccountDto>(); 

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
	}
	
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	@Override
	public List<AccountDto> getAccountList(int userSeq) { // 100 200  ... 
		//리턴할 List 준비 --> 찾은 계좌정보를 저장해서 리턴
		List<AccountDto> searchAccountDtoList = new ArrayList<AccountDto>();
		
		for(AccountDto dto : accountList) {
			if( dto.getUserSeq() == userSeq) {
				searchAccountDtoList.add(dto);
			}
		}
		
		return searchAccountDtoList;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	@Override
	public UserDto getUserDetail(int userSeq) {
		for(UserDto dto : userList) {
			if(dto.getUserSeq() == userSeq) {
				return dto;
			}
		}
		
		return null;
	}
	
	
    /**
     *  3) 신규로, 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
     * */
	@Override
	public List<AccountDto> getAccountList() {
		return accountList;
	}

	
	/**
	 * 4) 신규로, 잔고(balance) 기준으로 정렬한 
	 * 모든 계좌 목록을 리턴 하는 메소드를 작성한다.
       : Comparable Interface 를 이용한다.
	 * */
	@Override
	public List<AccountDto> getAccountListSortByBalance() {
		List<AccountDto> sortedAccList = new ArrayList<AccountDto>(accountList);
		
		//The method sort(List<T>) in the type Collections 
		 //is not applicable for the arguments (List<AccountDto>)
		
		Collections.sort(sortedAccList);
		
		return sortedAccList;
	}

	/**
	 *  5)  신규로, 사용자 일련번호 기준으로 정렬한 모든 계좌 목록을 
	 *  리턴 하는 메소드를 작성한다. 
       : Comparator Interface 를 이용한다.
	 * */
	@Override
	public List<AccountDto> getAccountListSortByUserSeq() {
		List<AccountDto> sortedList = new ArrayList<AccountDto>(accountList);
		
		//1. 외부에 구현객체 만들어서 사용하는 방법
		//Collections.sort(sortedList, new AccountSortImpl() );
		
		
		//2. 인수에 직접 구현하는 방법  - Anonymous Inner type
		//재사용성은 낮지만 1회성으로 정렬하는 순간에만 사용하려면
		//별도의 구현객체를 만들지 않고 전달되는 인수에 직접 구현하는 방법있다.
		// Anonymous Inner type이라고 한다.
		/*Collections.sort(sortedList,  new Comparator<AccountDto>() {
			public int compare(AccountDto o1, AccountDto o2) {
				return o1.getUserSeq() - o2.getUserSeq();
			};
		} );*/
		
		
		//3. 람다식 방법   () -> {} 
		Collections.sort(sortedList , 
				  (o1, o2)-> o1.getUserSeq() - o2.getUserSeq()  );
		
		
		
		return sortedList;
	}

  /////WS_07 추가 메소드///////////////////////////////
	/**
	 * : 고객의 일련번호와 계좌 일련번호를 입력받아 계좌 정보를 리턴 한다.
	 *  이 때, 일치하 는 계좌가 없을 경우 UserAccoutNotFoundException 을 발생시키고 
	 *  이 요청을 수행하는 코드에서 처리한다
	 * */
	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {

		for(AccountDto account : accountList) {
			 if(account.getUserSeq() == userSeq && account.getAccountSeq() == accountSeq) {
				return account;
			 }
		 }
		 //못찾았다.
		 throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다.");
	}


	/**
	 * 고객의 일련번호, 계좌 일련번호, 그리고 출금금액을 입력받아 출금 처리한다.
	 *  이 때, 잔액이 부족할 경우, BalanceLackException 을 발생시키고, 
	 *  이 요청을 수행하는 코드에서 처리한다
	 * */
	@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
			throws BalanceLackException, UserAccountNotFoundException {
	
		  AccountDto dto = this.getUserAccount(userSeq, accountSeq);
		  
		  if(dto.getBalance() < amount) {
			  throw new BalanceLackException("잔액이 부족합니다.!!!");
		  }
		  
		  
		  dto.setBalance( dto.getBalance() - amount  );
		
		return dto.getBalance();//인출후 잔액 리턴!!
	}

}

/////////////////////////////////////
/**
 * 정렬
 *   : compare메소드에 전달된 두개의 객체를 비교해서 int형를 리턴(음수, 0 , 양수)
 *   :재사용성이 높다 - 구현객체를 만들어서 사용하면..
 * */
class AccountSortImpl implements Comparator<AccountDto>{
	@Override
	public int compare(AccountDto o1, AccountDto o2) {
		
		//return o1.getUserSeq() - o2.getUserSeq();
		return  o2.getUserSeq() - o1.getUserSeq() ;
	}
}








