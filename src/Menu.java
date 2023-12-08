import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void getMainMenu(ArrayList<FloristShop> floristShops) {
        boolean exit = false;
        String inputName;
        FloristShop floristShop;

        do {
            try {
                switch (menu()) {
                    case 1:
                        createFloristShop(floristShops);
                        break;
                    case 2:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                        	
                            floristShop.addTree(floristShop.getStock());
                        }
                        break;
                    case 3:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addFlower(floristShop.getStock());
                        }
                        break;
                    case 4:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addDecoration(floristShop.getStock());
                        }
                        break;
                    case 5:
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
                        	Product producto = floristShop.findProduct(floristShop.getStock(), "Tree");
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
                            floristShop.removeFlower(floristShop.getStock());
                        }
                        break;
                    case 8:  // TODO Juanma Sanchez
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.removeDecoration(floristShop.getStock());
                        }
                        break;
                    case 9:  // TODO  Juanma Sanchez
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getShopStockWithQuantity(floristShop.getStock());
                        }
                        break;
                    case 10:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getTotalValue(floristShop.getStock());
                        }
                        break;
                    case 11:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.createPurchaseTicket(floristShop.getTickets());
                        }
                        break;
                    case 12:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getPurchaseTickets(floristShop.getTickets());
                        }
                        break;
                    case 13:
                        inputName = Main.nameFlowerShop();
                        floristShop = Main.findFlowerShop(floristShops, inputName);
                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getSalesProfits(floristShop.getTickets());
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación.");
                        exit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor válido (número entero).");
                sc.nextLine();
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
                option = sc.nextByte();
                sc.nextLine();
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
        String inputName = Main.nameFlowerShop();
        FloristShop floristShop = Main.findFlowerShop(floristShops, inputName);
        if(floristShop == null){
            floristShop = new FloristShop(inputName);
            System.out.println("Creada nueva floristería:");
        } else{
            System.out.println("Ya existe una floristería con ese nombre.");
        }
        System.out.println(floristShop);
    }

}
