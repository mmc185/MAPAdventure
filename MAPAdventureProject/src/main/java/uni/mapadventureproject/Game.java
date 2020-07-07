package uni.mapadventureproject;

import uni.mapadventureproject.files.FileSaver;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import uni.mapadventureproject.type.*;

/**
 * Classe che rappresenta l'entità di gioco
 */
public class Game {

    private Set<Command> commands; // Comandi del gioco
    private Inventory inventory; // Inventario del protagonista
    private Room currentRoom; // stanza in cui si trova il giocatore
    
    private String player = ""; // nome del giocatore
    private GameTimeTask gTime = new GameTimeTask(); // tempo di completamento
    
    // Costruttori
    
    public Game() {
        this.commands = new HashSet<>();
        this.inventory = new Inventory();
    }
    
    public Game(Set<Command> commands, Inventory inventory, Room currentRoom) {
        this.commands = commands;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
    }
    
    // Metodi di get e set
    
    public Set<Command> getCommands() {
        return commands;
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    public void setCommands(Set<Command> commands) {
        this.commands = commands;
    }
    
    /**
     * Carica le informazioni del gioco da file
     * @param filePath path del file da caricare
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void init(String filePath) throws IOException, ClassNotFoundException {
        
        FileSaver fs = new FileSaver();
        fs.readFile(filePath, this);
        
    }
    
    /**
     * Salva le informazioni del gioco su un file
     * @param dirPath path della cartella in cui salvare il gioco
     * @throws IOException 
     */
    public void saveGame(String dirPath) throws IOException {
        
        FileSaver fs = new FileSaver(); 
        fs.saveFile(dirPath + "//Save.dat", this);
        
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public GameTimeTask getGameTime() {
        return gTime;
    }
    
    public void setGameTime(GameTimeTask gTime) {
        this.gTime = gTime;
    }
    
    /**
     * In base al nome del comando, ne restituisce il tipo
     * @param cName nome del possibile comando
     * @return tipo di comando, se presente nell'insieme dei comandi, null altrimenti
     */
    public CommandType getCommandType(String cName) {

        for (Command c : commands ) {

            if (c.getName().equals(cName) || c.getAlias().contains(cName)) {

                return c.getcType();

            }

        }

        return null;

    }
    
}
