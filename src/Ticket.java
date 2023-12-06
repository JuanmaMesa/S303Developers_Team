import java.util.ArrayList;

public class Ticket {
    private static int lastId = 0;
    private int id;
    private FloristShop floristShop;
    private ArrayList<Product> products;
    private double totalPrice = 0;

    public Ticket(FloristShop floristShop) {
        this.id = ++lastId;
        this.floristShop = floristShop;
        this.products = new ArrayList<Product>();
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Ticket.lastId = lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FloristShop getFloristShop() {
        return floristShop;
    }

    public void setFloristShop(FloristShop floristShop) {
        this.floristShop = floristShop;
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

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static void addProduct(){
        // TODO añadir productos a ticket
    }

    public static void calculateFinalPrice(){
        // TODO añadir productos a ticket
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", floristShop=" + floristShop.getName() +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
