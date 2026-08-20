package com.ws03.view;
import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.service.BankService;

public class TestView02 {
	public static void main(String[] args) {
		
		BankService bankService = new BankService();
		System.out.println("1. 모든 계좌정보 조회 ------");
		print(   bankService.getAccountList()  );
		
		System.out.println("2.잔액기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByBalance());
		
		System.out.println("3.UserSeq 기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByUserSeq());
		
		System.out.println("4. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
	}
	
	/**
	 * 계좌목록 출력하기
	 * */
	public static void print(List<AccountDto> accountList) {
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		System.out.println();
	}

}
