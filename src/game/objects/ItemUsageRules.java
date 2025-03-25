package game.objects;


import game.WorldMap;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemUsageRules {

    public static ArrayList<ItemUsage> itemUsages = new ArrayList<>();

    WorldMap worldMap;
    Scanner scanner = new Scanner(System.in);
    Inventory inventory;

    public ItemUsageRules(WorldMap worldMap, Inventory inventory) {
        this.worldMap = worldMap;
        this.inventory = inventory;

    }

    public static void inicializace(){
        itemUsages.add(new ItemUsage("Lzice", 1, "Kopani diry"));
        itemUsages.add(new ItemUsage("Kapesni nozik", 6, "Jsem jeste nevymyslel"));
        itemUsages.add(new ItemUsage("Drat", 7, "Odemknul jsi místnost pro stráže"));
        itemUsages.add(new ItemUsage("Sroubovak", 4, "Vysrouboval jsi ventilaci a prave jsi utekl ven. Gratulace"));

    }

    public String applyItemUsageRules(String itemName, int roomId) {

        if (itemName.equalsIgnoreCase("Drat") && roomId == 7) {
            System.out.println("Zadejte místnost k odemčení:");

            int roomToUnlock = scanner.nextInt();

            if (roomToUnlock == 4) {
                Room guardRoom = worldMap.getWorld().get(4);
                if (guardRoom.isLocked()) {
                    guardRoom.setLocked(false);
                    inventory.removeItem(itemName);
                    return "Odemkl jsi místnost pro stráže pomocí drátu.";
                } else {
                    return "Místnost pro stráže není zamčená.";
                }
            }
        }

        if (itemName.equalsIgnoreCase("Sroubovak") && roomId == 4) {
            System.exit(0);
        }

        return "Tento předmět nemůžeš použít v této místnosti.";
    }






}
