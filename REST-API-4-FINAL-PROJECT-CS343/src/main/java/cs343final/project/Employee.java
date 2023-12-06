package cs343final.project;

import java.util.Date;

/**
 * Represent an employee with employee id, title, email, birthday, hire date,
 * and phone number.
 * 
 * @author Yessy
 * @version 1.0 FALL 2018
 *
 */
public class Employee {

	private String firstName;
	private String lastName;
	private String title;
	private String email;
	private Date birthday;
	private Date hireDate;
	private int salary;
	private int phone; // This should be fix to prob char or string

	private long employeeID;

	public Employee() {
		super();
	}
	
	/**
	 * Constructs an Employee with name (first and last name), title, email,
	 * birthday, hire date, and phone number.
	 * 
	 * @param employeeID
	 * @param firstName
	 * @param lastName
	 * @param title
	 * @param email
	 * @param birthday
	 * @param hireDate
	 * @param phone
	 */
	public Employee(String firstName, String lastName, String title, String email, Date birthday, Date hireDate,
			int phone, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.email = email;
		this.birthday = birthday;
		this.hireDate = hireDate;
		this.phone = phone;
		this.setSalary(salary);
	}

	/**
	 * Constructs an Employee with name (first and last name), title, email
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Employee(String firstName, String lastName, String title, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.email = email;
	}
	
	/**
	 * Set the employeeID number
	 * 
	 * @param employeeIdNumber - the employee ID number
	 */
	public void setEmplyeeIdNumber(long employeeIdNumber) {
		this.employeeID = employeeIdNumber;
	}

	/**
	 * Returns the emoplyeeID number
	 * 
	 * @return the employeeID
	 */
	public long getEmployeeID() {
		return employeeID;
	}

	/**
	 * Returns the first name
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the last name
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhoneNumber(int phone) {
		this.phone = phone;
	}

	public int getPhoneNumber() {
		return phone;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + employeeID + ", title=" + title + ", name=" + firstName + " " + lastName
				+ ", BirthDate=" + birthday + ", HireDate=" + hireDate + ", email=" + email + ", phone=" + phone + "]";
	}

	/**
	 * Customers are equal *only* if their customer numbers are equal
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
		// Needs to add birthday, hiredate, and phone
	}

}
