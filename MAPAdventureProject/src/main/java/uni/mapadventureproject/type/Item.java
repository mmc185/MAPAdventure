package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 * Classe utilizzata per rappresentare gli oggetti che saranno presenti nel gioco
 */
public class Item implements Serializable {

    private final int id;
    private String name;
    private String desc;
    private Set<String> alias;
    private byte consumable = -1; // indica il numero di usi possibili, -1 significa che non è consumabile
    private boolean pickupable = false;
    private boolean pushable = false;
    private boolean push = false;
    private ImageIcon itemImage;   //immagine raffigurante l'oggetto

    public Item(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.alias = new HashSet<String>();
    }

    public Item(int id, String name, String desc, Set<String> alias) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.alias = alias;
    }

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

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    public byte getConsumable() {
        return consumable;
    }
    
    public boolean isConsumed() {
        return this.getConsumable() == 0;
    }

    public void setConsumable(byte consumable) {
        this.consumable = consumable;
    }
    
    /**
     * Decrementa di uno il numero di utilizzi di un oggetto se esso è consumabile
     */
    public void consume() {
        if (consumable > 0) {
            this.setConsumable((byte) (consumable - 1));
        } 
    }
 
    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isPushable() {
        return pushable;
    }

    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public ImageIcon getItemImage() {
        return itemImage;
    }

    public void setItemImage(ImageIcon itemImage) {
        this.itemImage = itemImage;
    }    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
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
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
