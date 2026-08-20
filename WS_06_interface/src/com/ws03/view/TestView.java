package com.ws03.view;

import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;
import com.ws03.service.BankService;
import com.ws03.service.BankServiceImpl;

public class TestView {

	public static void main(String[] args) {
		System.out.println("***1. 고객seq에 해당하는 계좌정보 검색하기 *****");
		BankService service = new BankServiceImpl();
		
        List<AccountDto> accountList = service.getAccountList(111);
		
		if(accountList.isEmpty()) {
			System.out.println("회원의 계좌정보가 없습니다.");
		}else {
			System.out.println("회원계좌개수 : " + accountList.size());
			for(AccountDto dto : accountList) {
				System.out.println(dto); //accountSeq | accountNumber | balance | userSeq
			}
		}
		
/////////////////////////////////////////////////////////////////////////		
		System.out.println("\n***2. userSeq에 해당하는 고객의 정보 *************");
		UserDto userDto = service.getUserDetail(111);
		if(userDto!= null) {
		  System.out.println(userDto);
			
		}else {
			System.out.println("회원의 정보가 없습니다.");
		}
		
		
		
	}//메인끝

}// 클래스 끝





