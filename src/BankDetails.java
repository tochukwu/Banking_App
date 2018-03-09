import java.util.Scanner;

public class BankDetails {

	public static void Search() {
			System.out.println(" _______________________________________________");
			System.out.println("|		SEARCH				|");
			System.out.println("|  Please Select The Type Of Account To Search 	|");		
			System.out.println("|	(1) Current Account			|");
			System.out.println("|	(2) Savings Account			|");
			System.out.println("|_______________________________________________|");
			System.out.println("Type : ");
			
			Scanner input = new Scanner( System.in );
			int choice = input.nextInt(); 
			if (choice == 1) { //Search Current Account
				CurrentAccount.SearchCurrentAccount();
			}
			else if (choice == 2){ //Search Savings account
				SavingsAccount.SearchSavingsAccount();
			}	
	
	}
	
	public static void Add(){
		System.out.println(" _______________________________________________________________");
		System.out.println("|			ADD					|");
		System.out.println("|   Please Select The Type Of Account You Would Like To Add 	|");		
		System.out.println("|	(1) Current Account					|");
		System.out.println("|	(2) Savings Account					|");
		System.out.println("|_______________________________________________________________|");
		System.out.println("Type : ");
		
		Scanner input = new Scanner( System.in );
		int choice = input.nextInt(); 
		if (choice == 1) { //Create Current Account
			CurrentAccount.AddCurrentAccount();
		}
		else if (choice == 2){
			SavingsAccount.AddSavingsAccount();
		}
	}
	
	public static void Withdraw(){
		System.out.println(" _______________________________________________________________________");
		System.out.println("|			Withdraw					|");
		System.out.println("|   Please Select The Type Of Account You Would Like To Withdraw From 	|");		
		System.out.println("|	(1) Current Account						|");
		System.out.println("|	(2) Savings Account						|");
		System.out.println("|_______________________________________________________________________|");
		System.out.println("Type : ");
		
		Scanner input = new Scanner( System.in );
		int choice = input.nextInt(); 
		if (choice == 1) { 
			CurrentAccount.WithdrawFromCurrentAccount();
		}
		else if (choice == 2){
			SavingsAccount.WithdrawFromSavingsAccount();
		}
	}
	
	public static void Deposit(){
		System.out.println(" _______________________________________________________________________");
		System.out.println("|			Deposit						|");
		System.out.println("|  Please Select The Type Of Account You Would Like To Deposit To	|");		
		System.out.println("|	(1) Current Account						|");
		System.out.println("|	(2) Savings Account						|");
		System.out.println("|_______________________________________________________________________|");
		System.out.println("Type : ");
		
		Scanner input = new Scanner( System.in );
		int choice = input.nextInt(); 
		if (choice == 1) { 
			CurrentAccount.DepositToCurrentAccount();
		}
		else if (choice == 2){
			SavingsAccount.DepositToSavingsAccount();
		}
	}
}