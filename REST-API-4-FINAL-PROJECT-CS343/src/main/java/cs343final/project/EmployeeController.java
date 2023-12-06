package cs343final.project;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private static final AtomicLong counter = Database.getEmployeeCounter();
	private static Map<Long, Employee> employeeDb = Database.getEmployeeDb();
	
	/**
	 * Create a new employee in the database
	 * @param employee - with first and last names
	 * @return the employeeID number
	 */
	@PostMapping("/employee/new")
	public long addNewEmployee(@RequestBody Employee employee) {
		employee.setEmplyeeIdNumber(counter.incrementAndGet());
		employeeDb.put(employee.getEmployeeID(), employee);
		return employee.getEmployeeID();
	}
	
	
	/**
     * Get a employee from the database
     * @param ID the employee id number
     * @return the customer if in the database, not found if not
     */
    @GetMapping("/employee/{ID}")
    public ResponseEntity<Object> getCustomerByNumber(@PathVariable long ID) {
    	if (employeeDb.containsKey(ID)) {
    		employeeDb.get(ID);
            return new ResponseEntity<>(employeeDb.get(ID), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Customer does not exist", HttpStatus.NOT_FOUND);
    	}
    } 
    
    /**
     * Gets all employee in the Database
     * @return all employee if in the database, not found if not
     */
    @GetMapping("/employee") 
    public ResponseEntity<Object> getEmplyeeList(){
    	if (employeeDb.isEmpty()) {
    		return new ResponseEntity<>("Employee does not exist", HttpStatus.NOT_FOUND);

    	} else {
            return new ResponseEntity<>(employeeDb.values(), HttpStatus.OK);

    	}
    }
    
    @PutMapping("/employee/{ID}/change")
    public ResponseEntity<String> changeCustomerName(@PathVariable long ID, @RequestBody Employee employee) {
    	if (employeeDb.containsKey(ID)) {
    		employeeDb.get(ID).getFirstName();
    		employeeDb.get(ID).getLastName();
    		return new ResponseEntity<>("Employee name successfully updated", HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>("Employee does not exist", HttpStatus.NOT_FOUND);
    	}
    	
    }

}

