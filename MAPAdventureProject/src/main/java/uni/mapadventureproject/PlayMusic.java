/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
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

            @Override
            public void run() {
                try {

                    Clip clip = AudioSystem.getClip();

                    // La risorsa del try with resource si chiuderà da sola poiché implementa l'interfaccia AutoCloseable
                    try (AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new BufferedInputStream(new FileInputStream(url)))) {

                        clip.open(inputStream);   //acquisizione della risorsa di input
                        Thread.sleep(3000);  //thread fermo per 3 secondi
                        clip.start();        //parte la musica
                        clip.loop(Clip.LOOP_CONTINUOUSLY);   //musica in loop all'infinito

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, " File non trovato: Music Error");
                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, " Music Error");
                }
            }
        });

        musicThread.setDaemon(true);
        musicThread.start();

    }

    /**
     * Metodo per alzare o abbassare il volume della musica
     *
     * @param valueToPlusMinus indica di quanto aumentare o diminuire il volume
     * della musica
     */
    public void volumeUpDownControl(Double valueToPlusMinus) {
        //Legge le informazioni del Mixer dal sistema audio
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

                    //fa un controllo sul float
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    //vede il volume attuale
                    float currentVolume = volControl.getValue();

                    Double volumeToCut = valueToPlusMinus;
                    //aumenta il volume se il valore di volumeToCut è positivo,altrimenti decrementa se è negativo
                    float changedCalc = (float) ((float) currentVolume + (double) volumeToCut);
                    volControl.setValue(changedCalc);    //imposta il volume della musica

                } catch (LineUnavailableException | IllegalArgumentException e) {
                } finally {

                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }

    }

    /**
     * Metodo per mettere al massimo il volume della musica o per mutarla
     *
     * @param valueToPlusMinus indica a quanto sarà settato il volume della
     * musica
     */
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

                    Double volumeToCut = valueToPlusMinus;
                    //se volumeToCut è 0.0 allora la musica verrà mutata,se è 1.0 la musica verrà aumentata al massimo
                    float changedCalc = (float) ((double) volumeToCut);
                    volControl.setValue(changedCalc);  //imposta il volume della musica

                } catch (LineUnavailableException | IllegalArgumentException e) {
                } finally {

                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }

}
