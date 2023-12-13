import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       ArrayList<FloristShop> floristShops = new ArrayList<>();


        //Pruebas instancia objetos
        FloristShop floristShop = new FloristShop("Floristeria");
        System.out.println(floristShop);
        floristShops.add(floristShop);
        Ticket ticket = new Ticket(floristShop);
        System.out.println(ticket);
        Product product = new Product("Product", 50.0);
        System.out.println(product);
        Tree tree = new Tree("Tree", 10.0, 3.0);
        System.out.println(tree);
        Flower flower = new Flower("Flower", 10.5, "Red");
        System.out.println(flower);
        Decoration decoration = new Decoration("Decoraion", 5.5, "Wood");
        System.out.println(decoration);
        floristShop.getStock().add(tree);
        floristShop.getStock().add(flower);
        floristShop.getStock().add(decoration);

        Menu.getMainMenu(floristShops);

    }

    public static FloristShop findFlowerShop(ArrayList<FloristShop> floristShops,String inputName) {
        int i = 0;
        FloristShop floristShop = null;
        while (floristShop == null && i<floristShops.size()){
            if (floristShops.get(i).getName().equalsIgnoreCase(inputName)){
                floristShop = floristShops.get(i);
            }
            i++;
        }
        return floristShop;
    }

    public static String nameFlowerShop (){
        System.out.println("Introduce el nombre de la floristeria:");
        String inputName = sc.nextLine();
        return inputName;
    }

}