package payroll;
import java.util.Scanner;
import java.util.TreeMap;


import java.io.File;
import java.io.FileNotFoundException;

public class Information {
	/** InsertInformation is a class which contains employee information related fields and
	 *  methods. The class contains the tree map which contains all information, the method that inserts 
	 *  information into the tree map.*/

	/** Make a new tree map object named employeeInfo */
	private final TreeMap<Integer, Employee> employeeInfo = new TreeMap<Integer, Employee>();
	
	
	public void Insert(String filename ) throws FileNotFoundException  {
		/** This method inserts the employee information by taking a filename, the file name will be searched
		 * for and read by using a scanner, and information will be inputed my the put method from the map interface*/
		
		
		/** A new File object is created by taking the file name (the file will be searched for according what the user
		 * has inputed).Then Create a new Scanner object named scanFile, which will scan the File object created. */
		File file = new File(filename);
		Scanner scanFile = new Scanner(file);
		
		/** Make a while loop and stops looping whenever there is line to read or there is no next line. */
		while(scanFile.hasNextLine()) {
			
			/** Create a string, and this string is the next line to be read */
			String currentLine = scanFile.nextLine();

			/** If the current line or string does not start with #, space (empty line), or is empty
			 *  then make an string array, split the string for elements with tabs in between them using split function.
			 *  Then put the information into the tree map using the put function. Using the first
			 *  string in the string array (the unique id) as the key, and creating a new Employee
			 *  object with its constructor for the value. The elements of the string array are inserted, with
			 *   Double.parseDouble function used to insert values related to money.  */
			if (!(currentLine.startsWith("#") && !(currentLine.startsWith(" ") && !(currentLine.equals("\n") && !(currentLine.startsWith("\n")))))) {
				if (!(currentLine.trim().equals(""))) {
				String[] thisLine = currentLine.split("\t");
				employeeInfo.put(Integer.parseInt(thisLine[0]), new Employee(Integer.parseInt(thisLine[0]), thisLine[1], thisLine[2], Double.parseDouble(thisLine[3].replaceAll("[^\\d.]", "")), Double.parseDouble(thisLine[4].replaceAll("[^\\d.]", "")), thisLine[5], thisLine[6], Double.parseDouble(thisLine[7]), Double.parseDouble(thisLine[8].replaceAll("[^\\d.]", ""))));
				}
			}
			}
		
		}
	/** getEmployeeInfo is a method that returns the tree map for uses outside of this class,
	 *  as the tree map is private. */
	public TreeMap<Integer, Employee> getEmployeeInfo() {
		return employeeInfo;
	}
	
}
