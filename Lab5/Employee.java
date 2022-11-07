package Lab5;

/**
 * @author Philip Robertsson 
 * @version 1.0
 * This is the employee class, it's the super class to Worker and Director.
 * 
 */

import java.util.*;
/**Defines the class, Employee*/
public abstract class Employee implements Comparable<Employee>{
	/**Sorts by the employees names*/
	public static final int BYNAME = 0;
	/**Sorts by the employees salaries*/
	public static final int BYSALARY = 1;
	/**Sorts by the employees taxes*/
	public static final int BYTAXES = 2;
	
	/**The first name of the employee*/
	private String firstName;
	/**The surname of the employee*/
	private String secondName;
	/**The employee number of the employee*/
	private int employeeNumber;
	/**The salary of the employee*/
	private double salary;
	/**How the employees should be sorted*/
	protected static int sortCriterion;
	
	/** This is the constructor for employee. 
	 * @param fName is the first name
	 * @param sName is the surname
	 * @param emNum is the employee number
	 * @param sal is the salary
	 */
	public Employee(String fName, String sName, int emNum, double sal) {
		firstName = fName;
		secondName = sName;
		employeeNumber = emNum;
		salary = sal;
	}
	
	/** This class method allows you to change the criterion by which the employees are sorted. 
	 * @param crit the criterion to change the set criterion to
	 * */
	public static void changeCriterion(int crit) {sortCriterion = crit;}
	
	/** This instance method returns the taxes paid by the employee and it is implemented in the subclasses 
	 * @return returns the taxes
	 * */
	public abstract double computeTaxes();
	
	/** This instance method returns the surname of the employee. 
	 * @return returns the surname of an employee
	 * */
	public String getName() {return secondName;}
	
	/** This instance method returns the salary of the employee. 
	 * @return returns an employees salary
	 * */
	public double getSalary() {return salary;}
	
	/** This instance method returns the employee's number. 
	 * @return returns the employee number 
	 * */
	public int getNumber() {return employeeNumber;}
	
	/** The information about the employee is returned in the form first name (12 characters), second name (12 characters) and employee number (8 characters).
	 * If you sort by paid taxes you also attach the value of the paid taxes.
	 *  This function returns information about the employee, the information depends on the current sort criterion, 
	 * first name (12 characters), second name (12 characters) and employee number (8 characters)
	 * @return returns the information about a employee depending on the sortCriterion
	 * */
	public String toString() {
		if(sortCriterion == BYSALARY) {
			return String.format(Locale.US, "%-12s %-12s %-8d %-12.6f\n", this.firstName, this.getName(), this.getNumber(), this.getSalary());
		} else if(sortCriterion == BYTAXES) {
			return String.format(Locale.US, "%-12s %-12s %-8d %-12.6f\n", this.firstName, this.getName(), this.getNumber(), this.computeTaxes());
		}else {
			return String.format(Locale.US, "%-12s %-12s %-8d\n", this.firstName, this.getName(), this.getNumber());
		}
	}
	
	
}

