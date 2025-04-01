package game.objects;

import java.util.HashMap;

/**
 * Represents a Character (NPC) in the game.
 * Npcs can trade items with the player.
 */
public class Npc {

    private String name;
    private HashMap<String,String> tradeItems = new HashMap<>();

    public Npc(String name, HashMap<String, String> tradeItems) {
        this.name = name;
        this.tradeItems = tradeItems;
    }

    public Npc(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a trade item to the Npc's inventory.
     * @param requiredItem The item the NPC requires from the player.
     * @param offeredItem The item the NPC offers in return.
     */
    public void addTradeItem(String requiredItem, String offeredItem) {
        tradeItems.put(requiredItem.trim().toLowerCase(), offeredItem.trim().toLowerCase());
    }

    /**
     * Get the item that the NPC offers in exchange for a given required item.
     * @param requiredItem The item that the player wants to trade with the NPC.
     * @return The item the NPC offers in return.
     */
    public String getOfferedItem(String requiredItem) {
        return tradeItems.get(requiredItem.trim().toLowerCase());
    }


    public HashMap<String, String> getTradeItems() {
        return tradeItems;
    }

    @Override
    public String toString() {
        return name;
    }
}
