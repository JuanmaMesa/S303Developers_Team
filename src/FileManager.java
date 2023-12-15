import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

    public void saveData(FloristShop floristShop, String nameFile) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(nameFile))) {

            // guardar informacion en el archivo
            for (Product product : floristShop.getStock()) {
                if (product instanceof Tree) {
                    printWriter.println((product.toString()));
                } else if (product instanceof Flower) {
                    printWriter.println((product.toString()));
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

}
