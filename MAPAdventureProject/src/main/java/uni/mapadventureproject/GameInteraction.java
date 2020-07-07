package uni.mapadventureproject;

import uni.mapadventureproject.parser.Parser;
import uni.mapadventureproject.parser.InvalidStringException;
import uni.mapadventureproject.parser.ParserOutput;

/**
 * Classe che si occupa delle risposte da dare all'utente dopo il comando inserito
 */
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

    /**
     * Si occupa di dare delle risposte ai comandi inseriti dal giocatore
     * @param sInput comando preso in input
     * @return risposta al giocatore
     */
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
