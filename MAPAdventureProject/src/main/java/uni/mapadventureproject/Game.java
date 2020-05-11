package uni.mapadventureproject;

import java.util.HashSet;
import java.util.Set;
import uni.mapadventureproject.type.*;

public class Game {

    //private final List<Room> map; //Dovrebbe essere inutile
    private final Set<Command> commands;
    private Inventory inventory;
    private Room currentRoom;

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

    public void init(String filePath) {
    }

    public void saveGame(String dirPath) {
    }

}
