package ex0806.차준혁.ch06;

import java.util.Scanner;

public class Quiz20 {
	public static void main(String[] args) {
		new BankApplication();
	}
}

class Account {
	private String ano;
	private String owner;
	private int balance;
	
	public Account() {
		
	}
	
	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
/////////////////////////////////////////////////////////////////
class BankApplication {
	 Scanner sc = new Scanner(System.in);
	 Account[] arr = new Account[10];
	 int count = 0; //실제 배열방에 몇개의 객체가 저장되어있는지 체크!!!

	
	/////////////////////////////////////////////////
	public BankApplication() {
		
			while(true) {
				System.out.println("---------------------------------------------------------");
				System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
				System.out.println("---------------------------------------------------------");
				System.out.print("선택 > ");
				int select = sc.nextInt();
				
				if(select == 1) createAccount();
				else if(select == 2) accountList();
				else if(select == 3) deposit();
				else if(select == 4) withdraw();
				else if(select == 5) break ;
			
			}
			
			System.out.println("프로그램 종료");
	}
	
	public  void createAccount() {
		
		System.out.println("---------");
		System.out.println("계좌 생성");
		System.out.println("---------");
		System.out.println(" ");
		
		System.out.print("계좌번호 > ");
		String ano = sc.next();
		
		System.out.print("계좌주 > ");
		String owner = sc.next();
		
		System.out.print("초기 입금액 > ");
		int balance = Integer.parseInt(sc.next());
		
		
		Account ac = new Account(ano, owner, balance);
		
		arr[count++] = ac;
		System.out.println("결과: 계좌가 생성되었습니다.");
		
	}
	
	public  void accountList() {
		System.out.println("---------");
		System.out.println("계좌 목록");
		System.out.println("---------");
		
		for(int i = 0; i < count ; i++) {
			System.out.println(arr[i].getAno() + arr[i].getOwner() + arr[i].getBalance());
		}
	}
	
	
	public  void deposit() {
		System.out.println("---------");
		System.out.println("예금");
		System.out.println("---------");
		
		System.out.print("계좌번호 > ");
		String ano = sc.next();
		
		System.out.print("예금액 > ");
		int balance = Integer.parseInt(sc.next());
		
		Account ac = searchByAno(ano);
		
		if(ac == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다."); 
			return;
		}
		
		ac.setBalance(ac.getBalance() + balance);
		System.out.println("결과: 예금이 성공되었습니다.");
		
	}
	
	public  Account searchByAno(String ano) {
		for(int i = 0; i < count; i++) {
				if(arr[i].getAno().equals(ano))
					 return  arr[i]; 
		}
		
		return null;
	}
	
	public  void withdraw() {
		System.out.println("---------");
		System.out.println("출금");
		System.out.println("---------");
		
		System.out.print("계좌번호 > ");
		String ano = sc.next();
		
		System.out.print("출금액 > ");
		int balance = Integer.parseInt(sc.next());
		
		Account ac = searchByAno(ano);
		
		if(ac == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다."); 
			return;
		}
		
		if(ac.getBalance() < balance) {
			System.out.println("잔액이 부족합니다.");
		}
		
		ac.setBalance(ac.getBalance() - balance);
		
		System.out.println("결과: 출금이 성공되었습니다.");
		
	}
	
}