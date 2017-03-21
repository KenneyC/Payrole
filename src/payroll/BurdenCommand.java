package payroll;
import java.text.DecimalFormat;
import java.util.Map;

import payroll.Command;
import payroll.Employee;
;

public class BurdenCommand implements Command {
	/** BurdenCommand is a command class that implements the Command class, the purpose of the class
	 * is to provide an operation method, which in this class, outputs the burden information that the user has 
	 * requested.  */
	
	/**
	 * Initialize a formator, so that any output related to money is in 2 decimal places.  */ 
	DecimalFormat formator = new DecimalFormat("#.00");
	
	public void operation(Information info) {
	/** This operation outputs the burden process. The method passes 
	 *   the tree map from the Information class to access the private tree map. */
		
		/** Initialize gross, this is used to calculate and output the total gross for each employee
		 *  Initialize counter, this counter is used to print out the current latest period, and 
		 *  the current date once.  */
		double gross = 0;
		int counter = 0;
		
		/** Using a enhanced for loop, loop through the all the employees in the tree map. */
		for ( Map.Entry<Integer, Employee> entry : info.getEmployeeInfo().entrySet()) {
			
			/** if the counter is 0, print the current date and the latest period, and add one to counter
			 * so it doesn't happen again. */
			if ( counter == 0) {
				entry.getValue().getDate();
				System.out.println(entry.getValue().getPeriod());
				counter++;
			}
			
			/** Calculate the burden by getting each gross using the gross function in employee, and adding it to the total
			 * and then format it so it is at two decimal places */
			gross = gross + Double.parseDouble(entry.getValue().getGross());
			formator.format(gross);
		}
		
		/** Print the burden */
		System.out.println("Total Burden: $" + gross);		
			
	}
}
