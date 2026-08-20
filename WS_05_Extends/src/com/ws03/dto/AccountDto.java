package com.ws03.dto;

/**
 *  고객의 계좌정보 관리하는 객체
 * */
public class AccountDto  implements Comparable<AccountDto>{
   private int accountSeq;
   private String accountNumber;
   private int balance;
   
   private int userSeq;
   
   public AccountDto() {}
   public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
	this.accountSeq = accountSeq;
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.userSeq = userSeq;
  }
   
	public int getAccountSeq() {
		return accountSeq;
	}
	public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
  
    @Override
    	public String toString() {
    		StringBuilder sb = new StringBuilder();
    		sb.append(accountSeq);
    		sb.append(" | ");
    		sb.append(accountNumber);
    		sb.append(" | ");
    		sb.append(balance);
    		sb.append(" | ");
    		sb.append(userSeq);
    		
    		return sb.toString();
    	}
    
    /**
     * 잔액을 기준으로 정렬하고
     * 같으면 useSeq를 기준으로 내림차순
     * */
	@Override
	public int compareTo(AccountDto o) {
		//return balance - o.balance; //음수  0   양수 
		//return  o.balance - balance; //내림차순 
		
		return (balance - o.balance) == 0 ? 
				  (o.userSeq - userSeq) : balance - o.balance;
	}
	
}






