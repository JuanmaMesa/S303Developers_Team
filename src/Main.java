import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Data data = new Data();


        //data.loadProducts();
        //data.loadShop();

        ArrayList<String> floristShops = nameFileTxt();
        floristShops.forEach( n -> System.out.println(n));


        Menu.getMainMenu(floristShops);

    }

    public static String findFlowerShopString(ArrayList<String> floristShops, String inputName) {
        int i = 0;
        String floristShop = null;
        while (floristShop == null && i < floristShops.size()) {
            if (floristShops.get(i).equalsIgnoreCase(inputName)) {
                floristShop = floristShops.get(i);
            }
            i++;
        }
        return floristShop;
    }


    public static FloristShop findFlowerShop(ArrayList<FloristShop> floristShops, String inputName) {
        int i = 0;
        FloristShop floristShop = null;
        while (floristShop == null && i < floristShops.size()) {
            if (floristShops.get(i).getName().equalsIgnoreCase(inputName)) {
                floristShop = floristShops.get(i);
            }
            i++;
        }
        return floristShop;
    }

    public static String nameFloristShop() {
        String shopName = Input.readString("Introduce el nombre de la floristeria: ");

        return shopName;
    }


    public static ArrayList<String> nameFileTxt() {

        // Ruta al directorio que contiene los archivos
        ArrayList<String> stringFiles = new ArrayList<>();
        File folder = new File("Data");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                String name = file.getName();
                if(name.endsWith(".txt")){
                    stringFiles.add(name.replace(".txt",""));
                }
            }
        } else {
            return null;
        }
        return stringFiles;

    }
}


