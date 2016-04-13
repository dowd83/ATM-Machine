import java.util.Random;
public class bankAccount
{
	public bankAccount() 
	{
		balance = 0;
		customerNumber = getCustomerNumber();
	}
	public bankAccount(double initialBalance) 
	{
		balance = initialBalance;
	}
	public int getCustomerNumber() //need to fix the random generator
	{
		Random generator = new Random();
		int cNumber = generator.nextInt(10);
		return cNumber;
	}
	public void deposit(double amount) 
	{
		balance = balance + amount;
	}
	public void withdraw(double amount) 
	{
		balance = balance - amount;
	}
	public double getBalance() 
	{
		return balance;
	}
	public void transfer(double amount, bankAccount other)
	{
		withdraw(amount);
		other.deposit(amount);
	}
	private int customerNumber;
	private double balance;
}