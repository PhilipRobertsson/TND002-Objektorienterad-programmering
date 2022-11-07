package Lab3;

public class Customer {
	private String name;
	private Current currentAccount;
	private Savings savingsAccount;
	
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {return name;}
	public Current getCurrentAccount() {return currentAccount;}
	
	public void addAccounts(Current curr, Savings save) {
		this.currentAccount = curr;
		this.savingsAccount = save;
	}
	public String toString() {
			String output;
			String l1 = String.format("%16s %15s \n", "Name of customer: ", this.name);
			String l2 = String.format("%16s %15s \n", "Current account: ", this.currentAccount.getNumber());
			String l3 = String.format("%16s %15s \n", "Savings account: ", this.savingsAccount.getNumber());
			if(currentAccount != null && savingsAccount != null) {
				output = l1 + l2 + l3;
			} else {output = l1;}
			return output;
	}
	
}
