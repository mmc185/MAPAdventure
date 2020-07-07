/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import sun.audio.* ;
import javax.swing.JOptionPane;

/**
 * Classe per inserire la musica nel gioco 
 */
public class PlayMusic {

    
    public synchronized void playSound(final String url) {
       Thread musicThread= new Thread(new Runnable() {
            
            public void run() {
                try {
                     
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                           new BufferedInputStream(new FileInputStream(url)));
                    clip.open(inputStream);   //acquisizione della risorsa di input
                    Thread.sleep(3000);  //thread fermo per 3 secondi
                    clip.start();        //parte la musica
                   clip.loop(clip.LOOP_CONTINUOUSLY);   //musica in loop all'infinito
                       
                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(null," Music Error");
                }
            }
        });
       musicThread.setDaemon(true);
       musicThread.start();
       
    } 
    
}
