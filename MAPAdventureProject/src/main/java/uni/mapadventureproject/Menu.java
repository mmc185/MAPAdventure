package uni.mapadventureproject;

public class Menu {

    private GameManager g;
    private GameInteraction gInteraction;

    public Menu(GameManager g) {
        this.g = g;
        this.gInteraction = new GameInteraction(g);
    }

    public void newGame() {
        g.getGame().init("/NewGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager();
    }

    public void loadGame() {
        g.getGame().init("/SavedGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager();
    }

    public void saveGame() {
        g.getGame().saveGame("/SavedGame");
    }

    public void quitGame() {
        System.exit(0);
    }

}
