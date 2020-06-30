/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Admin
 */
public class GameTimeThread implements Serializable {

    private int secondPassed = 0;
    private Timer time = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondPassed++;

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

    public Timer getTimer() {
        return time;
    }

    public void setTimer(Timer time) {
        this.time = time;
    }

    public TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public String getTime(int secondPassed) {
        
        int hours = 0;
        int remainderOfHours;
        int minutes = 0;
        int seconds = 0;
        String strHours;
        String strMinutes;
        String strSeconds;
        String time;
        
        if (secondPassed >= 3600) {
            
            hours = secondPassed / 3600;
            remainderOfHours = secondPassed % 3600;
            
            if (remainderOfHours >= 60) {
                
                minutes = remainderOfHours / 60;
                seconds = remainderOfHours % 60;
                
            } else {
                
                seconds = remainderOfHours;
            }
            
        } else if (secondPassed >= 60) {
            
            hours = 0;
            minutes = secondPassed / 60;
            seconds = secondPassed % 60;
            
        } else if (secondPassed < 60) {
            
            hours = 0;
            minutes = 0;
            seconds = secondPassed;
        }
        
        if (seconds < 10) {
            
            strSeconds = "0" + Integer.toString(seconds);
            
        } else {
            
            strSeconds = Integer.toString(seconds);
        }
        
        if (minutes < 10) {
            
            strMinutes = "0" + Integer.toString(minutes);
            
        } else {
            
            strMinutes = Integer.toString(minutes);
        }
        
        if (hours < 10) {
            
            strHours = "0" + Integer.toString(hours);
            
        } else {
            
            strHours = Integer.toString(hours);
        }
        
        time = strHours + "h" + strMinutes + "m" + strSeconds + "s";

        return time;
    }

}
