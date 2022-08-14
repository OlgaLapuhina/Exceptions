public class Product {
    private final int price;
    private final String name;
    private int count = 0;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void addCount(int count) {
        this.count = this.count + count;
    }

    public int getCount() {
        return count;
    }
}
