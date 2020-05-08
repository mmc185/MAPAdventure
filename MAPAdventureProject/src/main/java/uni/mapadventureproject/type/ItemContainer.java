package uni.mapadventureproject.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ItemContainer extends Item {

    private List<Item> cItemList;

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

    public void add(Item i) {
        this.cItemList.add(i);
    }

    public void remove(Item i) {
        this.cItemList.remove(i);
    }
}
