public class checkingsAccount extends bankAccount {
	public checkingsAccount(double intialBalance)
	{
		super(intialBalance);
		transactionCount = 0;
	}
	
	public void deposit(double amount) 
	{
		transactionCount++;
		super.deposit(amount); 
	}
	
	public void withdraw(double amount) 
	{
		transactionCount++;
		super.withdraw(amount); 
	}

	public void deductFees() 
	{
		if(transactionCount > free_Transactions) 
		{
			double fees = transaction_Fees*(transactionCount - free_Transactions);
			super.withdraw(fees);
		}
		transactionCount = 0;
	}
	private int transactionCount;
	private static final int free_Transactions = 3;
	private static final double transaction_Fees = 2.0;
}