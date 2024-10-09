package exam3;

public abstract class Employee {
	
	protected String firstName;
	protected String lastName;
	protected String securityNumber;

	public Employee(String first, String last, String snn) {
		this.firstName = first;
		this.lastName = last;
		this.securityNumber = snn;
	}
	
	
	public String toString() {
		return String.format("%s %s\nsocial security number: %s",firstName, lastName, securityNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}

	public abstract double earnings();
	
	
	
}
