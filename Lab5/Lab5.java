package Lab5;

/**
 * @author Philip Robertsson 
 * @version 1.0
 * This is the main class which calls on the needed classes to add employees and create companies,
 * it also handles the JOptionsPane to open a interface for the user.
 */

import javax.swing.*;

public class Lab5 {

	public static void main(String[] args) {
		
		Company theCompany = new Company();
				
		/* Directors are created as objects with an own reference variable because they are added to 
          * Workers. The entries in the constructor are the first name, surname, employee number and salary. */
		
		Director director1 = new Director("John", "Smith", 1, 700000.0);
		Director director2 = new Director("Elaine", "Garret", 2, 670000.0);
		
		// We add the directors to the company
		
		theCompany.addEmployee(director1);
		theCompany.addEmployee(director2);
		
		// We add workers to the company and assign them to a director. 
		
		theCompany.addEmployee(new Worker("Paul", "Johnson", 3, 400000.0),director1);
		theCompany.addEmployee(new Worker("Sarah", "Davidson", 4, 420000.0),director1);
		theCompany.addEmployee(new Worker("Doris","McClure", 5, 470000.0),director1);
		theCompany.addEmployee(new Worker("James", "Adams", 6, 340000.0),director1);
		theCompany.addEmployee(new Worker("Sam", "Cooper", 7, 460000.0),director2);
		theCompany.addEmployee(new Worker("Andrea","Lester", 8, 460000.0),director2);
		theCompany.addEmployee(new Worker("Olga", "Gibbs", 9, 420000.0),director2);
		
		// Code for part B.
		Employee.changeCriterion(Employee.BYNAME);
		System.out.println(theCompany.toString());
		Employee.changeCriterion(Employee.BYSALARY);
		System.out.println(theCompany.toString());
		Employee.changeCriterion(Employee.BYTAXES);
		System.out.println(theCompany.toString());
		
		// Code for part C.
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int sortCrit = Integer.parseInt(JOptionPane.showInputDialog("Sort\n 1. by name?\n 2. by salery?\n 3. by taxes?"));
		while(sortCrit !=1 && sortCrit !=2 && sortCrit !=3) {
			JOptionPane.showMessageDialog(null, "Invalid input, try again!");
			sortCrit = Integer.parseInt(JOptionPane.showInputDialog("Sort\n 1. by name?\n 2. by salery?\n 3. by taxes?"));
		}
		switch (sortCrit){
			case 1:
				sortCrit = 0;
				break;
			case 2:
				sortCrit = 1;
				break;
			case 3:
				sortCrit = 2;
				break;
		}
		Employee.changeCriterion(sortCrit);
		JOptionPane.showMessageDialog(jFrame, theCompany.toString());
	}
}
