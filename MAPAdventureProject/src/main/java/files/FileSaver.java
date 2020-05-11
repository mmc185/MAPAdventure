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
        
        //TODO inventario e currentRoom
        
        objOut.close();
        fOut.close();
    }

    public void readFile(String path) throws IOException {
        FileInputStream fIn = new FileInputStream(path);
        ObjectInputStream objIn = new ObjectInputStream(fIn);
        try {
            while (fIn.available() != 0) {

                //TODO inventario e currentRoom
                g = new Game( (HashSet<Command>) objIn.readObject(), null, null);

            }
        } catch (ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        objIn.close();
        fIn.close();
    }

    public static void main(String[] args) {
        
        Command c1 = new Command("Apri");
        Command c2 = new Command("Chiudi");
        Command c3 = new Command("Cammina");
        
        Set<Command> s = new HashSet<Command>();
        s.add(c1);
        s.add(c2);
        s.add(c3);
       
         
        FileSaver fs = new FileSaver();
        //fs.g = new Game(s, null, null);

        try {
            //fs.saveFile();
            fs.readFile("NewGame//Intro.dat");
            for (Command c : fs.g.getCommands()) {
                System.out.println(c.getName());
            }
        } catch (IOException exc) {
            System.out.println("1"+exc.getMessage());
        } catch (Exception e) {
            System.out.println("2"+e.getMessage());
        }
    }

}
