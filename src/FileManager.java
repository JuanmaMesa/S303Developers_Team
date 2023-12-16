import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public void saveData(FloristShop floristShop, String nameFile) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(nameFile))){

            // guardar informacion en el archivo
            for (Product product : floristShop.getStock()) {
                if (product instanceof Tree) {
                    printWriter.println(("TREE," + product.toString()));
                } else if (product instanceof Flower) {
                    printWriter.println(("FLOWER," + product.toString()));
                } else if (product instanceof Decoration) {
                    printWriter.println(("DECORATION," + product.toString()));
                }

            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

    public FloristShop loadData(String nameFile) throws IOException{

        List<Product> products = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String line;
            while((line = br.readLine()) !=null){
                String[] parts = line.split(",");
                if(parts[0].equals("Tree")){
                    Tree tree = parseTree(parts);
                    products.add(tree);
                } else if (parts[0].equalsIgnoreCase("Flower")) {
                    Flower flower = parseFlower(parts);
                    products.add(flower);
                } else if (parts[0].equalsIgnoreCase("Decoration")) {
                    Decoration decoration = parseDecoration(parts);
                    products.add(decoration);
                }
            }
        }




    }

    private Tree parseTree(String[] parts){
        int id = Integer.parseInt(parts[1].split(":")[1].trim());
        String name = parts[2].split(":")[1].trim();
        double price = Double.parseDouble(parts[3].split(":")[1].trim());
        double height = Double.parseDouble((parts[4]).split(":")[1].trim());

        return new Tree(name,price,height);

    }

    private Flower parseFlower(String[] parts){
        int id = Integer.parseInt(parts[1].split(":")[1].trim());
        String name = parts[2].split(":")[1].trim();
        double price = Double.parseDouble(parts[3].split(":")[1].trim());
        String  colour = parts[4].split(":")[1].trim();

        return new Flower(name,price,colour);

    }

    private Decoration parseDecoration(String[] parts){
        int id = Integer.parseInt(parts[1].split(":")[1].trim());
        String name = parts[2].split(":")[1].trim();
        double price = Double.parseDouble(parts[3].split(":")[1].trim());
        String material = parts[4].split(":")[1].trim();

        return new Decoration(name,price,material);

    }






}