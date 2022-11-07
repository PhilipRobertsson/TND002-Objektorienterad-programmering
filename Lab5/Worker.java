package Lab5;

/**
 * @author Philip Robertsson 
 * @version 1.0
 * This is the worker class, similarly to the director class it computes taxes and compares employees.
 * 
 */

/**Defines the class, Worker*/
public class Worker extends Employee {
	
	/** This constructor is called with the details of the worker and it passes these on to the constructor of the superclass. 
	 * @param fName is the first name
	 * @param sName is the surname
	 * @param emNum is the employee number
	 * @param sal is the salary
	 */
	public Worker(String fName, String sName, int emNum, double sal) {
		super(fName, sName, emNum, sal);
	}
	
	/** This instance method computes the taxes the worker has to pay. The taxes are 25% of the salary. 
	 * @return returns the taxes (25% of the salary)
	 * */
	public double computeTaxes() {
		double tax = 0.25;
		tax = this.getSalary() * tax;
		return tax;
	}
	
	/** This instance method compares two employees.
	 *  a value -1, 0, 1 depending on if the salary of this employee is higher, equal or lower than that of the argument employee. 
	 *  @param employee to compare to
	 *  @return -1, 0 or 1 
	 *  */
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
