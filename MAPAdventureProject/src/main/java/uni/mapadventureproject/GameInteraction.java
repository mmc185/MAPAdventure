package uni.mapadventureproject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import uni.mapadventureproject.parser.Parser;
import uni.mapadventureproject.parser.InvalidStringException;
import uni.mapadventureproject.parser.ParserOutput;
import uni.mapadventureproject.parser.WordType;

public class GameInteraction {

    private GameManager g;
    private Parser p;

    GameInteraction(GameManager g) {
        this.g = g;
        p = new Parser();
    }

    public GameManager getGameManager() {
        return g;
    }

    public String inputManager(String sInput) {

        ParserOutput pOutput;
        String sOutput = "";
        
        try {
            
            pOutput = p.parse(sInput, g.getGame().getCurrentRoom(), g.getGame().getInventory(), g.getGame().getCommands());
            sOutput = g.executeCommand(pOutput);
            
        } catch (InvalidStringException e) {
            sOutput = "Idea interessante... ma no.";
        }
        
        return sOutput;
    }

}
