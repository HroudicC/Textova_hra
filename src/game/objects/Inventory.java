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

        public boolean removeItem(Item item) {
            if (items.contains(item)) {
                items.remove(item);
                return true;
            }
            return false;
        }

        public ArrayList<Item> getItems() {

            return items;
        }

    @Override
    public String toString() {
        return "Inventář {" +
                 items +
                '}';
    }
}
