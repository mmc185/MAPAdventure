package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.Iterator;
import javax.swing.ImageIcon;
import uni.mapadventureproject.type.ItemContainer;

/**
 * Classe utilizzate per realizzare le stanze
 */
public class Room implements Serializable {

    private final int id;
    private String name;
    private String desc;
    private String look;     //fornisce una decrizione più dettagliata della stanza
    
    // Stanze collegate per ogni direzione
    private Room north = null;
    private Room south = null;
    private Room west = null;
    private Room east = null;
    private Room up = null;
    private Room down = null;
    
    private Inventory itemList;  //lista di oggetti presenti nella stanza
    private String lockedBy = "";  //indica l'oggetto che permette di sbloccare la stanza
    private ImageIcon roomImage;   // immagine raffigurante la stanza che verrà visualizzata nell'interfaccia grafica
    
    // Costruttore
    public Room(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        itemList = new Inventory();
    }

    // Metodi get, set, equals e hashcode
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getUp() {
        return up;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public Room getDown() {
        return down;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public Inventory getItemList() {
        return itemList;
    }

    public void setItemList(Inventory itemList) {
        this.itemList = itemList;
    }

    /**
     * Aggiunge un oggetto alla stanza
     * @param i item da aggiungere
     */
    public void addItem(Item i) {
        itemList.add(i);
    }

    /**
     * Rimuove un oggetto dalla stanza
     * @param i item da rimuovere
     * @return booleano, true se l'oggetto è stato rimosso, false altrimenti
     */
    public boolean removeItem(Item i) {

        // Se prova a rimuovere l'oggetto dalla stanza ma non lo trova
        if (!itemList.remove(i)) {
            
            // Cerca in un ItemContainer della stanza
            Iterator<Item> it = itemList.getInventoryList().iterator();
            Item item;
            
            while (it.hasNext()) {
                
                item = it.next();
                
                // Se il contenitore contiene quell'elemento lo rimuove
                if (item instanceof ItemContainer && ((ItemContainer) item).remove(i)) {
                    return true;
                }
            }

        } else {
            // Se l'ha trovato nella stanza allora l'ha rimosso
            return true;
        }
        return false;
    }

    public ImageIcon getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(ImageIcon roomImage) {
        this.roomImage = roomImage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
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
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
