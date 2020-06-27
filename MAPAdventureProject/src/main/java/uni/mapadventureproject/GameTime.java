/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Admin
 */
public class GameTime {

    int secondPassed = 0;
    int v;
    Timer time = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondPassed++;
            //secondPassed=getSecondPassed();
            //setSecondPassed(secondPassed);

            //if(secondPassed>60){
            System.out.println("Hai completato il gioco in: " + secondPassed + " secondi");
            // }

        }
       
    };

    
    
    public void start() {
        time.scheduleAtFixedRate(task, 1000, 1000);
        
        
    }

    public int getSecondPassed() {
        return secondPassed;
    }

    public void setSecondPassed(int secondPassed) {
        this.secondPassed = secondPassed;
    }

}
