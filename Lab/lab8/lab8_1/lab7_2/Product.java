package lab8.lab8_1.lab7_2;

public class Product {
    protected String name;
    protected double price;
    protected int productAmount = 0;
    protected double weight;
    protected boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Product() {
        this("", 0);
    }

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
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

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean equals(Object product) {
        if (this == product)
            return true;
        if (product == null || !(product instanceof Product))
            return false;
        Product p = (Product) product;
        return this.getClass().getSimpleName() == p.getClass().getSimpleName();
    }
}
