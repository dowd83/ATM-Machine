public class savingsAccount extends bankAccount {
	public savingsAccount(double initialBalance,double interestRate)
	{		
		super(initialBalance);
		theBalance = initialBalance;
		interest = interestRate;
	}
	
	public void addInterest() 
	{
		interest = theBalance*(interest/100);
		super.deposit(interest);
	}
	private double interest;
	private double theBalance;
}