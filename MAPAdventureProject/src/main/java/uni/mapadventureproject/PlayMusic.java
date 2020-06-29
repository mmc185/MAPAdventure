/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import sun.audio.* ;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class PlayMusic {

    /* public static void playMusic(String filePath){
        InputStream music;
        try{
            music=new FileInputStream(new File(filePath));
            AudioStream audio= new AudioStream(music);
            AudioPlayer.player.start(audio);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," Music Error");
        }
    } */
    public static synchronized void playSound(final String url) {
       Thread musicThread= new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                     
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                           new BufferedInputStream(new FileInputStream(url)));
                    clip.open(inputStream);
                    Thread.sleep(3000);
                    clip.start();
                   
                   // clip.wait(6000);
                   
                    
                } catch (Exception e) {
                   // System.err.println(e.getMessage());
                   JOptionPane.showMessageDialog(null," Music Error");
                }
            }
        });
       musicThread.setDaemon(true);
       musicThread.start();
       
    } 
    
   /* public static void playMusic(String filepath){
        try{
            AudioData data = new AudioStream(new FileInputStream(filepath).getData);
            ContinuousAudioDataStream sound= new ContinuousAudioDataStream(data);
            AudioPlayer.player.start(sound);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," Music Error");
        }
    } */
}
