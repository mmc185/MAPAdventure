package uni.mapadventureproject;

import uni.mapadventureproject.parser.ParserOutput;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.CommandType;

public abstract class GameManager {

    Game game;

    GameManager(Game g) {
        this.game = g;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    protected abstract String executeCommand(ParserOutput pOutput);
    
    public abstract String showHelp();
    
}
