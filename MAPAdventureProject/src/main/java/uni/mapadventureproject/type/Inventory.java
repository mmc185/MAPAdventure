package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Usata per Inventario del giocatore e Inventario nella stanza.
 */
public class Inventory implements Serializable {

    private List<Item> inventoryList;

    public Inventory() {
        inventoryList = new ArrayList<>();
    }
    //Metodi get e set per gli attributi
    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    /**
     * Aggiunge un oggetto all'inventario
     * @param i oggetto(item)da aggiungere 
     */
    public void add(Item i) {
        inventoryList.add(i);
    }
    
    /**
     * Rimuove un oggetto dall'inventario
     * @param i oggetto da rimuovere
     * @return  indica se un oggetto è rimuovibile dall'inventario o meno
     */
    public boolean remove(Item i) {
        return inventoryList.remove(i);
    }

    /**
     * Elenca il contenuto dell'inventario del giocatore,della stanza o di un contenitore sotto forma di stringa
     * @return Stringa che indica il contenuto di un oggetto di tipo Inventory
     */
    @Override
    public String toString() {

        StringBuilder invList = new StringBuilder();

        for (Item i : inventoryList) {
            invList.append("\n- " + i.getName());
        }

        return invList.toString();
    }

    /**
     * Cerca un oggetto nella lista di oggetti contenuti dall'inventario
     * @param iName nome oggetto
     * @return i nel caso l'oggetto è presente nella lista e null altrimenti
     */
    public Item searchItem(String iName) {
        for (Item i : inventoryList) {
            
            if (i.getName().equals(iName) || i.getAlias().contains(iName)) {
                return i;
            }
        }

        return null;
    }

}
