package Lab5;

/**
 * @author Philip Robertsson 
 * @version 1.0
 * This is the director class which computes bonuses and taxes, compares employees and also adds workers to the right directors.
 * 
 */

import java.util.*;
/**Defines the class, Director*/
public class Director extends Employee {
	
	/**The list of all employees assigned to each director*/
	private ArrayList<Worker> theWorkers;
	
	/** This constructor is called with the details of the worker and it passes these on to the constructor of the superclass. 
	 * @param fName is the first name
	 * @param sName is the surname
	 * @param emNum is the employee number
	 * @param sal is the salary
	 */
	public Director(String fName, String sName, int emNum, double sal) {
		super(fName, sName, emNum, sal);
		theWorkers = new ArrayList<Worker>();
	}
	
	/** This instance method adds a worker to the list of subordinates of the director. 
	 * @param wrkr - this is a worker
	 * */
	public void addEmployee(Worker wrkr) {
		this.theWorkers.add(wrkr);
	}
	
	/** This instance method computes the bonus of the director. 
	 * The bonus equals the 10% of the cumulative salary of all their subordinates.
	 * @return returns the bonus depending on the workers under the director
	 */
	public double computeBonus() {
		double bonus = 0;
		for (int i = 0; i < theWorkers.size(); i++) {
			bonus += theWorkers.get(i).getSalary();
		}
		bonus = bonus *0.1;
		return bonus;
	}
	
	/** This instance method computes the taxes the director has to pay. The taxes are 25% of the sum of their salary and bonus. 
	 * @return returns the taxes for the director
	 * */
	public double computeTaxes() {
		double tax = 0.25;
		tax = (this.getSalary() + this.computeBonus())* tax;
		return tax;
	}
	
	/** This instance method compares two employees. 
	 * @param employee - another employee to compare to
	 * @return returns -1, 0, 1 depending on the current criterion 
	 * */
	public int compareTo(Employee employee) {
		if(sortCriterion == BYNAME) {
			return (Integer.signum(this.getName().compareTo(employee.getName())));
		}
		if (this.getSalary() > employee.getSalary()) {
			return -1;
		}else if (this.getSalary() < employee.getSalary()) {
			return 1;
		}else {
			return 0;
		}
	}
}
