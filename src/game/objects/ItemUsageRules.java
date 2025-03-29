package game.objects;


import game.WorldMap;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemUsageRules {

    public static ArrayList<ItemUsage> itemUsages = new ArrayList<>();
    WorldMap worldMap;
    Scanner scanner = new Scanner(System.in);
    Inventory inventory;
    private boolean isTileRemoved = false; //Kvuli podmince k pouziti predmetu

    public ItemUsageRules(WorldMap worldMap, Inventory inventory) {
        this.worldMap = worldMap;
        this.inventory = inventory;

    }

    public static void inicializace(){
        itemUsages.add(new ItemUsage("Lzice", 1));
        itemUsages.add(new ItemUsage("Drat", 7));
        itemUsages.add(new ItemUsage("Sroubovak", 4));
        itemUsages.add(new ItemUsage("Kapesni nozik", 1));

    }

    public String applyItemUsageRules(String itemName, int roomId) {

        //Podminka pro pouziti dratu k odemceni mistnosti pro straze.
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

        //Podminka pro pouziti Sroubovaku (ending 1).
        if (itemName.equalsIgnoreCase("Sroubovak") && roomId == 4) {
            System.out.println("Podařilo se ti nepozorovaně proklouznout do místnosti pro stráže. Opatrně jsi vyšrouboval mříž ventilace a protáhl ses úzkým tunelem ven. \n" +
                    "GRATULACE! Úspěšně jsi unikl z vězení! (Ending 1)");
            System.exit(0);
        }


        //Podminka pro pouziti Kapesniho noziku + Lzice (ending 2).
        if (itemName.equalsIgnoreCase("Kapesni nozik") && roomId == 1) {
            if (!isTileRemoved) {
                isTileRemoved = true;
                inventory.removeItem(itemName);
                return "Uvolnil jsi dlaždici v hlavní cele. Teď můžeš použít lžíci k vykopání tunelu.";
            } else {
                return "Dlaždice už je uvolněná, teď potřebuješ jen lžíci!";
            }
        } else if (itemName.equalsIgnoreCase("Lzice")) {
            if (!isTileRemoved) {
                return "Nemůžeš kopat do dlaždic. Možná bys je měl nejdřív nějak uvolnit?";
            } else {
                System.out.println("Vyhrabal jsi tunel a utekl! GRATULACE (Ending 2).");
                System.exit(0);
            }
        }


        return "Tento předmět nemůžeš použít v této místnosti.";
    }

}
