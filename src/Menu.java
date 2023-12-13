import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu {
    

    public static void getMainMenu(ArrayList<FloristShop> floristShops) {
        boolean exit = false;
        String shopName = Input.llegirString("Introduce el nombre de la floristeria: ");
        FloristShop floristShop;


        do {
            try {
                switch (menu()) {
                    case 1:
                        createFloristShop(floristShops);
                        break;

                    case 2: // TODO Ernesto1
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                        	
                            //floristShop.addTree(floristShop.getStock());
                        }
                        break;

                    case 3: // TODO Ernesto1
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addFlower(floristShop.getStock());
                        }
                        break;

                    case 4: // TODO Ernesto1
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addDecoration(floristShop.getStock());
                        }
                        break;

                    case 5: // TODO Ernesto1
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getShopStock(floristShop.getStock());
                        }
                        break;

                    case 6:  // TODO Juanma Sanchez
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                        	Product producto = floristShop.findProduct(floristShop.getStock(),readString("Dime el nombre del arbol que quieres eliminiar"));
                        	if(producto != null) {
                        		floristShop.removeTree(producto);
                        	}else {
                        		System.out.println("Arbol no encontrado en el Stock");
                        	}
                        }
                        break;

                    case 7: // TODO juanma Sanchez
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                        	Product producto = floristShop.findProduct(floristShop.getStock(),readString("Dime el nombre de la flor que quieres eliminiar"));
                        	if(producto != null) {
                        		floristShop.removeFlower(producto);
                        		
                        	}else {
                        		System.out.println("Flor no encontrada en el Stock");
                        	}
                        }
                   
                    
                        break;

                    case 8:  // TODO Juanma Sanchez
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                        	Product producto = floristShop.findProduct(floristShop.getStock(),readString("Dime el nombre del arbol que quieres eliminiar"));
                        	if(producto != null) {
                        		floristShop.removeDecoration(producto);
                        	}else {
                        		System.out.println("Decoracion no encontrada en el Stock");
                        	}
                        } 
                        break;

                    case 9:  // TODO  Juanma Sanchez
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getShopStockWithQuantity();
                        }
                        break;
                    case 10:
                        
                        floristShop = Main.findFlowerShop(floristShops, shopName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                           System.out.println(floristShop.getTotalValue(floristShop.getStock()));
                        }
                        break;
                    case 11:
                        
                        floristShop = Main.findFlowerShop(floristShops, shopName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.createPurchaseTicket(floristShop.getStock());
                        }
                        break;
                    case 12:
                        
                        floristShop = Main.findFlowerShop(floristShops, shopName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getPurchaseTickets(floristShop.getTickets());
                        }
                        break;
                    case 13:
                        
                        floristShop = Main.findFlowerShop(floristShops, shopName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                           System.out.println(floristShop.getSalesProfits(floristShop.getTickets()));
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación.");
                        exit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                Input.llegirString("Error: Ingrese un valor válido (número entero): ");
            }
        } while (!exit);
    }

    public static byte menu() {
        byte option;

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1.  Crear floristería.");
            System.out.println("2.  Agregar árbol a floristería.");
            System.out.println("3.  Agregar flor a floristería.");
            System.out.println("4.  Agregar decoración a floristería.");
            System.out.println("5.  Ver stock de floristería.");
            System.out.println("6.  Retirar árbol de floristería.");
            System.out.println("7.  Retirar flor de floristería.");
            System.out.println("8.  Retirar decoración de floristería.");
            System.out.println("9.  Ver stock de floristería con cantidades.");
            System.out.println("10. Ver valor total de la floristería.");
            System.out.println("11. Crear ticket de compra .");
            System.out.println("12. Mostrar compras antiguas.");
            System.out.println("13. Ver ganacias de floristería.");
            System.out.println("0. Salir de la aplicación.\n");

            try {
                option = Input.llegirByte("Introduce una opcion (1-13): ");
                Input.input();
                if (option < 0 || option > 13) {
                    System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                throw e;
            }
        } while (option < 0 || option > 13);

        return option;
    }

    public static void createFloristShop(ArrayList<FloristShop> floristShops) {
        String inputName = Input.llegirString("Introduce el nombre de la florister�a: ");
        FloristShop floristShop = Main.findFlowerShop(floristShops, inputName);
        if(floristShop == null){
            floristShop = new FloristShop(inputName);
            System.out.println("Creada nueva floristería:");
            floristShops.add(floristShop);
        } else{
            System.out.println("Ya existe una floristería con ese nombre.");
        }
        System.out.println(floristShop);
    }
    
public static String readString(String message) {
		
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		String command = input.nextLine();
		
		return command;
		
	}

    public static byte selectMaterialMenu() {
        byte option;

        do {
            System.out.println("Selecciona el material de la decoración:");
            System.out.println("1. Madera.");
            System.out.println("2. Plástico.");

            try {
                option = sc.nextByte();
                sc.nextLine();
                if (option < 1 || option > 2) {
                    System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                throw e;
            }
        } while (option < 1 || option > 2);

        return option;
    }

}
