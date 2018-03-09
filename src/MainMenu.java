import java.util.Scanner;
import java.lang.String;


public class MainMenu {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit = false;
		
	do {	
		System.out.println(" _______________________________________________"); 
		System.out.println("|						|"); 
		System.out.println("|  		MAIN MENU			|");
		System.out.println("|  Please Select From The Following Option	|");	
		System.out.println("|  (1) Search An Account       	    		|");
		System.out.println("|  (2) Add An Account 				|");
		System.out.println("|  (3) Withdraw from Account 			|");
		System.out.println("|  (4) Deposit to Account 			|");
		System.out.println("|  (5) Generate Demo Accounts			|");	
		System.out.println("|  (6) Exit Program				|");	
		System.out.println("|_______________________________________________|");
		
		System.out.println("Option : ");
		
		Scanner input = new Scanner( System.in );
		int choice = input.nextInt(); 
		if (choice == 1) { 
			BankDetails.Search();
		}	
		if (choice == 2) { 
			BankDetails.Add();
		}
		
		if (choice == 3) { 
			BankDetails.Withdraw();
	}
		
		if (choice == 4) {
			BankDetails.Deposit();
		}
		
		if (choice == 5) {
			CurrentAccount.GenerateDemoCurrentAccount();
			SavingsAccount.GenerateDemoSavingsAccount();
			System.out.println("***** Demo Current & Savings Accounts Created ***** ");
			try {
			    Thread.sleep(1000);                 //1000 milliseconds creates a 1 second delay.
			} 
			catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
		}
		if (choice == 6){
			System.exit(0);
		}
	}
	while (!quit);
	System.out.println("Bye");
	}
}
