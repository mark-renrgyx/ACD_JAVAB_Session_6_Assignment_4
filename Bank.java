package week1.day6.assignment4;

public class Bank {

	public static void main(String[] args) {
		BankAtm atm1 = new BankAtm("Citi", "Dunwoody", 12000);
		BankAtm atm2 = new BankAtm("Citi", "Sandy Springs", 13000);
		BankAtm atm3 = new BankAtm("Citi", "Norcross", 14500);
		
		try {
			atm1.withdraw(2100);
			atm1.withdraw(100);
		} catch (BankATMException e) {
			System.out.println("Good it won't withdraw too much");
		}
		atm1.deposit(3000);
		try {
			atm1.withdraw(2100);
		} catch (BankATMException e) {
			System.err.println("Broken");
		}
		
		try {
			atm2.withdraw(13100);
		} catch (BankATMException e) {
			System.out.println("Good it won't withdraw too much");
		}
		
		try {
			atm2.withdraw(2100);
			atm3.withdraw(2100);
		} catch (BankATMException e) {
			System.err.println("Should have succeeded");
		}
		atm3.deposit(2100);
		
		System.out.println("ATM 1: " + atm1.getBalance());
		System.out.println("ATM 2: " + atm2.getBalance());
		System.out.println("ATM 3: " + atm3.getBalance());
	}
}
