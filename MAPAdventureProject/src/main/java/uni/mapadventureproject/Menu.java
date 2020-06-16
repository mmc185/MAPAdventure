package uni.mapadventureproject;

import java.io.IOException;

public class Menu {

    private GameManager g;
    private GameInteraction gInteraction;

    public Menu(GameManager g) {
        this.g = g;
        this.gInteraction = new GameInteraction(g);
    }

    public void newGame() throws IOException {
        g.getGame().init("/NewGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager();
    }

    public void loadGame() throws IOException {
        g.getGame().init("/SavedGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager();
    }

    public void saveGame() throws IOException {
        g.getGame().saveGame("/SavedGame");
    }

    public void quitGame() {
        System.exit(0);
    }

}
