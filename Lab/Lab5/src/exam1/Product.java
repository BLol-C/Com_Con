package exam1;

public class Product {
	private String name,code;
	private int price;
	
	public Product(String name,String code,int price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
}
