import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu {
    

    public static void getMainMenu(ArrayList<FloristShop> floristShops) {
        boolean exit = false;
        FloristShop floristShop;
        String shopName = "";

        do {
            try {
                switch (menu()) {
                    case 1:
                        createFloristShop(floristShops);
                        break;

                    case 2:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addTree(floristShop.getStock());
                        }
                        break;

                    case 3:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addFlower(floristShop.getStock());
                        }
                        break;

                    case 4:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.addDecoration(floristShop.getStock());
                        }
                        break;

                    case 5:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getShopStock(floristShop.getStock());
                        }
                        break;

                    case 6:  // TODO Juanma Sanchez // Listar stock antes de remove
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            String nameProduct = Input.readString("Dime el nombre del arbol que quieres eliminiar: ");
                        	Product producto = floristShop.findProduct(floristShop.getStock(), nameProduct);
                        	if(producto != null) {
                        		floristShop.removeTree(producto);
                        	}else {
                        		System.out.println("Arbol no encontrado en el Stock");
                        	}
                        }
                        break;

                    case 7: // TODO juanma Sanchez // Listar stock antes de remove
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            String nameProduct = Input.readString("Dime el nombre de la flor que quieres eliminiar: ");
                            Product producto = floristShop.findProduct(floristShop.getStock(), nameProduct);
                        	if(producto != null) {
                        		floristShop.removeFlower(producto);
                        		
                        	}else {
                        		System.out.println("Flor no encontrada en el Stock");
                        	}
                        }
                        break;

                    case 8:  // TODO Juanma Sanchez // Listar stock antes de remove
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            String nameProduct = Input.readString("Dime el nombre de la decoración que quieres eliminiar: ");
                            Product producto = floristShop.findProduct(floristShop.getStock(), nameProduct);
                        	if(producto != null) {
                        		floristShop.removeDecoration(producto);
                        	}else {
                        		System.out.println("Decoración no encontrada en el Stock");
                        	}
                        } 
                        break;

                    case 9:  // TODO  Juanma Sanchez
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getShopStockWithQuantity();
                        }
                        break;
                    case 10:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                           System.out.println("Valor Total del stock: "+floristShop.getTotalValue(floristShop.getStock()) + " €");
                        }
                        break;
                    case 11:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.createPurchaseTicket(floristShop.getStock());
                        }
                        break;
                    case 12:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                            floristShop.getPurchaseTickets(floristShop.getTickets());
                        }
                        break;
                    case 13:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if(floristShop == null){
                            System.out.println("Floristería no encontrada.");
                        } else{
                           System.out.println("Suma total de ventas: "+ floristShop.getSalesProfits(floristShop.getTickets()) + " €");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación.");
                        exit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                Input.readString("Error: Ingrese un valor válido: ");
            }
        } while (!exit);
    }

    public static byte menu() {
        byte option =-1;
        boolean numCorrect = false;

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
            System.out.println("11. Crear ticket de compra.");
            System.out.println("12. Mostrar compras antiguas.");
            System.out.println("13. Ver ganacias de floristería.");
            System.out.println("0.  Salir de la aplicación.\n");

                try {
                    option = Input.readByte("Introduce una opcion: ");
                    Input.input();
                    if (option < 0 || option > 13) {
                        System.out.println("Opción no válida");
                    }
                    numCorrect = true;
                } catch (InputMismatchException e) {
                    System.out.println("Opcion no valida");
                }

        } while (option < 0 || option > 13);

        return option;
    }

    public static void createFloristShop(ArrayList<FloristShop> floristShops) {
        String inputName = Input.readString("Introduce el nombre de la floristería: ");
        FloristShop floristShop = Main.findFlowerShop(floristShops, inputName);
        if(floristShop == null){
            floristShop = new FloristShop(inputName);
            System.out.println("Creada nueva floristería:");
            System.out.println(floristShop.getName());
            floristShops.add(floristShop);
        } else{
            System.out.println("Ya existe una floristería con el nombre "+floristShop.getName()+".");
        }
    }

    public static byte selectMaterialMenu() {
        byte option = -1;

        do {
            System.out.println("Selecciona el material de la decoración:");
            System.out.println("1. Madera.");
            System.out.println("2. Plástico.");

            try {
                option = Input.readByte("Escoge una opción: ");
                if (option < 1 || option > 2) {
                    System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion no valida");
            }
        } while (option < 1 || option > 2);

        return option;
    }

}
