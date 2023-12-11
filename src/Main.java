import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
    	Data data = new Data();
        
        data.loadStocks();
        data.loadTicket();
        data.loadProducts();
        data.loadShop();
        ArrayList<FloristShop> floristShops = data.getFloristerias();

       	
        /*Pruebas instancia objetos
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
        System.out.println(decoration);*/
        for (FloristShop f: floristShops) {
        	ArrayList<Product> stocks = f.getStock();
        	stocks.forEach((s) -> System.out.println(s.getName()));
        }
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

}