/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.type;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *Classe utilizzata per rappresentare quelle stanze che dopo certe azioni subivano
 * dei cambiamenti e ne modificavano la descrizione.
 * Utilizzata per creare enigmi o per vincolare il giocatore a compiere una determinata
 * azione prima di proseguire
 */
public class TriggeredRoom extends Room {

    private Queue<String> triggerDesc;  // coda che contiene le varie descrizioni di una stanza dopo un certo evento
    private Queue<String> triggerer;    // coda che contiene le varie azioni che fanno variare le descrizioni della stanza

    public TriggeredRoom(int id, String name, String desc) {
        super(id, name, desc);
        triggerDesc = new ArrayDeque<>();
        triggerer = new ArrayDeque<>();
    }
    
    public TriggeredRoom(int id, String name, String desc, Queue<String> triggerer, Queue<String> triggerDesc) {
        super(id, name, desc);
        this.triggerer = triggerer;
        this.triggerDesc = triggerDesc;
    }

    // Se ci sono ancora trigger la stanza è triggerabile
    public boolean isTriggerable() {
        return !triggerer.isEmpty();
    }

    // se il trigger è positivo, avanza nelle code
    public void setTrigger(boolean trigger) {
        
        if (trigger) {
        setDesc(triggerDesc.poll());
        triggerer.poll();
        }
        
    }

    public Queue<String> getTriggerDesc() {
        return triggerDesc;
    }
   
    public void addTriggerDesc(String triggerDesc) {
        this.triggerDesc.offer(triggerDesc);
    }

    public Queue<String> getTriggerer() {
        return triggerer;
    }

    public void addTriggerer(String triggerer) {
        this.triggerer.offer(triggerer);
    }
    
    public String getCurrentTriggerer() {
        
        if (this.isTriggerable()) {
            return triggerer.peek();
        } else {
            return "";
        }
        
    }

}
