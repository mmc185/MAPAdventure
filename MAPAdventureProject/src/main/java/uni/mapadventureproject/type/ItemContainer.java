package uni.mapadventureproject.type;

import java.util.ArrayList;
import java.util.List;

public class ItemContainer extends Item {

    private List<Item> cItemList;

    public ItemContainer(List<Item> cItemList) {
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
