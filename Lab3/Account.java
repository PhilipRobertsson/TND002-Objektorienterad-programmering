package Lab3;

public class Account {
		protected int accountNumber;
		protected String accountType;
		protected double balance;
		protected Account otherAccount;
		public static final double FEE = 10.0, INTREST = 0.02;
		
		public Account (int accountNumber) {
			this.accountNumber = accountNumber;
			this.accountType = "Current";
		}
		public Account (int accountNumber, Current curr) {
			this.accountNumber = accountNumber;
			this.otherAccount = curr;
			this.accountType = "Savings";
			
			curr.otherAccount = this;
		}
		
		public String getAccountType() {return accountType;}
		public int getNumber() {return accountNumber;}
		public double getBalance() {return balance;}
		
		public void annualChange() {
			if(accountType.equals( "Current")) {
				this.balance = this.balance - FEE;
			}
			if(accountType.equals( "Savings")) {
				this.balance = this.balance + this.balance * INTREST;
			}
		}
}
