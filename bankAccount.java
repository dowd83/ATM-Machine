//import java.io.IOException;
public class bankAccount
{
	public bankAccount() 
	{
		//cNumber = 0;
		//pin = 0;
		balance = 0;
	}
	public bankAccount(double initialBalance) 
	{
		//pin = pinNumber;
		//customNumber = cNumber;
		//double intialBalance;
		balance = initialBalance;
	}
	public void deposit(double amount) 
	{
		balance = balance + amount;
		//balance = newBalance;
	}
	public void withdraw(double amount) 
	{
		balance = balance - amount;
		//balance = newBalance;
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
	//private int cNumber;
	//private int pin;
	private double balance;
}