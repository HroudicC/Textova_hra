package game.commands;

import game.WorldMap;
import game.objects.Item;
import game.objects.Npc;
import game.objects.Room;

import java.util.ArrayList;

/**
 * Represents the command that allows the player to explore the current room.
 * Explore means displays all Npcs and items that are in a current room.
 */
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

    /**
     * Explores the current room and displays any NPCs or items found within.
     * @return A formatted string of Npcs and items for current room or a message if the room is empty.
     */
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