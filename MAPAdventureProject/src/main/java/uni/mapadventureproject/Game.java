package uni.mapadventureproject;

import uni.mapadventureproject.files.FileSaver;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import uni.mapadventureproject.type.*;

public class Game {

    //private final List<Room> map; //Dovrebbe essere inutile
    private Set<Command> commands;
    private Inventory inventory; //inventario del protagonista
    private Room currentRoom;
    
    private GameTimeThread gTime = new GameTimeThread();
    
    public Game() {
        this.commands = new HashSet<>();
        this.inventory = new Inventory();
    }
    
    public Game(Set<Command> commands, Inventory inventory, Room currentRoom) {
        this.commands = commands;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
    }
    
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
    
    public void init(String filePath) throws IOException, ClassNotFoundException {
        
        FileSaver fs = new FileSaver();
        fs.readFile(filePath, this);
        
    }
    
    public void saveGame(String dirPath) throws IOException {
        FileSaver fs = new FileSaver(); 
        fs.saveFile(dirPath, this);
    }

    public GameTimeThread getGameTime() {
        return gTime;
    }
    
    public void setGameTime(GameTimeThread gTime) {
        this.gTime = gTime;
    }
    
}
