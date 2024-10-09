package sourceCode;

public class Item {
	private String name;
	private double price;
	private int quantity;
	
	public Item(String n, double p, int quan) {
		this.setName(n);
		this.setPrice(p);
		this.setQuantity(quan);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Double getAmount() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+"$"+price+"\t"+quantity+"\t"+getAmount()+ "\n";
	}

}
