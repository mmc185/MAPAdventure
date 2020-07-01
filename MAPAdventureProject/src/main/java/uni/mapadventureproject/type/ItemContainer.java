package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ItemContainer extends Item implements Serializable {

    private List<Item> cItemList;
    private String lockedBy = "";

    public ItemContainer(List<Item> cItemList, int id, String name, String desc) {
        super(id, name, desc);
        this.cItemList = new ArrayList<>();
    }

    public ItemContainer(List<Item> cItemList, int id, String name, String desc, Set<String> alias) {
        super(id, name, desc, alias);
        this.cItemList = new ArrayList<>();
    }

    public List<Item> getcItemList() {
        return cItemList;
    }

    public void setcItemList(List<Item> cItemList) {
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

    public String toString() {

        String cList = "";
        for (Item i : cItemList) {
            cList = cList + "\n- " + i.getName();
        }
        return cList;
    }
}
