package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Usata per Inventario del giocatore e Inventario nella stanza. 
 * (Da creare interfaccia?)*/
public class Inventory implements Serializable {
    
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
