/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import uni.mapadventureproject.GUI.MenuGUI;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        // Si crea l'istanza di gioco e il suo gestore
        Game game = new Game();
        
        // Gestore specifico del MetaStationGame
        GameManager gManager = new MSGame(game); 
        
        MenuGUI gMenuGUI = new MenuGUI(gManager);
        gMenuGUI.setVisible(true);

    }

}
