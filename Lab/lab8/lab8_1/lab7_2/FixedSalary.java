package lab8.lab8_1.lab7_2;

import lab8.lab8_1.lab7_2.SavingsAccount.*;

public class FixedSalary extends Employees {
	protected double salary = 0;
	private SavingsAccount acc;
	private DebitCard card;

	public FixedSalary(String firstName, String lastName, String securityNumber, double salary) {
		super(firstName, lastName, securityNumber);
		setSalary(salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double earnings() {
		return getSalary();
	}

	@Override
	public String toString() {
		return "Fixed salary employee: " + super.toString() + "\nmonthly salary: $"
				+ String.format("%.2f", getSalary());
	}

	public void setAcc(SavingsAccount savingsAccount) {
		this.acc = savingsAccount;
	}

	public DebitCard getCard() {
		return card;
	}

	public void setCard(DebitCard card) {
		this.card = card;
	}
}
