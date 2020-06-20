package uni.mapadventureproject;

import java.util.Map;
import uni.mapadventureproject.parser.WordType;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.CommandType;

public abstract class GameManager {

    Game game;

    GameManager( Game g ) {
        this.game = g;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    protected abstract String executeCommand(Map<WordType, String> commandMap);
    
    public CommandType getCommandType(String cName) {

        for (Command c : this.getGame().getCommands()) {

            if (c.getName().equals(cName) || c.getAlias().contains(cName)) {

                return c.getcType();

            }

        }

        return null;

    }
}
