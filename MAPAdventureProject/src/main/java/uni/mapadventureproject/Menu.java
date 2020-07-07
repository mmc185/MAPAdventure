package uni.mapadventureproject;

import java.io.IOException;
import uni.mapadventureproject.parser.InvalidStringException;

/**
 * Gestisce il menu di gioco
 */
public class Menu {

    private GameManager g; // Gestore di gioco
    private GameInteraction gInteraction; // Gestore di interazione di gioco

    // Costruttore
    public Menu(GameManager g) {
        this.g = g;
        this.gInteraction = new GameInteraction(g);
    }

    /**
     * Carica una nuova partita da file
     * @throws IOException
     * @throws InvalidStringException
     * @throws ClassNotFoundException 
     */
    public void newGame() throws IOException, InvalidStringException, ClassNotFoundException {
        g.getGame().init("NewGame//Intro.dat"); 
    }

    /**
     * Carica una partita salvata da file
     * @param path del file da cui caricare
     * @throws IOException
     * @throws InvalidStringException
     * @throws ClassNotFoundException 
     */
    public void loadGame(String path) throws IOException, InvalidStringException, ClassNotFoundException {
        g.getGame().init(path); 
    }

    /**
     * Esce dal gioco
     */
    public void quitGame() {
        System.exit(0);
    }

    // Metodi di get e set
    
    public GameInteraction getgInteraction() {
        return gInteraction;
    }

    public void setgInteraction(GameInteraction gInteraction) {
        this.gInteraction = gInteraction;
    }

}
