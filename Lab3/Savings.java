package Lab3;

public class Savings extends Account {
		public Savings(Current curr, int accountNumber) {
			super(accountNumber,curr);
			this.balance = 0.0; //Set balance to 0.0
		}
		public void changeBalance(double d) {
			this.balance += d;
		}
		public double getBalance() {return balance;}
}
