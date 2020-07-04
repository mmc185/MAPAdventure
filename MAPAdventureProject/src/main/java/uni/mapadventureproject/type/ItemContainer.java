package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ItemContainer extends Item implements Serializable {

    private Inventory cItemList;
    private String lockedBy = "";
    
     public ItemContainer(int id, String name, String desc) {
        super(id, name, desc);
        this.cItemList = new Inventory();
    }

    public ItemContainer(Inventory cItemList, int id, String name, String desc) {
        super(id, name, desc);
        this.cItemList = cItemList;
    }

    public ItemContainer(Inventory cItemList, int id, String name, String desc, Set<String> alias) {
        super(id, name, desc, alias);
        this.cItemList = cItemList;
    }

    public Inventory getcItemList() {
        return cItemList;
    }

    public void setcItemList(Inventory cItemList) {
        this.cItemList = cItemList;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public void add(Item i) {
        this.cItemList.add(i);
    }

    public void remove(Item i) {
        this.cItemList.remove(i);
    }

    public boolean unlockContainer(String cName) {

        boolean flag = false;

        if (getLockedBy().equals(cName)) {
            this.setLockedBy("");
            flag = true;
        }

        return flag;

    }

    @Override
    public String toString() {
        return cItemList.toString(); //?????
    }
}
