package game.commands;

import game.WorldMap;
import game.objects.Item;
import game.objects.Npc;
import game.objects.Room;

import java.util.ArrayList;

public class Explore extends Command {

    private WorldMap worldMap;
    public Explore(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public String execute() {
        return exploreRoom();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String exploreRoom() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        ArrayList<Npc> npcs = currentRoom.getNpcs();
        ArrayList<Item> items = currentRoom.getItems();

        if (npcs.isEmpty() && items.isEmpty()) {
            return "V místnosti nikdo/nic není.";
        }

        System.out.println("V místnosti se nachází:");

        for (Npc npc : npcs) {
            System.out.println("- " + npc);
        }

        for (Item item : items) {
            System.out.println("- " + item);
        }

        return "";
    }
}