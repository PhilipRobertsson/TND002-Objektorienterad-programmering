package Lab5;
/**
 * @author Philip Robertsson 
 * @version 1.0
 * This is the company class which adds directors to the company and then adds workers to both the company and to the right directors.
 * This class also writes out all employees of the company as strings.
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
/**Defines the class, Company*/
public class Company extends Object{
	
	/**The list of all employees*/
	private ArrayList<Employee> theEmployees;
	
	/*The constructor for Company takes no argument*/
	public Company() {
		this.theEmployees = new ArrayList<Employee>();
	}
	
	/** This instance method adds a director to the dynamic array of employees. 
	 * @param dic adds a director to the company
	 * */
	public void addEmployee(Director dic) {
		theEmployees.add(dic);
	}
	
	/** This instance method adds a worker to the dynamic array of employees and attaches it to one director. 
	 * @param wrkr - adds a worker
	 * @param dic - assigned to a director
	 * */
	public void addEmployee(Worker wrkr, Director dic) {
		theEmployees.add(wrkr);
		dic.addEmployee(wrkr);
	}
	
	/** This instance method writes out a header followed by the sorted list of employees.
	 *  It creates a title string that depends on the sorting criterion, it sorts the list of employees 
	 *  according to the criterion and concatenates the return values of the toString methods of all employees to one large string, which is then returned.
	 *  @return returns the information of all the employees
	 *  */
	public String toString() {
		String head = "List of Employees \n" + "-------------------\n";
		
		head = head + String.format("%-12s %-12s %-8s ", "First name", "Surname", "Number");
		if (Employee.sortCriterion == Employee.BYSALARY) {
			head = head +String.format("%-12s","Salery");
		} else if (Employee.sortCriterion == Employee.BYTAXES) {
			head = head +String.format("%-12s","Taxes");
		}
		head = head + "\n\n";
		Collections.sort(theEmployees);
		String bod = "";
		for ( int i = 0; i < theEmployees.size(); i++) {
			bod = bod + theEmployees.get(i).toString();
		}
		return head+bod;
		
	}
}
