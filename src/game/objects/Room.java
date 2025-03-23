package game.objects;

import java.util.ArrayList;

public class Room {

    private int roomId;
    private String locationName;
    private ArrayList<Integer> availableRooms;
    private ArrayList<Npc> npcs = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private boolean locked;

    public Room(int roomId, String locationName, ArrayList<Integer> availableRooms, boolean locked) {
        this.roomId = roomId;
        this.locationName = locationName;
        this.availableRooms = availableRooms;
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getLocationName() {
        return locationName;
    }

    public ArrayList<Integer> getAvailableRooms() {
        return availableRooms;
    }

    public void setNpcs(ArrayList<Npc> npcs) {
        this.npcs = npcs;
    }

    public ArrayList<Npc> getNpcs() {
        return npcs;
    }

    public void addNpc(Npc npc) {
        npcs.add(npc);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(String.valueOf(itemName))) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + roomId +
                ", locationName='" + locationName + '\'' +
                ", availableRooms=" + availableRooms +
                ", npcs=" + npcs +
                ", items=" + items +
                '}';
    }
}
