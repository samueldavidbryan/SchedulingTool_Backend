package cs343final.project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import java.util.HashMap;
import java.util.Map.Entry;

/**
* Represents a schedule for an employee with employee number and hashmap of requests
* 
* @author Sam Bryan and Yesenia Mercedes 
* @version Fall 2019
*/
public class Schedule {

	private long employeeNumber;
	private HashMap<Long, Request> requests;
	
	/**
	 * Constructor to create a schedule object
	 * @param employeeNumber - number of the employee
	 */
	public Schedule(long employeeNumber) {
		this.employeeNumber = employeeNumber;
		requests = new HashMap<Long, Request>();
	}
	
	/**
	 * Sets the employee number 
	 * @param employeeNumber - number of the employee
	 */
	public void setNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	/**
	 * Returns the employee number
	 * @return the employee numer
	 */
	public long getNumber() {
		return employeeNumber;
	}
	
	/**
	 * Returns values of requests
	 * @return the values of the requests
	 */
	public Collection<Request> getRequests() {
		return requests.values();
	}
	
	/**
	 * Returns the size of requests
	 * @return the size of requests
	 */
	public int requestSize() {
		return requests.size();
	}
	
	/**
	 * Adds a day to the scehdule
	 * @param requestsToAdd - request object of request being added
	 */
	public void addToSchedule(Request requestsToAdd) {			
		if (requestsToAdd.getDate().isBefore(LocalDate.now().plus(2, ChronoUnit.WEEKS))) {
			throw new IllegalArgumentException("Time must be after today");
		}
		
		for (Entry<Long, Request> entry: requests.entrySet())
		{
			if (requestsToAdd.getDate().equals(entry.getValue().getDate())) {
				throw new IllegalArgumentException("Day already requested"); 
			}
		}
		
		if (requests.containsKey(requestsToAdd.getRequestNumber())) {
			Request req = requests.get(requestsToAdd.getRequestNumber());
			req.setDate(requestsToAdd.getDate());	
		}
		else {
			requests.put(requestsToAdd.getRequestNumber(), requestsToAdd);
		}
	}
	
	/**
	 * Removes a day from the schedule 
	 * @param requestToRemove removes a day from the schedule
	 * @return boolean of whether day was removed
	 */
	public boolean removeFromSchedule(Request requestToRemove) {
		LocalDate localDate = requestToRemove.getDate();
		
		for (Entry<Long, Request> entry: requests.entrySet())
		{
			if (localDate.equals(entry.getValue().getDate())) {
				requests.remove(entry.getKey());
				return true;
			}
		}
		return false; 
	}
	
	/**
	 * Updates the status of day to remove 
	 * @param requestToUpdate - request wants to change 
	 * @param status - the status to change to
	 * @return boolean of whether day was removed
	 */
	public boolean updateStatus(Request requestToUpdate, Status status) {
		LocalDate localDate = requestToUpdate.getDate();
		
		for (Entry<Long, Request> entry: requests.entrySet())
		{
			if (localDate.equals(entry.getValue().getDate())) {
				entry.getValue().setStatus(status);
				return true;
			}
		}
		return false; 
	}

}
