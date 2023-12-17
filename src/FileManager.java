import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public void saveData(FloristShop floristShop, String nameFile) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(nameFile))){

            // guardar informacion en el archivo
            for (Product product : floristShop.getStock()) {
                if (product instanceof Tree) {
                    printWriter.println((product.toString()));
                } else if (product instanceof Flower) {
                    printWriter.println(( product.toString()));
                } else if (product instanceof Decoration) {
                    printWriter.println((product.toString()));
                }

            }
            for(Ticket ticket : floristShop.getTickets()){
                printWriter.println(ticket.toString());
            }


        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }

    public FloristShop loadData(String nameFile) throws IOException{
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        //FloristShop floristShop;
        FloristShop floristShop = new FloristShop("Rosas del bosque",products, tickets);

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Imprime cada línea para verificar la lectura
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*try(BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
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
                }else if  (parts[0].equalsIgnoreCase("Ticket")){
                    Ticket ticket = parseTicket(parts);
                    tickets.add(ticket);
                }
            }
        }*/
        //floristShop = new FloristShop(nameFile,products,tickets);
        return floristShop;

    }

    private Tree parseTree(String[] parts){
        String name = parts[2].split(":")[1].trim().replace("\"", "");
        double price = Double.parseDouble(parts[3].split(":")[1].trim());
        double height = Double.parseDouble(parts[4].split(":")[1].trim().replace("}", ""));
        // Suponiendo que el constructor de Tree toma estos tres parámetros
        return new Tree(name, price, height);

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

    private Ticket parseTicket(String [] parts){
        Ticket ticket = new Ticket();
        List<Product> products = new ArrayList<>();

        // Extraer la lista de productos del ticket
        String productList = parts[2].substring(parts[2].indexOf('[')+1, parts[2].lastIndexOf(']'));
        String[] productParts = productList.split("\\},");

        for(String productStr : productParts){
            productStr = productStr.trim();
            if(!productStr.endsWith("}")){
                productStr += "}";
            }
            String [] productData = productStr.split(",");

            if(productData[0].equals("Tree")){
                Tree tree = parseTree(productData);
                products.add(tree);
            } else if (productData[0].equals("Flower")) {
                Flower flower = parseFlower(productData);
                products.add(flower);
            } else if(productData[0].equals("Decoration")){
                Decoration decoration = parseDecoration(productData);
                products.add(decoration);
            }

        }

        // añadir productos al ticket
        for(Product product : products){
            ticket.addProduct(product);
        }

        // Establecer precio total del ticket
        double totalPrice = Double.parseDouble(parts[3].split(":")[1].trim());
        ticket.setTotalPrice(totalPrice);

        return ticket;
    }



}