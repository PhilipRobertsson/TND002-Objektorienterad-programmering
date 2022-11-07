package Lab3;

import java.util.ArrayList;

public class Current  extends Account{
		private Customer theCustomer;
		private ArrayList<Transaction> theTransactions;
		
		public Current(Customer cust, int accountNumber, double balance) {
			super(accountNumber);
			super.balance = balance;
			theCustomer = cust;
			theTransactions = new ArrayList<Transaction>();
		}
		
		public Customer getCustomer() {return theCustomer;}
		
		public void transfer(double balance) {
			if(Math.abs(balance) > 0.0001) {
				Account currentAccount = this;
				Account savingsAccount = super.otherAccount;

				if(balance > 0) { // to savings
					if ((currentAccount.getBalance() - balance) >= 0) {
						this.theTransactions.add(new Transaction("to", savingsAccount.getNumber(), balance));
						savingsAccount.balance = savingsAccount.getBalance() + balance;
						currentAccount.balance = currentAccount.getBalance() - balance;
					} else { // move possible amount
						this.theTransactions.add(new Transaction("to", savingsAccount.getNumber(), currentAccount.getBalance()));
						savingsAccount.balance = savingsAccount.getBalance() + currentAccount.getBalance();
						currentAccount.balance = currentAccount.getBalance() - currentAccount.getBalance();
					}
				} else { // from savings
				 balance = Math.abs(balance);
					if ((savingsAccount.getBalance() - balance) >= 0) {
						this.theTransactions.add(new Transaction("from", savingsAccount.getNumber(), balance));
						currentAccount.balance = currentAccount.getBalance() + balance;
						savingsAccount.balance = savingsAccount.getBalance() - balance;
					}else { // move possible amount
						this.theTransactions.add(new Transaction("from", savingsAccount.getNumber(), savingsAccount.getBalance()));
						currentAccount.balance = currentAccount.getBalance() + savingsAccount.getBalance();
						savingsAccount.balance = savingsAccount.getBalance() - savingsAccount.getBalance();
					}
				}
			}
		}
		public void deposit(Current curr, double balance) {
			curr.theTransactions.add(new Transaction("from", this.getNumber(), balance));
			curr.balance = curr.getBalance() + balance;
		}
		public void transfer(Current curr, double balance) {
			if ( balance > this.balance) {
				balance = this.balance;
			}
			this.theTransactions.add(new Transaction("to", curr.getNumber(), balance));
			this.balance = this.getBalance() - balance;
			deposit(curr, balance);
		}
		
		public String toString() {
			String l1 = String.format("%20s %15s \n", "Customer", this.theCustomer.getName());
			String l2 = String.format("%20s %15s \n", "Account number", this.getNumber());
			String l3 = String.format("%20s %15s \n", "Balance", this.getBalance());
			String l4 = String.format("%20s %15s \n", "Savings", this.otherAccount.getBalance());
			String output = l1 + l2 + l3 + l4 + "List of transactions\n";
			for (int i = 0; i < theTransactions.size(); i++) {
				output = output + theTransactions.get(i).toString();
			}
			
			return output;
		}
}
