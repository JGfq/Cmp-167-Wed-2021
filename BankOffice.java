import java.util.*;

public class BankOffice extends BankAccount {

	private int counter = 0;
	private int limit = 4;
	private double interest = 0.69;
	static Scanner input = new Scanner(System.in);

	public static void main (String[] args) {
		System.out.println("Welcome!");
		System.out.println("Enter a name for your bank:");
		String bankName = input.nextLine();
		System.out.println("Enter the address:");
		String bankAddress = input.nextLine();
		
		Bank bank = new Bank(bankName, bankAddress);
		
		while (true) {
			System.out.println("Would you like to create an account?");
			String answer = input.nextLine().toLowerCase();
			
			if (answer.equals("Y") || answer.contains("yeah") || answer.contains("yes") || answer.contains("yup")) {
				System.out.println("Enter checking for checking account, saving for savings account, other for any account");
				answer = input.nextLine(); 
				switch (answer) {
				case "checking" : {
					bank.openAccount('c'); 
					break;
				}
				case "saving" : 
					bank.openAccount('s');
					break;
				case "other" : 
					bank.openAccount('o');
				default:
					System.out.println("Unexpected value: " + answer);
				}
			}
			else if (answer.equalsIgnoreCase("no")) {
				System.out.println("Alright...");
				break;
			}
			
			while (true) {
				System.out.println("Would you like to display all the accounts?");
				answer = input.nextLine().toLowerCase();
				if (answer.equals("Y") || answer.contains("yeah") || answer.contains("yes") || answer.contains("yup")) {
					bank.displayAll();
				}
				else if (answer.equalsIgnoreCase("no")) {
					System.out.println("Alright... Goodbye.");
					break;
				}
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println(bank);
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
	
	
	
} // Class

