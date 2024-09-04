
public class BankAccount {
	private double acctBalance;
	private String acctOwner;
	private boolean ownerIsSet = false;
	
	public void setName(String name) {
		if (!ownerIsSet) {
			acctOwner = name;
			ownerIsSet = true;
		} else {
			System.out.println("ERROR: owner already set");
		}
	}
	
	public String getName() {
		return (ownerIsSet ? acctOwner : "ERROR: owner not set");
	}
	
	public void addMoney(double amount) {
		if (amount > 0) {
			acctBalance += amount;
		} else {
			System.out.println("ERROR: must add positive amount");
		}
	}
	
	public void withdraw(double amount) {
		if (amount < 0 || amount > acctBalance) {
			System.out.println("ERROR: bad withdrawal amount");
		} else {
			acctBalance -= amount;
		}
	}
	
	public double balance() {
		return acctBalance;
	}

	public static void main(String[] args) {
		BankAccount paulAccount = new BankAccount();
		BankAccount sparkyAccount = new BankAccount();
		sparkyAccount.addMoney(1000000.0);
		paulAccount.addMoney(100.0);
		paulAccount.withdraw(-100.0);
		System.out.println("Paul balance is " + paulAccount.balance());
		sparkyAccount.withdraw(200000.0);
		System.out.println("Sparky balance: " +  sparkyAccount.balance());
		
	}
}
