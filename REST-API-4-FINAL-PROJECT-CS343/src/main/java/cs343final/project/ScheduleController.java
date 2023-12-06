package cs343final.project;

import java.time.LocalDate;
import java.util.Date;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Controller for REST API endpoints for Schedule
 * 
 * @author Sam Bryan
 * @version Fall 2019
 */
@RestController
public class ScheduleController {

	private static Map<Long, Schedule> scheduleDb = Database.getScheduleDb();

	/**
	 * Creates a schedule for a new employee
	 * 
	 * @param employeeNumber
	 *            - number of the employee to be created
	 * @return Employee number or string if schedule already exists for that
	 *         employee
	 */
	@CrossOrigin() // to allow CORS requests when running as a local server
	@PostMapping("/schedule/new/{employeeNumber}")
	public ResponseEntity<Object> addNewSchedule(@PathVariable long employeeNumber) {
		Schedule schedule = new Schedule(employeeNumber);
		if (!scheduleDb.containsKey(schedule.getNumber())) {
			scheduleDb.put(schedule.getNumber(), schedule);
			return new ResponseEntity<>(schedule.getNumber(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Employee's schedule already exists", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Returns all requests for a given employee
	 * 
	 * @param number
	 *            - number of the employee to be returned
	 * @return The requests of an employee, or whether the employee does not exist,
	 *         or if the database is empty
	 */
	@GetMapping("/schedule/return/{number}")
	public ResponseEntity<Object> returnDates(@PathVariable long number) {
		if (!scheduleDb.isEmpty()) {
			if (scheduleDb.containsKey(number)) {
				return new ResponseEntity<>(scheduleDb.get(number).getRequests(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Employee does not exist", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>("Database is empty", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Adds request (date) for a given employee
	 * 
	 * @param number
	 *            - number of the employee
	 * @param date
	 *            - date of day to be added, in YYYY-MM-DD format
	 * @return String that date was added
	 */
	// Maybe should be put? Seems to work with post
	@CrossOrigin() // to allow CORS requests when running as a local server
	@PostMapping("/schedule/day/{number}/{date}")
	public ResponseEntity<String> addDate(@PathVariable long number, @PathVariable String date) {

		LocalDate localDate = LocalDate.parse(date);
		Request request = new Request(localDate);

		scheduleDb.get(number).addToSchedule(request);

		return new ResponseEntity<>("Date successfully added", HttpStatus.CREATED);

	}

	/**
	 * Deletes a date from a request of a given employee
	 * 
	 * @param number
	 *            - number of the employee
	 * @param date
	 *            - date of day to be removed, in YYYY-MM-DD format
	 * @return String of whether the day was successfully deleted or not or
	 *         employee's schedule does not exist
	 */
	@CrossOrigin() // to allow CORS requests when running as a local server
	@DeleteMapping("/schedule/delete/{number}/{date}")
	public ResponseEntity<String> removeDate(@PathVariable long number, @PathVariable String date) {

		LocalDate localDate = LocalDate.parse(date);
		Request request = new Request(localDate);
		if (scheduleDb.containsKey(number)) {
			if (scheduleDb.get(number).removeFromSchedule(request)) {
				return new ResponseEntity<>("Day successfully deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity("Day does not exist", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>("Schedule does not exist", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Changes the status of a request of an employee
	 * 
	 * @param number
	 *            - number of the employee
	 * @param date
	 *            - date of the day the status should be changed
	 * @param status
	 *            - status what day should be changed to
	 * @return String of whether day is successfully updated, the day does not
	 *         exist, or the employee's schedule does not exist
	 */
	@CrossOrigin() // to allow CORS requests when running as a local server
	@PutMapping("schedule/status/{number}/{date}/{status}")
	public ResponseEntity<String> updateStatus(@PathVariable Long number, @PathVariable String date,
			@PathVariable Status status) {
		LocalDate localDate = LocalDate.parse(date);

		Request request = new Request(localDate);
		if (scheduleDb.containsKey(number)) {
			if (scheduleDb.get(number).updateStatus(request, status)) {
				return new ResponseEntity<>("Status successfully updated", HttpStatus.OK);
			} else {
				return new ResponseEntity("Day does not exist", HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>("Schedule does not exist", HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Yesenia Added this
	 * 
	 * @param number
	 *            - number of the employee
	 * @param date
	 *            - date of day to be added, in YYYY-MM-DD format
	 * @return String that date was added
	 */
	// Maybe should be put? Seems to work with post
	@CrossOrigin() // to allow CORS requests when running as a local server
	@PostMapping("/schedule/day/{number}")
	public ResponseEntity<String> addBDate(@PathVariable long number, @RequestBody String date) {

		LocalDate localDate = LocalDate.parse(date);
		Request request = new Request(localDate);

		scheduleDb.get(number).addToSchedule(request);

		return new ResponseEntity<>("Date successfully added", HttpStatus.CREATED);

	}

}
