import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SavingsAccount {		
	private static ArrayList<SavAccount> savingsAccountList = new ArrayList<SavAccount>();
	public static void GenerateDemoSavingsAccount(){
		SavAccount acc1 = new SavAccount();
		acc1.accountName = "Billu";
		acc1.accountNumber = 12345678;
		acc1.sortCode = "17-60-70";
		acc1.firstLineAdd = "Pontfaen";
		acc1.secondLineAdd = "Cyncoed";
		acc1.postCode = "CF14 5ED";
		acc1.interestRate = 1.50;
		acc1.balance = 250;
		savingsAccountList.add(acc1);
		
		SavAccount acc2 = new SavAccount();
		acc2.accountName = "Umer";
		acc2.accountNumber = 12344456;
		acc2.sortCode = "17-60-70";
		acc2.firstLineAdd = "Rivercross";
		acc2.secondLineAdd = "Penarth";
		acc2.postCode = "CF34 9DC";
		acc2.interestRate = 1.50;
		acc2.balance = 450;
		savingsAccountList.add(acc2);
	}
	
	public static void AddSavingsAccount(){
		SavAccount acc = new SavAccount();
		Scanner input = new Scanner ( System.in );
		
		System.out.println("Please Complete The Following Details");
        System.out.println("Name: ");
        String inAccName = input.next();
        acc.accountName = inAccName; 
        
        System.out.println("First Line of Address: ");
        String inFirstLine = input.next();
        acc.firstLineAdd = inFirstLine;
        
        System.out.println("Second Line of Address: ");
        String inSecondLine = input.next();
        acc.secondLineAdd = inSecondLine;
        
        System.out.println("Post Code: ");
        String inPostCode = input.next();
        acc.postCode = inPostCode;
        
        System.out.println("Initial Desposit Amount: ");
		double inBalance = input.nextDouble();
		acc.balance = inBalance; 
		
		acc.sortCode = "17-16-70";
		acc.accountNumber = GenerateRandomAccountNumber();
		acc.interestRate = 1.50; //Interest rate set to £1.50 .. Adds £1.50 every time money is deposited
		savingsAccountList.add(acc);
		
		try {
		    Thread.sleep(2000);                 //2000 milliseconds creates a 2 second delay.
		} 
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		System.out.println(" _______________________________________________");
		System.out.println("|  	New Account Created			|");
		System.out.println("|  Name: " + acc.accountName + "				|");	
		System.out.println("|  Account Number: " + acc.accountNumber +"			|");
		System.out.println("|  Sort Code: " + acc.sortCode +"				|");
		System.out.println("|  Balance: " + acc.balance +	"				|");		
		System.out.println("|  Interest Rate: " + acc.interestRate+"				|");		
		System.out.println("|  First Line: " + acc.firstLineAdd +"			|");		
		System.out.println("|  Second Line: " + acc.secondLineAdd+"			|");		
		System.out.println("|  PostCode: " + acc.postCode+" 				|");
		System.out.println("|_______________________________________________|");
		
		try {
		    Thread.sleep(2000);                 //2000 milliseconds creates a 2 second delay.
		} 
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}

	}
	
	//Private Method to generate Random Account Number
	private static int GenerateRandomAccountNumber(){
		Random generator = new Random(System.currentTimeMillis());
		int randomInt = generator.nextInt(10000000)+99999999;	
		return randomInt;
	}
	public static void SearchSavingsAccount()
	{
		System.out.println("Plese Enter Current Account Number To Search");
		Scanner input = new Scanner( System.in );
	    int savingsAccountNoQuery = input.nextInt();
	    
	    for (SavAccount SavingsAccount : savingsAccountList){
	    	if (SavingsAccount.accountNumber == savingsAccountNoQuery)
	    	{
	    		System.out.println(" _______________________________________________");
	    		System.out.println("|  		Account Found     		|");
	    		System.out.println("|  Name: " + SavingsAccount.accountName + "					|");	
	    		System.out.println("|  Account Number: " + SavingsAccount.accountNumber +"			|");
	    		System.out.println("|  Sort Code: " + SavingsAccount.sortCode +"				|");
	    		System.out.println("|  Balance: " + SavingsAccount.balance +	"				|");		
	    		System.out.println("|  Interest Rate: " + SavingsAccount.interestRate+"				|");	
	    		System.out.println("|  First Line: " + SavingsAccount.firstLineAdd +"				|");		
	    		System.out.println("|  Second Line: " + SavingsAccount.secondLineAdd+"				|");		
	    		System.out.println("|  PostCode: " + SavingsAccount.postCode+" 				|");
	    		System.out.println("|_______________________________________________|");
	    		
	    		try {
	    		    Thread.sleep(2000);                 //2000 milliseconds creates a 2 second delay.
	    		} 
	    		catch(InterruptedException ex) {
	    		    Thread.currentThread().interrupt();
	    		}
	    		
	    		break;
	    	}
	    	else{
	    		System.out.println("The Current Account Does Not Exist!");
	    	}
	    }
	}
	
	public static void WithdrawFromSavingsAccount(){
		System.out.println("Please Enter Savings Account Number To Withdraw Money:");
		Scanner input = new Scanner( System.in );
		int withdrawAccountNo = input.nextInt();
		for (SavAccount savAcc1 : savingsAccountList){
	    	if (savAcc1.accountNumber == withdrawAccountNo)
	    	{	
	    		System.out.println("Enter Amount To Withdraw: ");
	    		double withdrawAmount = input.nextDouble();
	    		
	    		//Check if the account has enough money to withdraw
	    		if (withdrawAmount < savAcc1.balance )
	    		{
	    		savAcc1.balance= savAcc1.balance - withdrawAmount;	
	    		System.out.println("Balance Now: " + savAcc1.balance);
	    		try {
	    		    Thread.sleep(2000);                 //Creates a 2 second delay.
	    		} 
	    		catch(InterruptedException ex) {
	    		    Thread.currentThread().interrupt();
	    		}
	    		}
	    		else
	    		{
	    			System.out.println("Insufficient Balance, Cannot Withdraw!");	
	    		}
	    		break;
	    	}
	    	else{
	    		System.out.println("The Savings Account Does Not Exist!");	
	    	}
		}
	}

	public static void DepositToSavingsAccount(){
		System.out.println("Please Enter Savings Account Number To Deposit Money:");
		Scanner input = new Scanner( System.in );
		int depositAccountNo = input.nextInt();
		for (SavAccount savAcc1 : savingsAccountList){
	    	if (savAcc1.accountNumber == depositAccountNo)
	    	{	
	    		System.out.println("Please Enter Amount To Deposit: ");
	    		double depositAmount = input.nextDouble();
	    	
	    		//Every time money is deposited into the account, interest is also added which is saved in the interestRate field in Pound Sterling
	    		savAcc1.balance= savAcc1.balance + depositAmount + savAcc1.interestRate;	
	    		System.out.println("Balance Now: " + savAcc1.balance);
	    		try {
	    		    Thread.sleep(2000);                 //creates a 2 second delay.
	    		} 
	    		catch(InterruptedException ex) {
	    		    Thread.currentThread().interrupt();
	    		}
	    		}
	    	}
	    	
		}
}