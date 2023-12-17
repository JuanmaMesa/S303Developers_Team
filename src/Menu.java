import java.io.IOException;
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

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.addTree(floristShop.getStock());
                            WriterToTxt(floristShop, shopName);
                        }
                        break;

                    case 3:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.addFlower(floristShop.getStock());
                            WriterToTxt(floristShop, shopName);
                        }
                        break;

                    case 4:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.addDecoration(floristShop.getStock());
                            WriterToTxt(floristShop, shopName);
                        }
                        break;

                    case 5:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop = LoadFile(shopName);
                            if (floristShop != null) {
                                floristShop.getShopStock(floristShop.getStock());
                            } else {
                                System.out.println("Error al cargar los datos");
                            }
                        }
                        break;

                    case 6:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

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
                                            WriterToTxt(floristShop, shopName);
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
                        floristShop = Main.findFlowerShop(floristShops, shopName);

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
                                            WriterToTxt(floristShop, shopName);
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
                        floristShop = Main.findFlowerShop(floristShops, shopName);

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
                                            WriterToTxt(floristShop, shopName);
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
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.getShopStockWithQuantity();
                        }
                        break;
                    case 10:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            System.out.println("Valor Total del stock: " + floristShop.getTotalValue(floristShop.getStock()) + " €");
                        }
                        break;
                    case 11:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.createPurchaseTicket(floristShop.getStock());
                        }
                        break;
                    case 12:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            floristShop.getPurchaseTickets(floristShop.getTickets());
                        }
                        break;
                    case 13:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            System.out.println("Suma total de ventas: " + floristShop.getSalesProfits(floristShop.getTickets()) + " €");
                        }
                        break;
                    case 14:
                        shopName = Main.nameFloristShop();
                        floristShop = Main.findFlowerShop(floristShops, shopName);

                        if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            WriterToTxt(floristShop, shopName);

                        }
                        break;
                    case 15:
                        FileManager fileManager = new FileManager();
                        try {
                            FloristShop shop = fileManager.loadData("Data/Rosas del bosque.txt");

                            System.out.println(shop);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                        //shopName = Main.nameFloristShop();
                        //FloristShop floristShop1 = LoadFile(shopName);
                        //System.out.println(floristShop1.toString());
                        //floristShop = Main.findFlowerShop(floristShops, shopName);

                       /*if (floristShop == null) {
                            System.out.println("Floristería no encontrada.");
                        } else {
                            LoadFile(shopName);
                        }*/
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
            System.out.println("14. Actualizar Stock de la floristería.");
            System.out.println("15. cargar Stock de la floristería.");
            System.out.println("0.  Salir de la aplicación.\n");

            try {
                option = Input.readByte("Introduce una opcion: ");
                Input.input();
                if (option < 0 || option > 15) {
                    System.out.println("Opción no válida");
                }
                numCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Opcion no valida");
            }

        } while (option < 0 || option > 15);

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

    public static void WriterToTxt(FloristShop floristShop, String shopName) {
        FileManager fileManager = new FileManager();
        String name = "Data/" + shopName + ".txt";
        try {
            fileManager.saveData(floristShop, name);
            System.out.println("Stock guardado correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar el stock: " + e.getMessage());
        }

    }

    public static FloristShop LoadFile(String shopName) {
        FileManager fileManager = new FileManager();
        String name = "Data/" + shopName + ".txt";
        FloristShop floristShop = null;
        try {
            floristShop = fileManager.loadData(name);
            System.out.println("cargado corectamente");

        } catch (IOException e) {
            System.out.println("Error de lectura ");

        }
        return floristShop;
    }


}
