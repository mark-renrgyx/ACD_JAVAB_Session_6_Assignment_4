package week1.day6.assignment4;

public class BankAtm {
	private static volatile int atmNum = 1;
	
	private int atmId;
	private String bankName;
	private String location;
	private volatile double balance;
	
	public BankAtm(String bankName, String location, double balance) {
		this.bankName = bankName;
		this.location = location;
		this.balance = balance;
		
		synchronized (this) {
			this.atmId = atmNum;
			atmNum++;
		}
	}
	
	public void withdraw (double amt) throws BankATMException {
		synchronized(this) {
			if (balance < 10000 || balance < amt)
				throw new BankATMException("ATM out of funds");
			balance -= amt;
		}
	}
	
	public void deposit (double amt) {
		synchronized(this) {
			balance += amt;
		}
	}
	
	public int getAtmId() {
		return atmId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
