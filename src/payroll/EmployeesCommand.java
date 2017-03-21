package payroll;
import java.util.Map;

import payroll.Command;
import payroll.Employee;

import java.text.DecimalFormat;
import java.util.Arrays;

public class EmployeesCommand implements Command {
	/** EmployeesCommand is a command class that implements the Command class, the purpose of the class
	 * is to provide an operation method, which prints employee information that the user has 
	 * requested.  */
	
	/**
	 * Initialize a formator so we can change values related to money with two decimal places  */
	DecimalFormat formator = new DecimalFormat("#.00");
	
	public void operation(Information info) {
		/**  This operation outputs the employees information command that the user has requested. The method passes 
	 *   the tree map from the Information class to access the private tree map.*/
		
		/** Make a employeeData string array, with size as the amount of employees
		 *  Initialize i, to loop through and insert information into the current i array element.
		 *  Initialize a counter that prevents the date from printing multiple times */
		String[] employeeData = new String[info.getEmployeeInfo().size()];
		int i = 0;
		int counter = 0;
		
		/** Used a enhanced for loop, loop through each employee */
		for ( Map.Entry<Integer, Employee> entry : info.getEmployeeInfo().entrySet()) {
			
			/** if the counter is 0, print the current date, and add one to counter
			 * so it doesn't happen again. */
			if (counter == 0) {
				entry.getValue().getDate();
				counter++;
			}
			
			/** Insert the name, then the id, then the type of employment, their current rate , and their new ytd, and save it 
			 * as a string in the employeeData string array, one per employee */
			employeeData[i] = entry.getValue().getNameLastFirst() + " " + "(" + entry.getValue().getTID() + ")" + " " +  entry.getValue().getEmployment() + ", " + "$" + entry.getValue().getRate() + " " + "YTD:$" + entry.getValue().getNewYTD(); 
			i++;
			
		}
		/** Sort the string array in alphabetical order, as the name is first it will be ordered by name, because this sort is a merge
		 * sort so if there are employees that share names, they will still be in id numerical order */
		Arrays.sort(employeeData);
		
		/** For each employee in the employeeData array, print their information, print the the last one with out an extra line created. */
		for (int j = 0; j < info.getEmployeeInfo().size(); j++) {
				System.out.println((employeeData[j]));

		}
	}
		
}
