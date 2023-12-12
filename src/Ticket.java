import java.util.ArrayList;

public class Ticket {
    private static int lastId = 0;
    private int id;
    private ArrayList<Product> products;
    private double totalPrice = 0;

    public Ticket() {
        this.id = ++lastId;
        this.products = new ArrayList<Product>();
    }
    
    public Ticket(int id, ArrayList<Product> products, double totalPrice) {
    	this.id = id;
    	this.products = products;
    	this.totalPrice = totalPrice;
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


    public void addProduct(Product p){
        // TODO añadir productos a ticket
    	this.products.add(p);
    }

    public void calculateFinalPrice(){
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
