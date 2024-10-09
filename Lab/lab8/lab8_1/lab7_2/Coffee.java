package lab8.lab8_1.lab7_2;

public class Coffee extends Product {

	public Coffee(double price) {
		super("Coffee", price);
		setProductAmount(getProductAmount() + 1);
	}

	public String toString() {
		return getName() + " " + String.format("%.0f", super.getWeight()) + " Gram\t";

	}

}
