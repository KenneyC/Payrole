package payroll;
import java.text.DecimalFormat;
import java.util.Map;
import payroll.Command;
import payroll.Employee;


public class PayslipsCommand implements Command {
	/** PayslipsCommand is a command class that implements the Command class, the purpose of the class
	 * is to provide an operation method, which outputs the payslips information that the user has 
	 * requested.  */
	
	/** Initialize a new Information object called employeeInfoBase so the employeeInfo tree map can be accessed. 
	 *  Initialize formator that uses the DecimalFormat function to make information involved with money
	 *  to be represented in 2 decimal places*/
	DecimalFormat formator = new DecimalFormat("#.00");
	
	/** operation is a function that outputs the users requested processing, in this case, it is payslips. The method passes 
	 *   the tree map from the Information class to access the private tree map.*/
	public void operation(Information info){

		
		/** Make a counter that is used to print the date, and prevent from printing the date more that once */
		int counter = 0;
	       
		/** Using a enhanced for loop, loop through each employee object in the tree map */
	    for ( Map.Entry<Integer, Employee> entry : info.getEmployeeInfo().entrySet() ) {
	    	
	    	/** if the counter is 0, then print the date, now add one to it so that it doesnt print again */
	    	if (counter == 0) {
	    		entry.getValue().getDate();
	    		counter++;
	    	}
	    	
	    	/** First print the ID, then the name, period gross, paye, deductions, nett, and finally ytd, add 
	    	 * a dollar sign, for each information related to money. For the ytd, the counter size (size 
	    	 * is the amount of employee) decreases for each employee is printed once it reaches the end it 
	    	 * will print without making a extra line.  */
	    	System.out.print(String.valueOf(entry.getValue().getTID()) + ".");
	    	System.out.print(entry.getValue().getNameFirstLast() + ", ");
	    	System.out.print("Period: " + entry.getValue().getPeriod() + ". ");
	    	System.out.print("Gross: " + "$" + entry.getValue().getGross() + ", ");
	    	System.out.print("PAYE: " + "$" + entry.getValue().getPAYE() + ", ");
	    	System.out.print("Deductions: " + "$" + entry.getValue().getDeduction() + " ");
	    	System.out.print("Nett: " + "$" + entry.getValue().getNett() + " ");
	    	System.out.println("YTD: " + "$" + entry.getValue().getNewYTD());
	    }
	}
}
