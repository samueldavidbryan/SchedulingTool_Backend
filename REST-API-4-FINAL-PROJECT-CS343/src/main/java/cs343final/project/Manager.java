package cs343final.project;

import java.util.Date;

public class Manager extends Employee {
		
	private String department;
		
	public Manager(String firstName, String lastName, String title,
			String email, Date birthday, Date hireDate, int phone, int salary, String department) {
		super(firstName, lastName, title,
			email, birthday, hireDate, phone, salary);
		this.department = department;
	}
		
	public Manager(String firstName, String lastName, String title, String email, String department) {
		super(firstName, lastName, title,
				 email);
		this.department = department;
	}
	
	public void setDepartment(String department) {
		this.department = department;		
	}
		
	public String getDepartment() {
		return department;
	}
		
	public long getManagerID() {
		return getEmployeeID();
	}

	@Override
	public String toString() {
		return "Manager [ManagerID=" + getManagerID() + "department=" + department + ", title=" + getTitle() + ", name=" + getFirstName() + " " 
	+ getLastName() + ", BirthDate=" + getBirthday() + ", HireDate=" + getHireDate() + 
	", email=" + getEmail() + ", phone=" + getPhoneNumber() + "]";
	}
	
	/** 
	 * Customers are equal *only* if their customer numbers are equal
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
		//Needs to add birthday, hiredate, and phone
	}

}
