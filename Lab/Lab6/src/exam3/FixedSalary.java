package exam3;

public class FixedSalary extends Employee{
	
	private double monthSalary;

	public FixedSalary(String first, String last, String snn,double monthsala) {
		super(first, last, snn);
		this.setMonthSalary(monthsala);
	}
	

	public String toString() {
		return String.format("Fixed salary employee: %s %s\nsocial security number: "
				+ "%s\nmonthly salary: %.2f"
				+ "" ,firstName, lastName, securityNumber, monthSalary);
	}
	
	@Override
	public double earnings() {
		return this.monthSalary;
	}


	public double getMonthSalary() {
		return monthSalary;
	}


	public void setMonthSalary(double monthsala) {
		this.monthSalary = monthsala;
	}
}
