package com.ws03.exception;

/**
 * 회원 정보가 없을때 발생시킬 예외 객체
 * */
public class UserAccountNotFoundException extends Exception {
   public UserAccountNotFoundException() {
	   super("회원정보를 확인해주세요.");
   }
   public UserAccountNotFoundException(String mesage) {
	   super(mesage);
   }
}
