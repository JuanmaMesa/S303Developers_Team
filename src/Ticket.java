import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable {
    private static int lastId = 0;
    private int id;
    private ArrayList<Product> products;
    private double totalPrice = 0;

    public Ticket() {
        this.id = ++lastId;
        this.products = new ArrayList<Product>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice){this.totalPrice = totalPrice;}




    public void addProduct(Product p) {
        // TODO añadir productos a ticket
        this.products.add(p);
    }

    public void calculateFinalPrice() {
        // TODO calcula precio ticket
        this.totalPrice = this.products.stream().mapToDouble(Product::getPrice).sum();

    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
