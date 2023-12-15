import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

    public void saveData(FloristShop floristShop, String nameFile) throws IOException {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(nameFile));

            // guardar info
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
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

}
