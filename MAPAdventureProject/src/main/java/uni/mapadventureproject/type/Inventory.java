package uni.mapadventureproject.type;

import java.util.ArrayList;
import java.util.List;


public class Inventory {
    
    private List<Item> inventoryList;

    public Inventory() {
        inventoryList = new ArrayList<>();
    }

    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    public void add(Item i) {
        inventoryList.add(i);
    }
    
    public void remove(Item i) {
        inventoryList.remove(i);
    }
    
}
