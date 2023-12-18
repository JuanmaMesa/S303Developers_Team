import java.io.*;

public class FileSer {

    /*Pokemon pkmn = new Pokemon("Growlithe", 58);

		try {
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("pkmn.ser"));

        file.writeObject(pkmn);
        file.close();

        ObjectInputStream fileRecover = new ObjectInputStream (new FileInputStream("pkmn.ser"));
        Pokemon pkmnRecover = (Pokemon) fileRecover.readObject();
        fileRecover.close();

        System.out.println(pkmnRecover);


    }catch(Exception e) {

    }*/

    public void serializeFile(String nameFile, FloristShop fh){

        String name = "Data2/" + nameFile + ".txt";
        File f = new File(name);


        try {

            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(f.getAbsoluteFile(), true));

            file.writeObject(fh);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void deserializeFile(String nameFile){
        FloristShop fh;
        String name = "Data2/" + nameFile + ".txt";
        //File f = new File(name);
        try {
            ObjectInputStream fileRecover = new ObjectInputStream(new FileInputStream(name));
            try {
                fh = (FloristShop) fileRecover.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(fh);
            fileRecover.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
