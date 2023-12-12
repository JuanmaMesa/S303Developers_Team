import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
    	Data data = new Data();
        
        data.loadStocks();
        data.loadTicket();
        data.loadProducts();
        data.loadShop();
        ArrayList<FloristShop> floristShops = data.getFloristerias();

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