package exam3;

public class CommissionPay extends Employee {
	
	private double sales;
	private double comrate;

	public CommissionPay(String first, String last, String snn, double sales, double comrate) {
		super(first, last, snn);
		this.setSales(sales);
		this.comrate = comrate;
	}

	@Override
	public double earnings() {
		return sales * comrate;
	}
	
	public String toString() {
		return String.format("\ncommission employee: %s %s\nsocial security number: "
				+ "%s\ngross sales: $ %.2f; commission rate: %.2f"
				+ "" ,firstName, lastName, securityNumber, sales, comrate);
	}
	
	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}
	
	public double getComrate() {
		return this.comrate;
	}

}
