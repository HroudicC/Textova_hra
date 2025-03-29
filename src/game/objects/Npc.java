package game.objects;

import java.util.HashMap;

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

    public void addTradeItem(String requiredItem, String offeredItem) {
        tradeItems.put(requiredItem.trim().toLowerCase(), offeredItem.trim().toLowerCase());
    }

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
