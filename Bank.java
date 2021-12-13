import java.util.*;

/*
 * Implement deposit and withdraw method on the Bank Class and BankOffice Class
 * Create a github account (github.com)
 * https://github.com/synac1/cmp-167-Wed-2021
 */

public class Bank extends BankAccount {

	private String name; 
	private String address;
	private int counter; 
	private int limit = 4;
	private double interest = 0.69;
	ArrayList <CheckingAccount> accounts = new ArrayList <CheckingAccount>();
	ArrayList <BankAccount> accountsOther = new ArrayList <BankAccount>();
	
	public Bank(String name, String address) {
		this.name = name;
		this.address = address;
		System.out.println("A bank has been created");
	}
	
	public void openAccount(char type) {
		if (type == 'c') {
			CheckingAccount acct = new CheckingAccount();
			accounts.add(acct);
			System.out.println("Checking account # " + acct.number + " has been created");
		}
		else if (type == 's'){ 
			SavingAccount acct = new SavingAccount();
			accountsOther.add(acct);
			System.out.println("Saving account # " + acct.number + " has been created");
		}
		else {
			BankAccount acct = new BankAccount();
			accountsOther.add(acct);
			System.out.println("Account # " + acct.number + " has been created");
		}
	}

	public void displayAll() {
		System.out.println("Checking accounts");
		for (CheckingAccount acct: accounts) {
			System.out.println(acct);
		}
		System.out.println(" Rest of the accounts ");
		for (BankAccount acct: accountsOther) {
			System.out.println(acct);
		}
	}
	
	public void desposit(double amount) {
		
		if (amount > 0.0) {
			super.deposit(amount);
		}
		else {
			System.out.print("Cannot deposit negative value");
		}
		
	}
	
	public void withdraw(double amount) {
		
		if (counter < limit) {
			super.withdraw(amount);
			counter++;
		}
		else {
			double chargedInterest = amount * interest;
			
			System.out.println("Interest to be charged " + chargedInterest);
			amount = amount - (chargedInterest);
			super.withdraw(amount);
			counter = 1;
		}
	}
	
	
	
	public String toString() {
		return "Bank " + name + ", Address: " + address + " Number of clients: " + (accounts.size() + accountsOther.size());
	}
	
} // Class










