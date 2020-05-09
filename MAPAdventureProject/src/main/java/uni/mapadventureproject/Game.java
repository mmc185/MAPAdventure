package uni.mapadventureproject;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import uni.mapadventureproject.type.*;

public abstract class Game {

    private final List<Room> map;
    private final Set<Command> commands;
    private Inventory inventory;
    private Room currentRoom;

    public Game(Room room) {
        this.map = new ArrayList<>();
        this.commands = new HashSet<>();
        this.inventory = new Inventory();
        this.currentRoom = room;
    }

    public Game(List<Room> map, Set<Command> commands, Inventory inventory, Room currentRoom) {
        this.map = map;
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

    public abstract void init(String filePath);

    public abstract void saveGame(String dirPath);

}
