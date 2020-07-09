package uni.mapadventureproject.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import uni.mapadventureproject.Game;
import uni.mapadventureproject.type.*;

/**
 * Classe utilizzata per caricare e salvare su file lo stato del gioco.
 */
public class FileSaver {

    /**
     * Salva in un file binario le entità che compongono il gioco
     * 
     * @param path path del file in cui salvare i dati
     * @param g gioco da salvare
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveFile(String path, Game g) throws FileNotFoundException, IOException {

        // Crea l'output stream per salvare gli oggetti
        FileOutputStream fOut = new FileOutputStream(path);
        ObjectOutputStream objOut = new ObjectOutputStream(fOut);

        objOut.writeObject(g.getCommands());

        objOut.writeObject(g.getInventory());

        objOut.writeObject(g.getCurrentRoom());

        objOut.writeUTF(g.getPlayer());

        objOut.writeInt(g.getGameTime().getSecondPassed());

        objOut.close();
        fOut.close();

    }

    /**
     * Carica da file le entità del gioco.
     * 
     * @param path del file binario da cui caricare
     * @param g gioco in cui caricare i dati
     * 
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void readFile(String path, Game g) throws IOException, ClassNotFoundException {
        
        // Crea l'input stream per leggere gli oggetti
        FileInputStream fIn = new FileInputStream(path);
        ObjectInputStream objIn = new ObjectInputStream(fIn);

        g.setCommands((HashSet<Command>) objIn.readObject());
        g.setInventory((Inventory) objIn.readObject());
        g.setCurrentRoom((Room) objIn.readObject());
        g.setPlayer((String) objIn.readUTF());
        g.getGameTime().setSecondPassed((int) objIn.readInt());

        objIn.close();
        fIn.close();

    }

}
