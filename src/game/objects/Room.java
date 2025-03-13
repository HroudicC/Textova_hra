package game.objects;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int roomId;
    private String locationName;
    private ArrayList<Integer> availableRooms;
    private ArrayList<Npc> npcs = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

    public Room(int roomId, String locationName, ArrayList<Integer> availableRooms) {
        this.roomId = roomId;
        this.locationName = locationName;
        this.availableRooms = availableRooms;
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
            if (item.getItemName().equalsIgnoreCase(itemName)) {
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
