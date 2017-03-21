package payroll;

import payroll.Command;
import payroll.Information;
import payroll.InvalidIOException;
import payroll.UserCommand;

import java.io.FileNotFoundException;


public class Payroll  {
	/**Payroll is a program that reads a file of employee information, calculates and outputs data 
	 * information, which includes, Payslips, Burden and PAYE report, and Employee information.
	 * The program takes 2 arguments, the first being the file name (saved in args[0]), and the second
	 * a command name, which can be payslips, burden, paye, or employees (which is saved in args[1]).
	 * Author: Kenney Chan.


	 * The main method of Payroll, the method throws FileNotFoundException when the user has inputed an
	 * in valid file, and InvalidCmdException when the user has input a wrong command*/
	public static void main(String[] args) throws FileNotFoundException, InvalidIOException {
		
		/** Create a Information object which uses the insert function to add information
		 *  file (saved in args[0]) into the Tree map. */
		Information insert = new Information();
		insert.Insert(args[0]);
		
		/** Create a UserCommand object, this user command has a method called response which takes 
		 * the second argument (the desired process), which a Command object is created, and executes
		 * the correct desired processes according to args[1]. */ 
		UserCommand command = new UserCommand();
		Command cmd = command.commandResponse(args[1]);
		cmd.operation(insert); 
		
	}

}
