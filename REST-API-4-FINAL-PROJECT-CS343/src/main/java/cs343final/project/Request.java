package cs343final.project;


import java.time.LocalDate;


/**
* Represents a request for a day off with a date, an enum "Status", and a request number
* 
* @author Sam Bryan and Yesenia Mercedes 
* @version Fall 2019
*/
public class Request {
	
	private LocalDate date;
	private Status status;
	private static long requestNumber;
	
	/**
	 * Constructor for class. Creates a request object
	 * @param date - date of the request
	 */
	public Request(LocalDate date) {
		this.date = date;
		this.status = Status.PENDING;
		requestNumber++;
	}
	
	/**
	 * Constructor for class. Creates a request object
	 * @param date - date of the request
	 * @param status - status (enum) of the request
	 */
	public Request(LocalDate date, Status status) {
		this.date = date;
		this.status = status;
		requestNumber++;
	}
	
	/**
	 * Returns date of the request
	 * @return date of the request
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Sets the date for the class
	 * @param date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Updates the status (enum) of the request
	 * @param status updates the status of the request
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * Returns the status of the request 
	 * @return the status of the request
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Returns the request number
	 * @return the request number
	 */
	public long getRequestNumber() {
		return requestNumber;
	}
}
