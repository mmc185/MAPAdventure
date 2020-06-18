package uni.mapadventureproject;

import java.util.Map;
import uni.mapadventureproject.parser.WordType;

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

    public abstract String executeCommand(Map<WordType, String> commandMap);
}
