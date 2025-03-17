package game.objects;

import java.util.ArrayList;

public class Inventory{


    public ArrayList<Item> items = new ArrayList<>();

        public boolean addItem(Item item) {

            if (items.contains(item)) {
                return false;
            }
            items.add(item);
            return true;
        }

        public boolean removeItem(String itemName) {
            for (Item item : items) {
                if (item.getItemName().equalsIgnoreCase(itemName)) {
                    items.remove(item);
                    System.out.println("Odebrán předmět z inventáře: " + item.getItemName()); // Debug
                    return true;
                }
            }
            System.out.println("Předmět nebyl nalezen v inventáři: " + itemName); // Debug
            return false;
        }

        public ArrayList<Item> getItems() {

            return items;
        }

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
