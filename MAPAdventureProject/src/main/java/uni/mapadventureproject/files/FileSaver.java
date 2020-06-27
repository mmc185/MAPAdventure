package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import javax.swing.ImageIcon;
import uni.mapadventureproject.Game;
import uni.mapadventureproject.type.*;

public class FileSaver {

    Game g;

    public Game getG() {
        return g;
    }

    public void init() {

        g = new Game();

        //Items dell'inventario
        Item taralli = new Item(50, "taralli", "Taralli in busta... Gli ottimi taralli del forno (che ti compra tua madre), ti viene l'acquolina in bocca solo a pensarci!");
        taralli.setAlias(new String[]{"tarallini"});
        ImageIcon img = new ImageIcon("img//inventario//taralli.png");
        taralli.setItemImage(img);
        g.getInventory().add(taralli);
        Item notes = new Item(51, "quaderno", "Quaderno con gli appunti di MAP pieno di \"pippottoni\"");
        notes.setAlias(new String[]{"appunti", "riassunti", "block-notes", "fogli"});
        img = new ImageIcon("img//inventario//appunti.png");
        notes.setItemImage(img);
        g.getInventory().add(notes);
        Item umbrella = new Item(52, "ombrello", "Fidato ombrello, ogni volta che ce l'hai con te non piove mai!");
        umbrella.setAlias(new String[]{"ombrellino"});
        img = new ImageIcon("img//inventario//ombrello.png");
        umbrella.setItemImage(img);
        g.getInventory().add(umbrella);
        Item bottle = new Item(53, "borraccia", "La borraccia che hai aspettato tanto per avere dal DIB, forse facevi prima a scroccarla dal PoliBa...");
        bottle.setAlias(new String[]{"bottiglietta", "bottiglia"});
        img = new ImageIcon("img//inventario//bottiglia.png");
        bottle.setItemImage(img);
        g.getInventory().add(bottle);
        Item pendrive = new Item(54, "pendrive", "La solita pen-drive che usi ormai da diversi anni.");
        pendrive.setAlias(new String[]{"chiavetta", "usb", "chiavetta usb", "pen-drive"});
        img = new ImageIcon("img//inventario//chiavetta.png");
        pendrive.setItemImage(img);
        g.getInventory().add(pendrive);

        //Stanze
        Room station = new Room(0, "Stazione ferroviaria", "Una voce metallica gracchia dall'altoparlante:"
                + "\n\"Il treno regionale delle ore 9:00 diretto a Bari Centrale è in partenza dal binario 9 con un ritardo di 10 minuti!\""
                + "\nSenti il fischio assordante del capotreno che ti sollecita a salire.");

        Room wagon = new Room(1, "Vagone del treno", "Dopo esserti fatto strada tra l'assembramento di persone sui vagoni, trovi il tuo amico nonché compagno di progetto.\n"
                + "Che fortuna, ti ha preso il posto! (stonks) Ti siedi.\n"
                + "\"Beh, ti senti preparato per l'esame di oggi? Spero che il prof sia clemente...\" ti chiede il tuo amico.\n\n"
                + "\"Io ricordavo che il prof si chiamasse Pierpaolo\" rispondi. \nIl tuo amico ti defenestra. GAME OVER\n\n"
                + "Scherzo, riprendiamo.\n\n"
                + "\"Hey, hai con te la pen-drive, vero?! Non ripetiamo l'incidente di laboratorio...\" ti chiede il tuo amico.\n"
                + "Apri lo zaino e gliela mostri, non perderesti mai qualcosa di così importante... vero? ");

        Room metaStation = new Room(2, "Metastazione", "Come sempre scendi dal treno stretto come una sardina in mezzo ad altri poveri pendolari.\n"
                + "Noti che il treno si è fermato a un binario diverso dal solito, alzi lo sguardo e leggi \"Binario 0\".\n"
                + "Strano, non ti ricordavi esistesse quel binario\n"
                + "Aspetta, questa non sembra la stazione di Bari.\n"
                + "Ti guardi intorno spaesato.\n"
                + "Un strano uomo con delle orecchie a punta si avvicina al capotreno:\n"
                + "\"Scusi, mi può dire la strada per il portale che conduce a PaleoliticCity?\"\n"
                + "Guardi il tuo amico con gli occhi strabuzzati e lui scrolla le spalle \n"
                + "\"Cerchiamo di capire dove cavolo siamo finiti!\" e inizia a guardarsi intorno.");

        //Items delle stanze 
        Item poster = new Item(55, "poster", "L'Agenzia di viaggi Artskjid ti dà il benvenuto alla Metastazione Centrale! \n"
                + "Luogo da cui puoi raggiungere ogni dimensione immaginabile. \nPer informazioni, chiedere al personale in divisa.\"");
        poster.setAlias(new String[]{"cartello", "cartellone", "manifesto", "affisso", "locandina"});

        station.setUp(wagon);
        station.setLook("Ti trovi di fronte alle porte del treno. Dovresti muoverti prima che si chiudano!");
        wagon.setDown(metaStation);
        wagon.setLook("Il vagone è strapieno come sempre! ");
        metaStation.setLook("Sul muro della stazione è affisso un grande poster con grandi scritte colorate e vicino al cancello di uscita\n"
                + "c'è una strana creatura simile a un polpo che suona i tamburi con i suoi diversi tentacoli.");
        metaStation.addItem(poster);

        //Comandi
        Command north = new Command("nord", CommandType.MOVE_N);
        g.getCommands().add(north);
        Command south = new Command("sud", CommandType.MOVE_S);
        g.getCommands().add(south);
        Command west = new Command("ovest", CommandType.MOVE_W);
        g.getCommands().add(west);
        Command east = new Command("est", CommandType.MOVE_E);
        g.getCommands().add(east);
        Command inv = new Command("inventario", CommandType.INV);
        inv.setAlias(new String[]{"inv", "zaino", "borsa"});
        g.getCommands().add(inv);
        Command look = new Command("guarda", CommandType.LOOK);
        look.setAlias(new String[]{"osserva", "vedi", "trova", "cerca", "descrivi", "controlla"});
        g.getCommands().add(look);
        Command pickup = new Command("prendi", CommandType.PICK_UP);
        pickup.setAlias(new String[]{"raccogli"});
        g.getCommands().add(pickup);
        Command open = new Command("apri", CommandType.OPEN);
        g.getCommands().add(open);
        Command push = new Command("premi", CommandType.PUSH);
        push.setAlias(new String[]{"spingi", "attiva"});
        g.getCommands().add(push);

        Command up = new Command("sali", CommandType.MOVE_U);
        up.setAlias(new String[]{"sopra", "su"});
        g.getCommands().add(up);
        Command down = new Command("scendi", CommandType.MOVE_D);
        down.setAlias(new String[]{"sotto", "giù"});
        g.getCommands().add(down);
        Command escape = new Command("scappa", CommandType.RUN);
        escape.setAlias(new String[]{"fuggi", "muori", "crepa"});
        g.getCommands().add(escape);
        Command end = new Command("esci", CommandType.EXIT);
        g.getCommands().add(end);
        Command wake = new Command("sveglia", CommandType.WAKE_UP);
        wake.setAlias(new String[]{"svegliati"});
        g.getCommands().add(wake);

        //Comando buttati?
        //TODO Serve anche un comando per uscire dal gioco?
        g.setCurrentRoom(station);

    }

    public void saveFile(String path, Game g) throws FileNotFoundException, IOException {

        // FileOutputStream fOut = new FileOutputStream(path + "/Save.dat");
        FileOutputStream fOut = new FileOutputStream(path + "/Intro.dat");
        ObjectOutputStream objOut = new ObjectOutputStream(fOut);

        objOut.writeObject(g.getCommands());

        objOut.writeObject(g.getInventory());

        objOut.writeObject(g.getCurrentRoom());

        objOut.close();
        fOut.close();

    }

    public void readFile(String path, Game g) throws IOException, ClassNotFoundException {
        FileInputStream fIn = new FileInputStream(path);

        ObjectInputStream objIn = new ObjectInputStream(fIn);

        while (fIn.available() != 0) {

            g.setCommands((HashSet<Command>) objIn.readObject());
            g.setInventory((Inventory) objIn.readObject());
            g.setCurrentRoom((Room) objIn.readObject());

        }

        objIn.close();
        fIn.close();

    }

    public static void main(String[] args) {

        FileSaver fs = new FileSaver();
        //fs.g = new Game(s, null, null);
        fs.init();

        try {
            fs.saveFile("NewGame",fs.getG());
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
             
        } catch (IOException exc) {
            System.out.println("1" + exc.getMessage());*/
        } catch (Exception e) {
            System.out.println("2" + e.getMessage());
        }
    }

}