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
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JOptionPane;

/**
 * Classe per inserire la musica
 */
public class PlayMusic {

    /**
     * Fa partire un thread che riproduce la musica, caricandola da file
     *
     * @param url path del file
     */
    public synchronized void playSound(final String url) {
        Thread musicThread = new Thread(new Runnable() {

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

                    JOptionPane.showMessageDialog(null, " Music Error");
                }
            }
        });

        musicThread.setDaemon(true);
        musicThread.start();

    }

    public void volumeUpDownControl(Double valueToPlusMinus) {
        
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        
        for (Mixer.Info mixerInfo : mixers) {
            
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            
            for (Line.Info lineInfo : lineInfos) {
                
                Line line = null;
                boolean opened = true;
                
                try {
                    
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    
                    if (!opened) {
                        line.open();
                    }
                    
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    
                    Double volumeToCut = valueToPlusMinus;
                    float changedCalc = (float) ((float) currentVolume + (double) volumeToCut);
                    volControl.setValue(changedCalc);
                    
                } catch (LineUnavailableException | IllegalArgumentException e) {
                    //JOptionPane.showMessageDialog(null, " Music Error");
                } finally {
                    
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }

    }

    public void volumeAbsoluteControl(Double valueToPlusMinus) {
        
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        
        for (Mixer.Info mixerInfo : mixers) {
            
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            
            for (Line.Info lineInfo : lineInfos) {
                
                Line line = null;
                boolean opened = true;
                
                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    
                    if (!opened) {
                        line.open();
                    }
                    
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    
                    Double volumeToCut = valueToPlusMinus;
                    float changedCalc = (float) ((double) volumeToCut);
                    volControl.setValue(changedCalc);
                    
                } catch (LineUnavailableException | IllegalArgumentException e) {
                    //JOptionPane.showMessageDialog(null, " Music Error");
                } finally {
                    
                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }

}
