import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.management.ObjectInstance;

public class FloristShop {
    private String name;
    ArrayList<Product> stock;
    ArrayList<Ticket> tickets;

    public FloristShop(String name) {
        this.name = name;
        this.stock = new ArrayList<Product>();;
        this.tickets = new ArrayList<Ticket>();
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

    public void setStock(ArrayList<Product> stock) {
        this.stock = stock;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public  Product findProduct(ArrayList<Product> stock, String name){
        return stock.stream()
        	.filter(n -> n.getName().equalsIgnoreCase(name))
        	.findFirst()
        	.orElse(null);
      
    }

    public void addTicket(Ticket ticket){
        //TODO añadir ticket a array
    }

    public void addTree(Product producto){
        stock.add(producto);
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

    public void removeTree(Product producto){
    	if(producto instanceof Tree) {
    		stock.remove(producto);
    		System.out.println(producto.getName()+" ha sido eliminado Correctamente");
    	}else {
    		System.out.println("El producto asignado no es un arbol");
    	}
    }

    public void removeFlower(Product producto){
        if(producto instanceof Flower) {
        	stock.remove(producto);
        	System.out.println(producto.getName()+" ha sido eliminado Correctamente");
        }else {
        	System.out.println("El producto asignado no es una flor");
        	
        }
       
    }

    public void removeDecoration(Product producto) {
    	if(producto instanceof Decoration) {
    		stock.remove(producto);
    		System.out.println(producto.getName()+" ha sido eliminado Correctamente");
    	}else {
    		System.out.println("El producto asignado no es una decoracion");
    	}
    }
    

    public void getShopStockWithQuantity(){
    	int indiceTree = 0;
    	int indiceFlower = 0;
    	int indiceDecoration = 0;
    	
    	for(Product p : stock) {
    		if(p instanceof Tree) {
    			indiceTree++;
    			
    		}if(p instanceof Flower) {
        			
        			indiceFlower++;
    		
    		}if(p instanceof Decoration) {
        	
        			indiceDecoration++;
        			
    		}
    	}
    	
    	System.out.println("--- STOCK --- ");
    	System.out.println("--- Total arboles --- \n "+ indiceTree);
    	System.out.println("--- Total flores --- \n "+ indiceFlower);
    	System.out.println("--- Total decorados --- \n "+ indiceDecoration);
    	
   
    	
    	
		
    }

    public void getTotalValue(ArrayList<Product> stock){
        //TODO valor total stock
        System.out.println("getTotalValue()");
    }

    public void createPurchaseTicket(ArrayList<Ticket> tickets){
        //TODO crear nuevo ticket
        System.out.println("createPurchaseTicket()");
    }

    public void getPurchaseTickets(ArrayList<Ticket> tickets){
        //TODO mostar lista tickets antiguos
        System.out.println("getPurchaseTickets()");
    }

    public void getSalesProfits(ArrayList<Ticket> tickets){
        //TODO ver ganancias tickets
        System.out.println("getSalesProfits()");
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
