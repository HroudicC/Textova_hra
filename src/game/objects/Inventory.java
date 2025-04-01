package game.objects;

import java.util.ArrayList;

/**
 * Represents an inventory system that stores and manages items.
 */
public class Inventory{


    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Adds an item to the inventory if it is not already present.
     * @param item The item to be added.
     * @return true if the item was added, false if it was already present.
     */
        public boolean addItem(Item item) {
            if (items.contains(item)) {
                return false;
            }
            items.add(item);
            return true;
        }

    /**
     * Removes an item from the inventory by it is name.
     * @param itemName The name of the item to remove.
     * @return true if the item was removed, false it the player does not have the item.
     */
    public boolean removeItem(String itemName) {
            for (Item item : items) {
                if (item.getItemName().equalsIgnoreCase(itemName)) {
                    items.remove(item);
                    return true;
                }
            }
            System.out.println("Tento předmět nemáš v inventáři.");
            return false;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

    /**
     * Checks if the player has an item (if an item is in the inventory).
     * @param itemName The name of the item to check.
     * @return true if the item is in the inventory.
     */
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventář {" +
                 items +
                '}';
    }
}
