package game.commands;

import game.WorldMap;
import game.objects.Inventory;
import game.objects.Item;
import game.objects.Room;

import java.util.Scanner;

/**
 * Represents a command that allows the player to take an item from the current room.
 */
public class Take extends Command {

    private WorldMap worldMap;
    private Inventory inventory;
    private Scanner scanner;

    public Take(WorldMap worldMap, Inventory inventory, Scanner scanner) {
        this.worldMap = worldMap;
        this.inventory = inventory;
        this.scanner = scanner;
    }

    /**
     * Executes the take command, allowing the player to pick up an item from the current room.
     * @return  A message indicating whether the item was successfully taken or not.
     */
    @Override
    public String execute() {
        return takeItem();
    }

    @Override
    public boolean exit() {
        return false;
    }


    /**
     * Handles the logic for taking an item from the current room.
     * @return A message describing the outcome of the action.
     */
    public String takeItem(){
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());

        if (currentRoom.getItems().isEmpty()) {
            return "V místnosti není žádný předmět k sebrání.";
        }

        System.out.print("Jaký předmět chceš vzít? \n > ");
        String itemName = scanner.nextLine().trim();

        Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            inventory.addItem(item);
            return "Sebral jsi: " + item.getItemName();
        } else {
            return "Tento předmět zde není.";
        }
    }
}
