package payroll;

public interface Command {
	/**Command is an interface that each command class implements as they are command types and 
	 *  has a operation method, it provides abstraction. */
	
	/**Each command class has a operation method. */
	public void operation(Information info);
}
