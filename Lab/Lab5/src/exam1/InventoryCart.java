package exam1;

public class InventoryCart {
	
	private Product[] products;
	private int index;
	
	public InventoryCart(int index) {
		products = new Product[index];
	}
	
	public void add(Product index) {
		products[this.index++] = index;
	}
	
	public Product getProductAt(int index) {
		return products[index];
	}
	
	public Product[] getAllProduct() {
		return products;
	}
	
	
}
