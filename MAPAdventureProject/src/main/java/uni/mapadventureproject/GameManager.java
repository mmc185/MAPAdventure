package uni.mapadventureproject;

import java.util.Map;
import uni.mapadventureproject.parser.WordType;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.Inventory;
import uni.mapadventureproject.type.Room;

public abstract class GameManager {

    Game game;

    GameManager() {
        this.game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public abstract void executeCommand(Room currentRoom, Inventory inv, Command commands, Map<WordType, String> commandMap);
}
