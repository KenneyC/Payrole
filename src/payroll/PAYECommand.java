package payroll;
import java.text.DecimalFormat;
import java.util.Map;

import payroll.Command;
import payroll.Employee;


public class PAYECommand implements Command {
	/** PAYECommand is a command class that implements the Command class, the purpose of the class
	 * is to provide an operation method, in this class, outputs the PAYE information that the user has 
	 * requested.  */
	
	/**
	 * Initialize a formator so we can change values related to money with two decimal places  */
	DecimalFormat formator = new DecimalFormat("#.00");
	
	public void operation(Information info) {
	/**  This operation outputs the paye command that the user has requested. The method passes 
	 *   the tree map from the Information class to access the private tree map. */
		
	/** Initialize PAYE, used to calculate the total PAYE
	 *  Initialize counter which is used to make sure that the period and date is printed once. */
		double PAYE = 0;
		int counter = 0;
		
	/** Used a enhanced for loop, loop through each employee */
		for ( Map.Entry<Integer, Employee> entry : info.getEmployeeInfo().entrySet()) {
			
			/** if the counter is 0, print the current date and the latest period, and add one to counter
			 * so it doesn't happen again. */
			if ( counter == 0) {
				entry.getValue().getDate();
				System.out.println(entry.getValue().getPeriod());
				counter++;
			}
			/** Calculate the total paye, but getting each employee's paye and adding to PAYE.
			 *  then format PAYE so it has 2 decimal places */
			PAYE = PAYE + Double.parseDouble(entry.getValue().getPAYE());
			formator.format(PAYE);
		}
		
		/** Print the total PAYE */
		System.out.println("Total PAYE: $" + PAYE);		
			
	}
}
