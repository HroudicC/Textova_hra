package game.commands;

import game.WorldMap;
import game.objects.Inventory;
import game.objects.ItemUsageRules;

import java.util.Scanner;

/**
 * Represents a command to use an item from the inventory.
 */
public class Use extends Command {

    Inventory inventory;
    Scanner scanner;
    WorldMap worldMap;
    ItemUsageRules itemUsageRules;

    public Use(Inventory inventory, Scanner scanner, WorldMap worldMap, ItemUsageRules itemUsageRules) {
        this.inventory = inventory;
        this.scanner = scanner;
        this.worldMap = worldMap;
        this.itemUsageRules = itemUsageRules;
    }

    /**
     * Executes the use command, prompting the player to select an item from their inventory
     * and attempt to use it based on predefined item usage rules.
     * @return A message describing the outcome of the item usage attempt.
     */
    @Override
    public String execute() {
        return useItem();
    }

    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Asks the player to select an item to use.
     * @return A message describing the outcome of using the item.
     */
    public String useItem(){

        System.out.println("Jaký předmět chceš použít?");
        String itemToUse = scanner.nextLine().trim();

        if (!inventory.hasItem(itemToUse)) {
            return"Takový předmět nemáš.";
        }

        String result = itemUsageRules.applyItemUsageRules(itemToUse, worldMap.getCurrentPosition());
        return result;
    }
}
