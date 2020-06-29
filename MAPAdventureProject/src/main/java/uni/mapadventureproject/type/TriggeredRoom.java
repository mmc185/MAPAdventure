/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.type;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class TriggeredRoom extends Room {

    private Queue<String> triggerDesc;
    private Queue<String> triggerer;

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


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.triggerDesc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TriggeredRoom other = (TriggeredRoom) obj;
        if (!Objects.equals(this.triggerDesc, other.triggerDesc)) {
            return false;
        }
        return true;
    }

}
