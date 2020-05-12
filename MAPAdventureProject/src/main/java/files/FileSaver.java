package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import uni.mapadventureproject.Game;
import uni.mapadventureproject.type.*;

public class FileSaver {

    Game g;

    public void init() {
        //TODO inizializza Items, Room, etc...
    }

    public void saveFile() throws FileNotFoundException, IOException {

        FileOutputStream fOut = new FileOutputStream("NewGame//Intro.dat");
        ObjectOutputStream objOut = new ObjectOutputStream(fOut);

        objOut.writeObject(g.getCommands());

        objOut.writeObject(g.getInventory());

        objOut.writeObject(g.getCurrentRoom());

        objOut.close();
        fOut.close();
    }

    public void readFile(String path) throws IOException {
        FileInputStream fIn = new FileInputStream(path);
        ObjectInputStream objIn = new ObjectInputStream(fIn);
        try {
            while (fIn.available() != 0) {

                g = new Game((HashSet<Command>) objIn.readObject(), (Inventory) objIn.readObject(), (Room) objIn.readObject());

            }
        } catch (ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        objIn.close();
        fIn.close();
    }

    public static void main(String[] args) {

        FileSaver fs = new FileSaver();
        //fs.g = new Game(s, null, null);

        try {
            fs.saveFile();
            /*fs.readFile("NewGame//Intro.dat");
            for (Command c : fs.g.getCommands()) {
                System.out.println(c.getName());
            }
           System.out.println("==========================");
            for (Item i : fs.g.getInventory().getInventoryList() ) {
                System.out.println(i.getName() + ": " + i.getDesc() );
            }
            System.out.println("==========================");
            System.out.println("Nome: " + fs.g.getCurrentRoom().getName() +
                    "\nDesc: " + fs.g.getCurrentRoom().getDesc()+ 
                    "\nLook: " + fs.g.getCurrentRoom().getLook());
             */
        } catch (IOException exc) {
            System.out.println("1" + exc.getMessage());
        } catch (Exception e) {
            System.out.println("2" + e.getMessage());
        }
    }

}
