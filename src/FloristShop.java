import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.management.ObjectInstance;
import java.util.InputMismatchException;
import java.util.Scanner;

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


    public  Product findProduct(ArrayList<Product> stock, String name){
        return stock.stream()
        	.filter(n -> n.getName().equalsIgnoreCase(name))
        	.findFirst()
        	.orElse(null);
      
    }

    public void addTicket(Ticket ticket){
        //TODO añadir ticket a array
        this.tickets.add(ticket);

    }


    public void addTree(ArrayList<Product> stock) {
        String nameTree = Input.llegirString("Introduce el nombre del árbol:");

        double priceTree = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                priceTree = Input.llegirDouble("Introduce el precio del árbol:");
                if (priceTree >= 0) {
                    validPrice = true;
                } else {
                    System.out.println("El precio debe ser mayor o igual a cero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido para el precio.");
            }
        }

        double heightTree = 0.0;
        boolean validHeight = false;
        while (!validHeight) {
            try {
                heightTree = Input.llegirDouble("Introduce la altura del árbol:");
                if (heightTree >= 0) {
                    validHeight = true;
                } else {
                    System.out.println("La altura debe ser mayor o igual a cero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido para la altura.");
            }
        }

        Tree tree = new Tree(nameTree, priceTree, heightTree);
        stock.add(tree);

        System.out.println("Árbol añadido con éxito:\n" + tree);
    }

    public void addFlower(ArrayList<Product> stock){
        String nameFlower = Input.llegirString("Introduce el nombre de la flor:");

        double priceFlower = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                priceFlower = Input.llegirDouble(("Introduce el precio de la flor:"));
                if (priceFlower >= 0) {
                    validPrice = true;
                } else {
                    System.out.println("El precio debe ser mayor o igual a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido para el precio.");
            }
        }

        String colorFlower = Input.llegirString("Introduce el color de la flor:");
        Flower flower = new Flower(nameFlower, priceFlower, colorFlower);
        stock.add(flower);

        System.out.println("Flor añadida con éxito:\n" + flower);
    }

    public void addDecoration(ArrayList<Product> stock){
        String nameDecoration = Input.llegirString("Introduce el nombre de la decoración:");

        double priceDecoration = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                priceDecoration = Input.llegirDouble(("Introduce el precio de la decoración:"));
                if (priceDecoration >= 0) {
                    validPrice = true;
                } else {
                    System.out.println("El precio debe ser mayor o igual a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido para el precio.");
            }
        }

        boolean exit = false;
        //TODO Revisar entrada menu
        do {
            try {
                switch (Menu.selectMaterialMenu()) {
                    case 1:
                        Decoration decoration = new Decoration(nameDecoration, priceDecoration, "Madera");
                        System.out.println("Decoración añadida con éxito:\n" + decoration);
                        stock.add(decoration);
                        exit = true;
                        break;
                    case 2:
                        decoration = new Decoration(nameDecoration, priceDecoration, "Plástico");
                        System.out.println("Decoración añadida con éxito:\n" + decoration);
                        stock.add(decoration);
                        exit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor válido (número entero).");
            }
        } while (!exit);

    }

    public void getShopStock(ArrayList<Product> stock){
        if (stock.isEmpty()){
            System.out.println("No hay stock en la floristería "+name+".");
        } else {
            System.out.println("El stock disponible en la floristería "+name+" es:");
            stock.forEach(product -> System.out.println(product));
        }
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

    public double getTotalValue(ArrayList<Product> stock){
        //TODO valor total stock
    	double totalValue = stock.stream().mapToDouble(Product::getPrice).sum();
        // TODO sysout con totalValue
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
            //TODO Linkar con stock de floristShop
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
        addTicket(ticket);


    }

    public void getPurchaseTickets(ArrayList<Ticket> tickets){
        //TODO Linkar con stock de floristShop
    	
    	for (Ticket t: tickets) {
    		System.out.println("Ticket ID: "+t.getId()+" tiene los siguientes productos: ");
    		t.getProducts().forEach((p) -> System.out.println("- "+p.getName()));
    		System.out.println("Precio Total de la compra: " + t.getTotalPrice()+ " €\n");
    	}
       
    }

    public double getSalesProfits(ArrayList<Ticket> tickets){
    	double totalEarns = tickets.stream().mapToDouble(Ticket::getTotalPrice).sum();
        //TODO sysout totalEarns
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
