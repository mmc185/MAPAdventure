package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Usata per Inventario del giocatore e Inventario nella stanza. (Da creare
 * interfaccia?)
 */
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

    public boolean remove(Item i) {

        return inventoryList.remove(i);

    }

    @Override
    public String toString() {

        StringBuilder invList = new StringBuilder();

        for (Item i : inventoryList) {
            invList.append("\n- " + i.getName());
        }

        return invList.toString();
    }

    public Item searchItem(String iName) {
        for (Item i : inventoryList) {
            if (i.getName().equals(iName) || i.getAlias().contains(iName)) {

                return i;

            }
        }

        return null;
    }

}
