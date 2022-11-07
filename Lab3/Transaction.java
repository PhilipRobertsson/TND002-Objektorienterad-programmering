package Lab3;

public class Transaction {
		private int theAccount;
		private double theAmount;
		private String toFrom;
		
		public Transaction(String toFrom, int accountNumber, double amount) {
			this.toFrom = toFrom;
			this.theAccount = accountNumber;
			this.theAmount = amount;
		}
		public String toString() {
			return String.format("Money transfer %5s account %4d :%9.2f \n", this.toFrom, this.theAccount, this.theAmount);
		}
}