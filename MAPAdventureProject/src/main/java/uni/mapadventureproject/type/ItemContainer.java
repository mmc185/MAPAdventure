package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.Set;

/**
 * Classe utilizzate per rappresentare oggetti che contengono altri oggetti,
 * ovvero per rappresentare dei contenitori 
 */
public class ItemContainer extends Item implements Serializable {

    private Inventory cItemList;    //contenuto del contenitore
    private String lockedBy = "";   //indica da cosa è bloccato,inizialmente da niente
    
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

    public boolean remove(Item i) {
        return this.cItemList.remove(i);
    }

    /**
     * Metodo per sbloccare un contenitore
     * @param cName oggetto che blocca l'apertura di un contenitore
     * @return flag indica se si può aprire o meno
     */
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
        return cItemList.toString();
    }
}
