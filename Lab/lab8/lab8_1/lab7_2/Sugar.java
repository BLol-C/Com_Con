package lab8.lab8_1.lab7_2;

public class Sugar extends Product{
	
	public Sugar(double price) {
		super("Sugar", price);
	}
	
	public String toString() {
		return getName() + " " + String.format("%.0f", super.getWeight())+ " Gram\t";
	}

}
