package game.commands;

import game.objects.Inventory;

/**
 * Represents a command to display the player's inventory.
 */
public class OpenInventory extends Command {

    private Inventory inventory;

    public OpenInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        return inventory.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

}
