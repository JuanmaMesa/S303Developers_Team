import java.util.ArrayList;

public class FloristShop {
	
    private String name;
    ArrayList<Product> stock;
    ArrayList<Ticket> tickets;

    public FloristShop(String name) {
        this.name = name;
        this.stock = new ArrayList<Product>();
        this.tickets = new ArrayList<Ticket>();
    }
    
    public FloristShop(String name, ArrayList<Product> stock, ArrayList<Ticket> tickets) {
    	this.name = name;
    	this.stock = stock;
    	this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getStock() {
        return stock;
    }


    public ArrayList<Ticket> getTickets() {
        return tickets;
    }


    public static Product findProduct(ArrayList<Product> stock){
        //TODO buscar producto en stock
        return null;
    }

    public void addTicket(Ticket ticket){
        //TODO añadir ticket a array
    }

    public void addTree(ArrayList<Product> stock){
        //TODO añadir arbol a array
        System.out.println("addTree()");
    }

    public void addFlower(ArrayList<Product> stock){
        //TODO añadir flor a array
        System.out.println("addFlower()");
    }

    public void addDecoration(ArrayList<Product> stock){
        //TODO añadir decoración a array
        System.out.println("addDecoration()");
    }

    public void getShopStock(ArrayList<Product> stock){
        //TODO print stock
        System.out.println("getShopStock()");
    }

    public void removeTree(ArrayList<Product> stock){
        //TODO quitar arbol de array
        System.out.println("removeTree()");
    }

    public void removeFlower(ArrayList<Product> stock){
        //TODO quitar flor de array
        System.out.println("removeFlower()");
    }

    public void removeDecoration(ArrayList<Product> stock) {
        //TODO quitar decoración de array
        System.out.println("removeDecoration()");
    }

    public void getShopStockWithQuantity(ArrayList<Product> stock){
        //TODO print stock con cantidad
        System.out.println("getShopStockWithQuantity()");
    }

    public double getTotalValue(ArrayList<Product> stock){
        //TODO valor total stock
    	double totalValue = stock.stream().mapToDouble(Product::getPrice).sum();
    	
        return totalValue;
    }

    public void createPurchaseTicket(ArrayList<Product> stock){
        //TODO crear nuevo ticket
    	byte option= -1;
    	String yesNo = "";
    	boolean endPurchase = false;
    	Ticket ticket = new Ticket();
    	do {
    		System.out.println("Productos en stock: ");
        	for (int i=1; i<=stock.size(); i++) {
        		System.out.println(i+". "+stock.get(i-1).getName());
        	}
        	do {	
        		option = Input.llegirByte("Qué objeto quieres comprar?: ");
        		if (option < 1 || option>stock.size()) {
        			System.out.println("Opcion no valida\n");
        		}
        	}while (option < 1 || option>stock.size());
        	
        	ticket.addProduct(stock.get(option-1));
        	System.out.println("Producto anyadido\n");
    		do {
    			yesNo = Input.llegirString("Quieres seguir comprando? (S/N): ");
        	}while(!yesNo.equalsIgnoreCase("s") && !yesNo.equalsIgnoreCase("n"));

        	if (yesNo.equalsIgnoreCase("n")) {
        		endPurchase = true;
        	}
	
    	}while (endPurchase == false);
    	ticket.calculateFinalPrice();
    	this.tickets.add(ticket);

    }

    public void getPurchaseTickets(ArrayList<Ticket> tickets){
        //TODO mostar lista tickets antiguos
    	
    	for (Ticket t: tickets) {
    		System.out.println("Ticket ID: "+t.getId()+" tiene los siguientes productos: ");
    		t.getProducts().forEach((p) -> System.out.println("- "+p.getName()));
    		System.out.println("Precio Total de la compra: " + t.getTotalPrice()+ " €\n");
    	}
       
    }

    public double getSalesProfits(ArrayList<Ticket> tickets){
        //TODO ver ganancias tickets
    	double totalEarns = tickets.stream().mapToDouble(Ticket::getTotalPrice).sum();
    	
        return totalEarns;
    }

    @Override
    public String toString() {
        return "FloristShop{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", tickets=" + tickets +
                '}';
    }
}
