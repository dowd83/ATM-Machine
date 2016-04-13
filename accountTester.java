import java.util.*;
import java.io.IOException;
public class accountTester {
	Scanner pinInput = new Scanner(System.in);
	static HashMap<String, LinkedList<bankAccount>> allAccounts;
	static String pinNumber = "";
	private static void accountMaker() { //creates the checking and saving account for 5 seperate accounts
		allAccounts = new HashMap<String, LinkedList<bankAccount>>();
		
		LinkedList<bankAccount> accounts = new LinkedList<bankAccount>(); //account 1
		checkingsAccount tempC = new checkingsAccount(100.00);
		savingsAccount tempS = new savingsAccount(0,.01);
		accounts.add(tempC);
		accounts.add(tempS);
		allAccounts.put("0000", accounts);
			
		accounts = new LinkedList<bankAccount>(); //account 2
		tempC = new checkingsAccount(200.00);
		tempS = new savingsAccount(10,.02);
		accounts.add(tempC);
		accounts.add(tempS);
		allAccounts.put("1111", accounts);
			
		accounts = new LinkedList<bankAccount>(); //account 3
		tempC = new checkingsAccount(300.00);
		tempS = new savingsAccount(100,.03);
		accounts.add(tempC);
		accounts.add(tempS);
		allAccounts.put("2222", accounts);
		
		accounts = new LinkedList<bankAccount>(); //account 4
		tempC = new checkingsAccount(400.00);
		tempS = new savingsAccount(1000,.04);
		accounts.add(tempC);
		accounts.add(tempS);
		allAccounts.put("3333", accounts);
			
		accounts = new LinkedList<bankAccount>(); //account 5
		tempC = new checkingsAccount(500.00);
		tempS = new savingsAccount(10000,.05);
		accounts.add(tempC);
		accounts.add(tempS);
		allAccounts.put("4444", accounts);
	}
	public static bankAccount getAccount(String accountNumber) //picks the account used in the arraylist
	{
		Scanner accountInput = new Scanner(System.in);
		bankAccount temp = null;		
		boolean done = false;
			while(!done)
			{
				try 
				{
					System.out.println("Please select an account: ");
					
					LinkedList<bankAccount> accounts = allAccounts.get(accountNumber);
					System.out.println("1) Checking account: " + accounts.get(0).getCustomerNumber());
					System.out.println("2) Savings account: " +accounts.get(1).getCustomerNumber());
					System.out.print("Input: ");
					int option = accountInput.nextInt();
					switch (option) 
					{
						case 1:
							temp = accounts.get(option - 1);
							done = true;
							break;
						case 2:
							temp = accounts.get(option - 1);
							done = true;
							break;
						default:
							System.out.println("Input invalid, please try again");
							break;
					}
				}
				catch (Exception e) 
				{
					System.out.println("Invalid entry, please try again");
				}
			}
			return temp;
	}
	public static void atmTransactions() //the transaction choices
		{
			boolean done = false;
			while (!done) 
			{
				Scanner choice = new Scanner(System.in);
				Scanner amount = new Scanner(System.in);
				System.out.println("Please choose a transaction by entering the number of the transaction.");
				System.out.println("1) Withdraw");
				System.out.println("2) Deposit");
				System.out.println("3) Transfer");
				System.out.println("4) Show Balance");
				System.out.println("5) Finished transaction");
				System.out.print("Please enter the number of transaction you want: ");
				int decision = choice.nextInt();
						switch (decision) 
						{
							case 1:  //withdraw
								try 
								{
									System.out.print("Please enter the amount you would like to withdraw: ");
									double input1 = amount.nextDouble();
									bankAccount temp = getAccount(pinNumber);
									temp.withdraw(input1);
									//temp.deductFees();
									//temp.addInterest();
									break;
								} 
								catch (Exception e) 
								{
									System.out.println("Invalid amount, please try again");
									break;
								}
							case 2: //deposit
								try 
								{
									System.out.print("Please enter the amount you would like to deposit: ");
									double input2 = amount.nextDouble();
									bankAccount temp = getAccount(pinNumber);
									temp.deposit(input2);
									//temp.deductFees();
									//temp.addInterest();
									break;
								} 
								catch (Exception e) 
								{
									System.out.println("Invalid number, please try again");
									break;
								}
							case 3: //transfer
								try 
								{
									System.out.println("Please enter the amount you would like to transfer, and choose the account to transfer from: ");
									double input3 = amount.nextDouble();
									bankAccount temp = getAccount(pinNumber);
									System.out.println("Now enter the account you would like the transfer to:");
									bankAccount tempTransfer = getAccount(pinNumber);
									temp.transfer(input3, tempTransfer);
									//temp.deductFees();
									//temp.addInterest();
									break;
								} 
								catch (Exception e) 
								{
									System.out.println("Invalid number, please try again");
									break;
								}
							case 4: //get balance
								bankAccount temp = getAccount(pinNumber);
								System.out.println("Your balance is: " + temp.getBalance());
								break;
							case 5: //finish the program
								System.out.println("Thank you, and have a nice day");
								done = true;
								break;
							default: 
								System.out.println("Invalid choice");
								break;
						}
				}
		}
		public static void main(String[] args) //runs the program
		{
			bankAccount temp;
			bankAccount tempTransfer;
			boolean done = false;
			System.out.println("Welcome to Dowd National Bank");
			accountMaker();
			while(!done) 
			{
				try 
				{
					Scanner pinInput = new Scanner(System.in);
					System.out.print("Please enter your pin: ");
					pinNumber = pinInput.nextLine();
					if(allAccounts.containsKey(pinNumber)) 
					{
						System.out.println("Correct pin!");
						atmTransactions();
						done = true;
					}
				} 
				catch (Exception e) 
				{
					System.out.println("Invalid entry, please try again");
				}
			}
		}
}