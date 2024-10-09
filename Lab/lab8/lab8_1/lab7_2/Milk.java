package lab8.lab8_1.lab7_2;

public class Milk extends Product {
	protected double volumn;
	
	public double getVolumn() {
		return volumn;
	}

	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}

	public Milk(double price) {
		super("Milk", price);
	}

	@Override
	public String toString() {
		return getName() + " " + String.format("%.0f",getVolumn()) + " CC\t\t";
	}
	

}
