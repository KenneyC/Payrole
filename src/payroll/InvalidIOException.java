package payroll;

public class InvalidIOException extends Exception {
	/**InvalidIOException is a and exception class that is thrown whenever there is an error found 
	 * related to the arguments inserted by the user */
	public InvalidIOException(String message) {
		/** the constructor of the exception, it displays a message that will be different for each error. */
		super(message);
	}
}
