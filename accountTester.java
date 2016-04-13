public class accountTester {
	public static void main(String[] args) 
	{
		savingsAccount momsSavings = new savingsAccount(100,5);
		checkingsAccount harrysChecking = new checkingsAccount(100);
		momsSavings.deposit(10000);
		momsSavings.transfer(2000, harrysChecking);
		harrysChecking.withdraw(1500);
		harrysChecking.withdraw(80);
		momsSavings.transfer(1000, harrysChecking);
		harrysChecking.withdraw(400);
		momsSavings.addInterest();
		harrysChecking.deductFees();
		System.out.println("Mom's Savings balance = $" + momsSavings.getBalance());
		System.out.println("Harry's Checking balance = $" + harrysChecking.getBalance());
	}
}