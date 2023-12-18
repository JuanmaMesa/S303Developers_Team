import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu {


    public static void getMainMenu(ArrayList<FloristShop> floristShops)  {
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
                        try {
                            floristShop = loadFloristShop(shopName);
                            if (floristShop != null) {
                                floristShop.addTree(floristShop.getStock());
                                saveFloristShop(floristShop, shopName);
                            } else {
                                System.out.println("Floristeria no encontrada");
                            }

                        }catch (FileNotFoundException e) {
                            System.out.println("archivo no encontrado");
                        } catch( Exception e){
                            System.out.println("Floristería no encontrada.");
                        }
                        break;

                    case 3:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);
                        // floristShop = Main.findFlowerShop(floristShops, shopName);
                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.addFlower(floristShop.getStock());
                            saveFloristShop(floristShop, shopName);
                        }
                        break;

                    case 4:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);
                        // floristShop = Main.findFlowerShop(floristShops, shopName);-> antiguo metodo para cargar datos
                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.addDecoration(floristShop.getStock());
                            saveFloristShop(floristShop, shopName);
                        }
                        break;

                    case 5:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.getShopStock(floristShop.getStock());
                            floristShop.getPurchaseTickets(floristShop.getTickets());

                        }
                        break;

                    case 6:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            long treeCount = floristShop.getStock().stream()
                                    .filter(p -> p instanceof Tree)
                                    .count();
                            if (treeCount == 0) {
                                System.out.println("En estos momentos no hay arboles en el Stock");

                            } else {
                                System.out.println("  --- Stock --- ");
                                floristShop.printInfoStock(Tree.class);
                                System.out.println();//

                                int idProduct = Input.readInt("Dime el Id del arbol que quieres eliminiar: ");
                                Product producto = floristShop.findProduct(floristShop.getStock(), idProduct);

                                if (producto == null) {
                                    System.out.println("Producto no encontrado con el Id: " + idProduct);
                                } else {
                                    boolean continueLoop = false;

                                    do {
                                        System.out.println("Estas a punto de eliminar el arbol: " + producto.getName());
                                        String confirm = Input.readString("¿Estas seguro de eliminarlo? Si/NO ");
                                        if (confirm.equalsIgnoreCase("si")) {
                                            floristShop.removeTree(producto);
                                            saveFloristShop(floristShop, shopName);
                                            continueLoop = true;
                                        } else if (confirm.equalsIgnoreCase("no")) {
                                            System.out.println("Operacion cancelada");
                                            continueLoop = true;
                                        } else {
                                            System.out.println("Opcion no valida");
                                        }

                                    } while (continueLoop == false);
                                }
                            }
                        }
                        break;

                    case 7:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            long flowerCount = floristShop.getStock().stream()
                                    .filter(p -> p instanceof Flower)
                                    .count();
                            if (flowerCount == 0) {
                                System.out.println("En estos momentos no hay Flores en el Stock");

                            } else {
                                System.out.println("  --- Stock --- ");
                                floristShop.printInfoStock(Flower.class);
                                System.out.println();//
                                int idProduct = Input.readInt("Dime el Id de la Flor que quieres eliminiar: ");
                                Product producto = floristShop.findProduct(floristShop.getStock(), idProduct);

                                if (producto == null) {
                                    System.out.println("Producto no encontrado con el Id: " + idProduct);
                                } else {
                                    boolean continueLoop = false;

                                    do {
                                        System.out.println("Estas a punto de eliminar la flor: " + producto.getName());
                                        String confirm = Input.readString("¿Estas seguro de eliminarlo? Si/NO ");
                                        if (confirm.equalsIgnoreCase("si")) {
                                            floristShop.removeFlower(producto);
                                            saveFloristShop(floristShop, shopName);
                                            continueLoop = true;
                                        } else if (confirm.equalsIgnoreCase("no")) {
                                            System.out.println("Operacion cancelada");
                                            continueLoop = true;
                                        } else {
                                            System.out.println("Opcion no valida");

                                        }
                                    } while (continueLoop == false);
                                }
                            }
                        }
                        break;

                    case 8:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            long decorationCount = floristShop.getStock().stream()
                                    .filter(p -> p instanceof Decoration)
                                    .count();
                            if (decorationCount == 0) {
                                System.out.println("En estos momentos no hay decoracion en el Stock");

                            } else {
                                System.out.println("  --- Stock --- ");
                                floristShop.printInfoStock(Decoration.class);
                                System.out.println();//
                                int idProduct = Input.readInt("Dime el Id de la decoracion que quieres eliminiar: ");
                                Product producto = floristShop.findProduct(floristShop.getStock(), idProduct);

                                if (producto == null) {
                                    System.out.println("Producto no encontrado con el Id: " + idProduct);

                                } else {
                                    boolean continueLoop = false;

                                    do {
                                        System.out.println("Estas a punto de eliminar la decoracion: " + producto.getName());
                                        String confirm = Input.readString("¿Estas seguro de eliminarlo? Si/NO ");
                                        if (confirm.equalsIgnoreCase("si")) {
                                            floristShop.removeDecoration(producto);
                                            saveFloristShop(floristShop, shopName);
                                            continueLoop = true;
                                        } else if (confirm.equalsIgnoreCase("no")) {
                                            System.out.println("Operacion cancelada");
                                            continueLoop = true;
                                        } else {
                                            System.out.println("Opcion no valida");

                                        }
                                    } while (continueLoop == false);
                                }
                            }
                        }
                        break;

                    case 9:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.getShopStockWithQuantity();
                        }
                        break;
                    case 10:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            System.out.println("Valor Total del stock: " + floristShop.getTotalValue(floristShop.getStock()) + " €");
                        }
                        break;
                    case 11:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);
                        //floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.createPurchaseTicket(floristShop.getStock());
                            saveFloristShop(floristShop,shopName);
                        }
                        break;
                    case 12:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.getPurchaseTickets(floristShop.getTickets());
                        }
                        break;
                    case 13:
                        shopName = Main.nameFloristShop();
                        floristShop = loadFloristShop(shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            System.out.println("Suma total de ventas: " + floristShop.getSalesProfits(floristShop.getTickets()) + " €");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación.");
                        exit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                Input.readString("Error: Ingrese un valor válido: ");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } while (!exit);
    }

    public static byte menu() {
        byte option = -1;
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
        if (floristShop == null) {
            floristShop = new FloristShop(inputName);
            System.out.println("Creada nueva floristería:");
            System.out.println(floristShop.getName());
            floristShops.add(floristShop);
        } else {
            System.out.println("Ya existe una floristería con el nombre " + floristShop.getName() + ".");
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


    // Método para cargar una floristería desde un archivo
    public static FloristShop loadFloristShop(String shopName) throws FileNotFoundException {
        String filepath = "Data/" + shopName + ".txt";
        FileManager fileManager = new FileManager(filepath, false);
        return (FloristShop) fileManager.desSerializeObject(filepath);


    }

    // Método para guardar una floristería en un archivo
    public static void saveFloristShop(FloristShop floristShop, String shopName) {
        String filepath = "Data/" + shopName + ".txt";
        FileManager fileManager = new FileManager(filepath, false);
        fileManager.serializeObject(floristShop, filepath);
        System.out.println("Floristería " + shopName + " guardada correctamente.");
    }

}

