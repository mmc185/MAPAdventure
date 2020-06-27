/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.type;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class TriggeredRoom extends Room {

    private boolean activedTrigger = false;
    private String triggerDesc;
    private String triggerer;

    public TriggeredRoom(int id, String name, String desc) {
        super(id, name, desc);
    }
    
    public TriggeredRoom(int id, String name, String desc, String triggerer, String triggerDesc) {
        super(id, name, desc);
        this.triggerer = triggerer;
        this.triggerDesc = triggerDesc;
    }

    public boolean isTrigger() {
        return activedTrigger;
    }

    public void setTrigger(boolean trigger) {
        this.activedTrigger = trigger;
        setDesc(triggerDesc);
    }

    public String getTriggerDesc() {
        return triggerDesc;
    }

    public void setTriggerDesc(String triggerDesc) {
        this.triggerDesc = triggerDesc;
    }

    public String getTriggerer() {
        return triggerer;
    }

    public void setTriggerer(String triggerer) {
        this.triggerer = triggerer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.activedTrigger ? 1 : 0);
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
        if (this.activedTrigger != other.activedTrigger) {
            return false;
        }
        if (!Objects.equals(this.triggerDesc, other.triggerDesc)) {
            return false;
        }
        return true;
    }

}
