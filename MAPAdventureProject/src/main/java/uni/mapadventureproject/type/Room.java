package uni.mapadventureproject.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Room implements Serializable {

    private final int id;
    private String name;
    private String desc;
    private String look;
    private Room north = null;
    private Room south = null;
    private Room west = null;
    private Room east = null;
    private Room up = null;
    private Room down = null;
    private Inventory itemList;
    private String lockedBy = "";
    private ImageIcon roomImage;

    public Room(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        itemList = new Inventory();
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

    public void addItem(Item i) {
        itemList.add(i);
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
