package game.commands;

import game.objects.Inventory;

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
