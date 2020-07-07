package uni.mapadventureproject;

import uni.mapadventureproject.parser.ParserOutput;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.CommandType;

/**
 * Classe astratta che contiene due metodi astratti che verranno implementati
 * dalla classe che estenderà GameManager che in base al gioco avrà implementazioni differenti
 */
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
