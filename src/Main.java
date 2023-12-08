import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       ArrayList<FloristShop> floristShops = new ArrayList<>();


        //Pruebas instancia objetos
        FloristShop floristShop = new FloristShop("F");
        //System.out.println(floristShop);
        floristShops.add(floristShop);// agregado a la lista de floristerias

        Tree tree = new Tree("Tree", 10.0, 3.0);
        System.out.println(tree);
        
       System.out.println(floristShop.toString());
        floristShop.addTree(tree);
        System.out.println(floristShop.toString());        
        
        /*Ticket ticket = new Ticket(floristShop);
        System.out.println(ticket);
        
        Product product = new Product("Product", 50.0);
        System.out.println(product);
        
        
        
     
       
        
        Flower flower = new Flower("Flower", 10.5, "Red");
        System.out.println(flower);
        
        Decoration decoration = new Decoration("Decoraion", 5.5, "Wood");
        System.out.println(decoration);
*/
    
        Menu.getMainMenu(floristShops);
        System.out.println(floristShop.toString());

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