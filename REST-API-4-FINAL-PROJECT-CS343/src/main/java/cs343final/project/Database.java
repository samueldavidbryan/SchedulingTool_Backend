package cs343final.project;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Provides an in-memory database for this project
 * 
 * @author Yesenia Mercedes-Nunez
 * @version 1.0 FALL 2018
 */
public class Database {
	private static Map<Long, Employee> employeeDb = new HashMap<Long, Employee>();
	private static final AtomicLong employeeCounter = new AtomicLong();
	private static Map<Long, Manager> managerDb = new HashMap<Long, Manager>();
	private static final AtomicLong managerCounter = new AtomicLong();
	private static HashMap<Long, Schedule> scheduleDb = new HashMap<Long, Schedule>();
	private static final AtomicLong schedulerCounter = new AtomicLong();
	private static HashMap<Long, Schedule> scheduleRequestDb = new HashMap<Long, Schedule>();
	private static final AtomicLong schedulerRequestCounter = new AtomicLong();
	
	/**
	 * Get the Employee database
	 * 
	 * @return the employee database
	 */
	public static Map<Long, Employee> getEmployeeDb() {
		return employeeDb;
	}

	/**
	 * Get the Employee counter
	 * 
	 * @return the employee counter
	 */
	public static AtomicLong getEmployeeCounter() {
		return employeeCounter;
	}

	/**
	 * Get the Manager database
	 * 
	 * @return the employee database
	 */
	public static Map<Long, Manager> getManagerDb() {
		return managerDb;
	}

	/**
	 * Get the Manager counter
	 * 
	 * @return the manager counter
	 */
	public static AtomicLong getManagerCounter() {
		return managerCounter;
	}
	
	/**
	 * Get the Manager database
	 * 
	 * @return the employee database
	 */
	public static Map<Long, Schedule> getScheduleDb() {
		return scheduleDb;
	}

	
	/**
	 * Get the Manager counter
	 * 
	 * @return the manager counter
	 */
	public static AtomicLong getScheduleCounter() {
		return schedulerCounter;
	}

	/**
	 * @return the scheduleRequestDb
	 */
	public static HashMap<Long, Schedule> getScheduleRequestDb() {
		return scheduleRequestDb;
	}

	/**
	 * @return the schedulerrequestcounter
	 */
	public static AtomicLong getSchedulerrequestcounter() {
		return schedulerRequestCounter;
	}
}
