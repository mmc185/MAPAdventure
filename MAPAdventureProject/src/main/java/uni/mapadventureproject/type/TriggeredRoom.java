/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.mapadventureproject.type;

/**
 *
 * @author Admin
 */
public class TriggeredRoom extends Room {

    private boolean trigger = false;
    private String triggerDesc;

    public TriggeredRoom(String triggerDesc, int id, String name, String desc) {
        super(id, name, desc);
        this.triggerDesc = triggerDesc;
    }

   

    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
        setDesc(triggerDesc);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.trigger ? 1 : 0);
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
        if (this.trigger != other.trigger) {
            return false;
        }
        return true;
    }

}
