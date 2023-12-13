import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.management.ObjectInstance;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FloristShop {
    static Scanner sc = new Scanner(System.in);
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


    public void addTree(ArrayList<Product> stock) {
        System.out.println("Introduce el nombre del árbol:");
        String nameTree = sc.nextLine();

        double priceTree = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                System.out.println("Introduce el precio del árbol:");
                priceTree = Double.parseDouble(sc.nextLine());
                if (priceTree >= 0) {
                    validPrice = true;
                } else {
                    System.out.println("El precio debe ser mayor o igual a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido para el precio.");
            }
        }

        double heightTree = 0.0;
        boolean validHeight = false;
        while (!validHeight) {
            try {
                System.out.println("Introduce la altura del árbol:");
                heightTree = Double.parseDouble(sc.nextLine());
                if (heightTree >= 0) {
                    validHeight = true;
                } else {
                    System.out.println("La altura debe ser mayor o igual a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido para la altura.");
            }
        }

        Tree tree = new Tree(nameTree, priceTree, heightTree);
        stock.add(tree);

        System.out.println("Árbol añadido con éxito:\n" + tree);
    }

    public void addFlower(ArrayList<Product> stock){
        System.out.println("Introduce el nombre de la flor:");
        String nameFlower = sc.nextLine();

        double priceFlower = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                System.out.println("Introduce el precio de la flor:");
                priceFlower = Double.parseDouble(sc.nextLine());
                if (priceFlower >= 0) {
                    validPrice = true;
                } else {
                    System.out.println("El precio debe ser mayor o igual a cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido para el precio.");
            }
        }

        System.out.println("Introduce el color de la flor:");
        String colorFlower = sc.nextLine();
        Flower flower = new Flower(nameFlower, priceFlower, colorFlower);
        stock.add(flower);

        System.out.println("Flor añadida con éxito:\n" + flower);
    }

    public void addDecoration(ArrayList<Product> stock){
        System.out.println("Introduce el nombre de la decoración:");
        String nameDecoration = sc.nextLine();

        double priceDecoration = 0.0;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                System.out.println("Introduce el precio de la decoración:");
                priceDecoration = Double.parseDouble(sc.nextLine());
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
