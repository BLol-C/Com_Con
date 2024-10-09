package lab8.lab8_1.lab7_2;
public class InventoryCart {
    private Product cart[];
    

    public InventoryCart(int size) {
        cart = new Product[size];
    }

    public void add(Product product) {
        for (int i = 0; i < cart.length; i++) {
        	if(cart[i] == null) {
        		cart[i] = product;
        		cart[i].setProductAmount(cart[i].getProductAmount() + 1);
        		break;
        	}	
        }
    }

    public Product getProductAt(int index) {
        return cart[index];
    }

    public Product[] getAllProduct() {
       return cart;
    }
    
    
}