package payroll;

import payroll.Command;
import payroll.BurdenCommand;
import payroll.EmployeesCommand;
import payroll.PAYECommand;
import payroll.PayslipsCommand;
import payroll.InvalidIOException;

public class UserCommand {
	/** UserCommand is a class that contains fields that are related to the input command that the 
	 *  user inputs. */
	
	/** Initialize private symbolic constants, thats represents the available input commands */
	private final String PAYSLIPS = "Payslips";
	private final String EMPLOYEES = "Employees";
	private final String BURDEN = "Burden";
	private final String PAYE = "PAYE";
	
		
	public Command commandResponse(String process) throws InvalidIOException { 
	/** commandResponse is a method that returns the correct command according to what the user has inputed
	 * by comparing what the user has input into the first argument, if a command with the wrong spelling
	 * the program will throw an exception saying that the command is invalid.*/
		
		/** check the string with if statements that if it matches any of the symbolic constants, if so then return an object
		 * of the correct command, if not then throw an InvalidCmdException*/
		if (process.equals(PAYSLIPS)) {
			return new PayslipsCommand();
		} else if (process.equals(EMPLOYEES)) {
			return new EmployeesCommand();
		} else if (process.equals(BURDEN)) {
			return new BurdenCommand();
		} else if (process.equals(PAYE)) {
			return new PAYECommand();
		} else {
			throw new InvalidIOException("Invalid command : " + process);
		}
	}
	
			
}
