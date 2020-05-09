
package uni.mapadventureproject;


public class Menu {
    
    private Game g;
    private GameInteraction gInteraction;

    public Menu(Game g) {
        this.g = g;
        this.gInteraction = new GameInteraction();
    }
    
    public void newGame() {
        g.init("/NewGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager(g);
    }
    
    public void loadGame() {
        g.init("/SavedGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager(g);
    }
    
    public void saveGame() {
        g.saveGame("/SavedGame");
    }
    
    public void quitGame() {
        System.exit(0);
    }
    
    
    
}
