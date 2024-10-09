package exam1;

public class Cashier {

	private String name;

	public Cashier(String name) {
		this.name = name;
	}

	public void printReceipt(InventoryCart ic) {
		System.out.println(name);
		
		Product[] products = ic.getAllProduct();
		int count[] = new int[products.length];
		System.out.println();
		

	}
}
