package uni.mapadventureproject;

public class Menu {

    private GameManager g;
    private GameInteraction gInteraction;

    public Menu(GameManager g) {
        this.g = g;
        this.gInteraction = new GameInteraction();
    }

    public void newGame() {
        g.getGame().init("/NewGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager(g);
    }

    public void loadGame() {
        g.getGame().init("/SavedGame"); // Da aggiungere e/o cambiare
        gInteraction.inputManager(g);
    }

    public void saveGame() {
        g.getGame().saveGame("/SavedGame");
    }

    public void quitGame() {
        System.exit(0);
    }

}
