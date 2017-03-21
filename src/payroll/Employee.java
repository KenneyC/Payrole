package payroll;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Employee {
	/** Employee is a class that stores employee related things such as information about them, methods that 
	 * calculates information about the employee, and returns information about employees in strings.  */
	
	/** Initialize fields of information about the employee, these information will be given by the input 
	 * of the user */
	private int _TID;
	private String _Name;
	private String _Employment;
	private double _rate;
	private double _YTD;
	private String _start;
	private String _end;
	private double _hours;
	private double _deduction;
	
	/** Create a formator that is used to make values related to money shown in 2 decimal places */
	DecimalFormat formator = new DecimalFormat("#.00");
	
	/** Class constructor that assigns values according the the file the user has inputed.  */
	public Employee(int TID, String Name, String Employment, double rate, double YTD, String start, String end, double hours, double deduction) {
		this._TID = TID;
		this._Name = Name;
		this._Employment = Employment;
		this._rate = rate;
		this._YTD = YTD;
		this._start = start;
		this._end = end;
		this._hours = hours;
		this._deduction = deduction;
	}
	
	/** getTID is a method that returns the unique id of the employee as a string */
	public String getTID() {
		return String.valueOf(_TID);
	}
	
	/** getEmployment is a method that returns the employment type of the employee */
	public String getEmployment() {
		return this._Employment;
	}
	
	/** getRate is a method that returns the rate of the employee as a string */
	public String getRate() {
		return String.valueOf(formator.format(this._rate));
	}
	
	/** getDeduction is a function that returns the current deduction of the employee, it is formated
	 * with a formator to be outputed as 2 decimal places as a string */
	public String getDeduction() {
		return String.valueOf(formator.format(Math.round(this._deduction *100.0)/100.0));
	}
	
	/** printEmployee is a method that prints the information of the user. */
	public void printEmployees() {
		System.out.println("TID: " + _TID);
		System.out.println("Name: " + _Name);
		System.out.println("Employment: " + _Employment);
		System.out.println("rate: " + _rate);
		System.out.println("YTD: " + _YTD);
		System.out.println("start: " + _start);
		System.out.println("end: " + _end);
		System.out.println("hours " + _hours);
		System.out.println("deduction: " + _deduction);
	}
	
	/** getPeriod is a method that returns the period, that is the day startng work 
	 *  to the end in a week as a string.*/
	public String getPeriod() {
		return _start + " to " + _end;
	}
	
	/** getOvertimeHours is a method that calculates and returns the hours that a hourly employed employee has if he/she
	 * works overtime  */
	public double getOvertimeHours(){
		/** initialize time as hours for calculations*/
		double time = _hours;
		
		/** if the time is inbetween 40 to 43, multiply the extra time by 1.5 and then add 40 then return */
		if (time > 40 || time < 43) {
			return ((time - (double)40) * (double)1.5) + 40;
			
		/** else if it is less than fourty then just return the time. */
		} else if (time <= 40 ) {
			return time;
		
		/** if the time is more than 43 than double the extra hours and add to 40 then return */
		} else {
			return ((time - (double)40) * (double)2) + 40;
		}
			
	}
	
	/** getGross is a  method that calculates and returns the gross, that is the amount of money the
	 * employee has earned before tax and deductions*/
	public String getGross(){
		
		/** If the employment is salaried, then calculate the money the employee has earned in one week, ratio to the total */
		if (_Employment.equalsIgnoreCase("salaried")) {
		return formator.format(Math.round(((double)40/2080) * _rate * 100.0)/100.0);
		} 
		
		/** but if the employee is hourly then if the hours is less than or equal to fourty (no overtime) then just times the hours by the rate*/
		if (_Employment.equalsIgnoreCase("hourly")) {
			if (_hours <= 40) {
			return formator.format(Math.round(_hours * _rate* 100.0)/100.0);
			
			/** but if the employee has worked over hours then calculate the gross by using the amount of hours using 
			 * the getOvertimeHours method */
			} else
				return formator.format(Math.round(((getOvertimeHours()*_rate* 100.0)/100.0)));
		}
		return "No pay";
	} 

	/** getPAYE is a method that calculates and returns the PAYE (pay as you earn) of an employee
	 * that is the tax that an employee has to pay, as a string  */
	public String getPAYE() {
		
		/** initialize PAYE as 0*/
		double PAYE = 0;
		
		/** if the employment type is salaried the calculate the PAYE by just using the income as the rate  */
		if (_Employment.equalsIgnoreCase("salaried")) {
			double income = _rate;
			if(income > 70000) {
				PAYE += (income - (double)70000)*(double)0.33;
				income = (double)70000;
			}
			if(income> 48000) {
				PAYE += (income - (double)48000)*(double)0.30;
				income = (double)48000;
			}
			if (income > 14000) {
				PAYE += (income - (double)14000)*(double)0.175;
				income = (double)14000;
			}
			PAYE += income*(double)0.105;
			PAYE = PAYE/(double)52;
			return formator.format(Math.round(PAYE *100.0)/100.0);
			}
			 
		/** if the employment type is hourly then calculate the PAYE by getting the hours using getOvertimeHours method */
		if (_Employment.equalsIgnoreCase("hourly")) {
		double income = (getOvertimeHours() * 52) * Math.round(_rate);
		if(income > 70000) {
			PAYE += (income - (double)70000)*(double)0.33;
			income = (double)70000;
		}
		if(income> 48000) {
			PAYE += (income - (double)48000)*(double)0.30;
			income = (double)48000;
		}
		if (income > 14000) {
			PAYE += (income - (double)14000)*(double)0.175;
			income = (double)14000;
		}
		
		PAYE += income*(double)0.105;
		PAYE = PAYE/(double)52;
		return String.valueOf(formator.format(Math.round(PAYE * 100.0)/100.0));
		}
		return "No Pay";
	}
	
	/** getNett is a method that returns the amount of money the employee has earned after deducting
	 * the taxes and deductions, it is returned as a string  */
	public String getNett(){
		return formator.format(Math.round(((Double.parseDouble(getGross()) - Double.parseDouble(getPAYE()) - _deduction)*100.0))/100.0);  
	}
	
	/** getNameFirstLast is a method that returns, the name of the employee, with the first name, a space then the
	 * last name */
	public String getNameFirstLast() {
		
		/** Split the name by creating two elements that are seperated by a comma*/
		String[] name = _Name.split(",");
		
		/** return the name */
		return name[1] + " " + name[0];
	}
	/** getNameLastFirst is a method that returns the name of the employee, with the last name first 
	 * a comma, then the first name as a string */
	public String getNameLastFirst() {
		return this._Name;
	}
	
	/** getNewYTD is a method that returns the total YTD the employee has earned, that is the total amount
	 * the employee has earned after this period */
	public String getNewYTD(){
		return formator.format(Math.round((Double.parseDouble(getGross()) + _YTD) * 100.00)/100.00);
			
	}
	
	/** getDate is a method that returns the current date using DateFormat function */
	public void getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
	}	
}
	

