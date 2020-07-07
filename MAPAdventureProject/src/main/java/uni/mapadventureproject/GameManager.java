package uni.mapadventureproject;

import uni.mapadventureproject.parser.ParserOutput;
import uni.mapadventureproject.type.Command;
import uni.mapadventureproject.type.CommandType;

/**
 * Classe astratta che definisce il gestore di gioco.
 * A seconda del gioco che si vuole implementare e della differente
 * gestione dei comandi si possono implementare i metodi.
 */
public abstract class GameManager {

    Game game; // entità di gioco

    // Costruttore
    GameManager(Game g) {
        this.game = g;
    }

    // Metodi di get e set
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Esegue il comando dell'utente, se corretto rispetto
     * alla logica dello stato attuale del gioco.
     * 
     * @param pOutput input dell'utente ridefinito e strutturato dal Parser
     * @return stringa di risposta per l'utente
     */
    protected abstract String executeCommand(ParserOutput pOutput);
    
    /**
     * Mostra la guida di gioco col fine di spiegare come inserire input validi
     * e i comandi presenti.
     * @return stringa di guida
     */
    public abstract String showHelp();
    
}
