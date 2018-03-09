import java.util.*;
import java.lang.String;
import java.util.Random;

public class CurrentAccount {
	private static ArrayList<CurrAccount> currAccountList = new ArrayList<CurrAccount>(); //array list to add account
	
	//This method is always called form the MainMenu class which generates demo account
	public static void GenerateDemoCurrentAccount(){
		CurrAccount acc1 = new CurrAccount();
		acc1.accountName = "Safwan";
		acc1.accountNumber = 10011123;
		acc1.sortCode = "17-60-70";
		acc1.firstLineAdd = "Pentwyn Cottage";
		acc1.secondLineAdd = "Lisvane";
		acc1.postCode = "CF14 0SH";
		acc1.overdraftCharges = 0;
		acc1.overdraftLimit =-100;
		acc1.balance = 500;
		currAccountList.add(acc1);
		
		CurrAccount acc2 = new CurrAccount();
		acc2.accountName = "Salman";
		acc2.accountNumber = 10011145;
		acc2.sortCode = "17-60-70";
		acc2.firstLineAdd = "Rowan Way";
		acc2.secondLineAdd = "Lisvane";
		acc2.postCode = "CF14 0TB";
		acc2.overdraftCharges = 0;
		acc2.overdraftLimit =-1000;
		acc2.balance = 50;
		currAccountList.add(acc2);
	}
	//This method adds the current account
	public static void AddCurrentAccount(){
		CurrAccount acc = new CurrAccount();
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
		
		System.out.println("Overdraft Charges: ");
		double inOverdraftCharges = input.nextDouble();
		acc.overdraftCharges = inOverdraftCharges; 

		System.out.println("Overdraft Limit (Input negative value): ");
		double inOverdraftLimit = input.nextDouble();
		acc.overdraftLimit= inOverdraftLimit; 
		
		acc.sortCode = "17-16-70"; //set sort code
		acc.accountNumber = GenerateRandomAccountNumber(); //generates account number by calling the method
		
		currAccountList.add(acc);
		
		try {
		    Thread.sleep(2000);                 //creates a 2 second delay.
		} 
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		System.out.println(" _______________________________________________");
		System.out.println("|  		New Account Created		|");
		System.out.println("|  Name: " + acc.accountName + "					|");	
		System.out.println("|  Account Number: " + acc.accountNumber +"			|");
		System.out.println("|  Sort Code: " + acc.sortCode +"				|");
		System.out.println("|  Balance: " + acc.balance +	"				|");		
		System.out.println("|  Overdraft Charges: " + acc.overdraftCharges+"			|");		
		System.out.println("|  Overdraft Limit: " + acc.overdraftLimit+"			|");
		System.out.println("|  First Line: " + acc.firstLineAdd +"				|");		
		System.out.println("|  Second Line: " + acc.secondLineAdd+"				|");		
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
	
	
	public static void SearchCurrentAccount()
	{
		System.out.println("Please Enter The Current Account Number You Wish To Search:");
		Scanner input = new Scanner( System.in );
	    int currAccountNoQuery = input.nextInt();
	    
	    for (CurrAccount currAcc : currAccountList){
	    	if (currAcc.accountNumber == currAccountNoQuery)
	    	{
	    		System.out.println(" _______________________________________________________");
	    		System.out.println("|  		     Account Found     			|");
	    		System.out.println("|  Name: " + currAcc.accountName + "						|");	
	    		System.out.println("|  Account Number: " + currAcc.accountNumber +"				|");
	    		System.out.println("|  Sort Code: " + currAcc.sortCode +"					|");
	    		System.out.println("|  Balance: " + currAcc.balance +	"					|");		
	    		System.out.println("|  Overdraft Charges: " + currAcc.overdraftCharges+"				|");		
	    		System.out.println("|  Overdraft Limit: " + currAcc.overdraftLimit+"				|");
	    		System.out.println("|  First Line: " + currAcc.firstLineAdd +"				|");		
	    		System.out.println("|  Second Line: " + currAcc.secondLineAdd+"					|");		
	    		System.out.println("|  PostCode: " + currAcc.postCode+" 					|");
	    		System.out.println("|_______________________________________________________|");
	    		
	    		try {
	    		    Thread.sleep(2000);                 //creates a 2 second delay.
	    		} 
	    		catch(InterruptedException ex) {
	    		    Thread.currentThread().interrupt();
	    		}
	    		
	    		break;
	    	}
	    	else{
	    		System.out.println("Current Account does not exists.");
	    	}
	    }
	}
	 
	public static void WithdrawFromCurrentAccount(){
			System.out.println("Please Enter The Current Account Number To Withdraw Money From: ");
			Scanner input = new Scanner( System.in );
			int withdrawAccountNo = input.nextInt();
			for (CurrAccount currAcc1 : currAccountList){
		    	if (currAcc1.accountNumber == withdrawAccountNo)
		    	{	
		    		System.out.println("Please Enter Amount To Withdraw: ");
		    		double withdrawAmount = input.nextDouble();
		    		currAcc1.balance= currAcc1.balance - withdrawAmount; 
		    		System.out.println("Balance Now: " + currAcc1.balance);
		    		try {
		    		    Thread.sleep(2000);                 //creates a 2 second delay.
		    		} 
		    		catch(InterruptedException ex) {
		    		    Thread.currentThread().interrupt();
		    		}
		    		
		    		//Overdraft charges, if the user goes over the overdraft limit a flat fee of £20 is charged
		    		//This amount is reduced from the balance
		    		if (currAcc1.balance < currAcc1.overdraftLimit)
		    		{
		    			currAcc1.balance = currAcc1.balance - 20.00; 
		    			System.out.println("Overdraft Limit Breached, £20 Charge Will Be Applied! ");
		    			System.out.println("New Balance: " + currAcc1.balance);
		    			try {
		    			    Thread.sleep(2000);                 //2000 milliseconds creates a 2 second delay.
		    			} 
		    			catch(InterruptedException ex) {
		    			    Thread.currentThread().interrupt();
		    			}
		    		}
			    	break;
		    	}
		    	else{
		    		System.out.println("The Current Account Does Not Exist!");	
		    	}
			}
	}
	
	public static void DepositToCurrentAccount(){
		System.out.println("Please Enter The Current Account Number To Deposit Money To: ");
		Scanner input = new Scanner( System.in );
		int depositAccountNo = input.nextInt();
		for (CurrAccount currAcc1 : currAccountList){
	    	if (currAcc1.accountNumber == depositAccountNo)
	    	{	
	    		System.out.println("Please Enter Amount To Deposit: ");
	    		double depositAmount = input.nextDouble();
	    		
	    		//If the account balance is in overdraft and the deposit amount removes this deficit, then the overdraft charge is cleared
	    		if (currAcc1.balance < currAcc1.overdraftLimit)
	    		{
	    				double balanceAfterDeposit = currAcc1.balance + depositAmount;		
	    				if (balanceAfterDeposit > currAcc1.overdraftLimit)
	    				{
	    					currAcc1.overdraftCharges = 0;
	    					currAcc1.balance = currAcc1.balance + depositAmount;
	    			  		System.out.println("Overdraft Charges Have Now Been Cleared");   					
	    			  		System.out.println("Balance Now: " + currAcc1.balance);
	    					try {
	    					    Thread.sleep(2000);                 //2000 milliseconds creates a 2 second delay.
	    					} 
	    					catch(InterruptedException ex) {
	    					    Thread.currentThread().interrupt();
	    					}
	    		    		
	    				}
	    				else
	    				{
	    					currAcc1.balance = currAcc1.balance + depositAmount;
	    					System.out.println("Balance now: " + currAcc1.balance);
	    					try {
	    					    Thread.sleep(2000);                 //creates a 2 second delay.
	    					} 
	    					catch(InterruptedException ex) {
	    					    Thread.currentThread().interrupt();
	    					}
	    				}
	    		}
	    		//If the account is not in overdraft, just add the amount
	    		else{
	    			currAcc1.balance= currAcc1.balance + depositAmount;
		    		System.out.println("Balance now: " + currAcc1.balance);
		    		try {
		    		    Thread.sleep(2000);                 //creates a 2 second delay.
		    		} 
		    		catch(InterruptedException ex) {
		    		    Thread.currentThread().interrupt();
		    		}
	    		}
	    		break;
	    	}
	    	else{
	    		System.out.println("The Current Account Does Not Exist!");	
	    	}
		}
}

}