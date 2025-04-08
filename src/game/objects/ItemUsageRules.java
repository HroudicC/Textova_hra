package game.objects;


import game.WorldMap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that defines the rules for using items in specific rooms.
 * Handles unlocking rooms and achieving different endings.
 */
public class ItemUsageRules {

    public static ArrayList<ItemUsage> itemUsages = new ArrayList<>();
    private WorldMap worldMap;
    private Scanner scanner;
    private Inventory inventory;
    private boolean isTileRemoved = false; //Because of the condition to use the item


    public ItemUsageRules(WorldMap worldMap, Inventory inventory, Scanner scanner) {
        this.worldMap = worldMap;
        this.inventory = inventory;
        this.scanner = scanner;
    }

    /**
     * Initializes the items and the rooms in which they are used.
     */
    public static void initializeItems(){
        itemUsages.add(new ItemUsage("Lzice", 1));
        itemUsages.add(new ItemUsage("Drat", 7));
        itemUsages.add(new ItemUsage("Sroubovak", 4));
        itemUsages.add(new ItemUsage("Kapesni nozik", 1));

    }

    /**
     * Applies the item usage rules based on the given item name and the player's current room.
     * ChatGPT helped me with the ending that starts on line 77.
     * @param itemName The name of the item the player wants to use.
     * @param roomId ID of the current room where the player is in.
     * @return A message indicating the result of the action and (if the game has been completed) ending the program.
     */
    public String applyItemUsageRules(String itemName, int roomId) {

        // Condition for using the 'drat' to unlock the guard's room.
        if (itemName.equalsIgnoreCase("Drat") && roomId == 7) {
            System.out.println("Zadejte místnost k odemčení:");
        try {
            String input = scanner.nextLine().trim();
            int roomToUnlock = Integer.parseInt(input);
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
        }catch (NumberFormatException e){
            return "Neplatné číslo místnosti.";
            }
        }

        // Condition for using the 'Sroubovak' (Ending 1).
        if (itemName.equalsIgnoreCase("Sroubovak") && roomId == 4) {
            System.out.println("Podařilo se ti nepozorovaně proklouznout do místnosti pro stráže. Opatrně jsi vyšrouboval mříž ventilace a protáhl ses úzkým tunelem ven. \n" +
                    "GRATULACE! Úspěšně jsi unikl z vězení! (Ending 1)");
            System.exit(0);
        }


        // Condition for using the 'kapesni nozik' and 'lzice' (Ending 2).
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
