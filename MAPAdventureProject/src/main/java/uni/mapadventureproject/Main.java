/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import uni.mapadventureproject.GUI.MenuGUI;

/**
 *
 * @author marta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        /*Game game = new Game();
        try {
            game.init("NewGame//Intro.dat");
        } catch (IOException e) {
            System.out.println(e);
        }
        //System.out.println(game.getCommands().size());
        GameManager manager = new MSGame(game);
        GameInteraction gInt = new GameInteraction(manager);
        try {
            gInt.inputManager();
        } catch (InvalidStringException e) {
            System.out.println(e);
        }*/
        //Game game = new Game();
        
        //try {
        //game.init("NewGame//Intro.dat");
        //GameManager gManager = new MSGame(game);

        Game game = new Game();
        GameManager gManager = new MSGame(game);
        MenuGUI gMenuGUI = new MenuGUI(gManager);
        gMenuGUI.setVisible(true);

        /*} catch (IOException e) {
            System.out.println("Errore riscontrato nel caricamento da file!\n"
                    + "Controllare che i file siano presenti nella corretta cartella:"
                    + "/NewGame/Intro.dat");
        }*/
    }

}
