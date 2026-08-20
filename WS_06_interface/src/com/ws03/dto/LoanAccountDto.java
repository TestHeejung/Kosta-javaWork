package com.ws03.dto;

public class LoanAccountDto extends AccountDto {
   private String mortgate;
   
   public LoanAccountDto() {}
   public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, String mortgate) {
	super(accountSeq, accountNumber, balance, userSeq);
	this.mortgate = mortgate;
  }
	public String getMortgate() {
		return mortgate;
	}
	public void setMortgate(String mortgate) {
		this.mortgate = mortgate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( super.toString() );
		builder.append(" | ");
		builder.append(mortgate);
		
		return builder.toString();
	}
   
    
   
}
