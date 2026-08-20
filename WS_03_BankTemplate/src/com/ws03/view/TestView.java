package com.ws03.view;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;
import com.ws03.service.BankService;

public class TestView {

	public static void main(String[] args) {
		System.out.println("***1. 고객 seq 100 에 해당하는 계좌정보 검색하기 *****");
		BankService service = new BankService();
		
        AccountDto[] accountList = service.getAccountList(400);
		
		if(accountList==null) {
			System.out.println("회원의 계좌정보가 없습니다. ");
		}else {
			System.out.println("회원계좌개수 : " + accountList.length);
			for(AccountDto dto : accountList) {
				System.out.println(dto.getAccountSeq() +" , " 
			+ dto.getAccountNumber()+" , " + dto.getUserSeq());
				
			}
		}
		
		
		System.out.println("\n\n***2. userSeq에  해당하는 고객의 정보 *************");
		UserDto userDto = service.getUserDetail(800);//300 userSeq
		if(userDto!= null) {
		  System.out.print(userDto.getUserSeq() +" , " + userDto.getName()+" , " + 
		            userDto.getEmail()+" , ");
		  System.out.println(userDto.getPhone() +" , " + userDto.isSleep());
			
		}else {
			System.out.println("회원의 정보가 없습니다.");
		}


	}//메인끝

}// 클래스 끝





