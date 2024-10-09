package exam3;

public class HourlySalary extends Employee {

	private double hourEarn,hourWorked;

	public HourlySalary(String first, String last, String snn,double hourEarn,int hourWorked) {
		super(first, last, snn);
		this.setHourSalary(hourEarn);
		this.hourWorked = hourWorked;
	}

	@Override
	public double earnings() {
		return hourEarn * hourWorked;
	}
	
	public String toString() {
		return String.format("\nhourly employee: %s %s\nsocial security number: "
				+ "%s\nhourly pay: $ %.2f; hours worked: %.2f"
				+ "" ,firstName, lastName, securityNumber, hourEarn, hourWorked);
	}

	public double getHourSalary() {
		return hourEarn;
	}

	public void setHourSalary(double hourSalary) {
		this.hourEarn = hourSalary;
	}
	
	public double getHourWorked() {
		return this.hourWorked;
	}
}
