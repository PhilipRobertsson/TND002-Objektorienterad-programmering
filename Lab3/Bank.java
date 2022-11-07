package Lab3;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Customer> customerList;
	private ArrayList<Account> accountList;
	private int accountNumber;
	
	public Bank() {
		customerList = new ArrayList<Customer>();
		accountList = new ArrayList<Account>();
		accountNumber = 1000;
	}
	
	public String addCustomer(String name, double amount) {
		name = name.trim();
		boolean found = false;
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getName().equals(name)) {
				found = true;
				break;
			}
		}
		if(!found) {
			Customer newCus = new Customer(name);
			customerList.add(newCus);
			
			Current currA = new Current(newCus, accountNumber, amount);
			accountNumber++;
			
			Savings saveA = new Savings(currA, accountNumber);
			accountNumber++;
			
			accountList.add(currA);
			accountList.add(saveA);
			newCus.addAccounts(currA, saveA);
			
			return "Customer added";
		} else {return "Customer already exist";}
	}
	
	public Customer findCustomer(String customerName) {
		customerName = customerName.trim();
		for (int i=0; i< customerList.size(); i++) {
			if(customerList.get(i).getName().equals(customerName)) {return customerList.get(i);}
		}
		System.out.println("Customer does not exist");
		return null;
	}
	
	public void transfer(String customerName, double amount) {
		Customer transferCus = findCustomer(customerName);
		if(transferCus != null) {
			transferCus.getCurrentAccount().transfer(amount);
		}
	}
	
	public void transfer(String customerName1, String customerName2, double amount) {
		Customer transferFrom = findCustomer(customerName1);
		Customer transferTo = findCustomer(customerName2);
		if(transferFrom != null && transferTo != null) {
			transferFrom.getCurrentAccount().transfer(transferTo.getCurrentAccount(), amount);
		}
	}
	
	public String checkAccount(int accountNumber) {
		int accN = accountNumber - 1000;
		Account specAcc = accountList.get(accN);
		
		String accountType = specAcc.getAccountType();
		if(accountType == "Current") {
			return specAcc.toString();
		} else {
			return "Not a current account";
		}
	}
	
	public void annualChange() {
		for (int i = 0; i< accountList.size(); i++) {
			accountList.get(i).annualChange();
		}
	}
	
	public String toString() {
		double sum = 0;
		for(int i = 0; i < accountList.size(); i++) {
			sum = sum + accountList.get(i).balance;
		}
		
		String output = "Bank statistics \n" + "----------------\n";
		
		String l1 = String.format("%10s %12d \n", "Customers:", customerList.size());
		String l2 = String.format("%10s %12.2f \n", "Money:", sum);
		output = output + l1 + l2;
		return output;
	}
}
