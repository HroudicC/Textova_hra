package game.commands;

import game.WorldMap;
import game.objects.Inventory;
import game.objects.Item;
import game.objects.Npc;
import game.objects.Room;

import java.util.Scanner;

public class Interact extends Command {


    Inventory inventory;
    WorldMap worldMap;
    Scanner scanner = new Scanner(System.in);

    public Interact(Inventory inventory, WorldMap worldMap) {
        this.inventory = inventory;
        this.worldMap = worldMap;
    }

    @Override
    public String execute() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());

        if (currentRoom.getNpcs().isEmpty()) {
            System.out.println("V místnosti se nenachází žádná osoba.");
            return "";
        }

        System.out.print("S kým se chceš bavit? \n > ");
        String npcNameToInteract = scanner.nextLine().trim();
        Npc selectedNpc = null;

        for (Npc npc : currentRoom.getNpcs()) {
            if (npc.getName().equalsIgnoreCase(npcNameToInteract)) {
                selectedNpc = npc;
                break;
            }
        }

        if (selectedNpc == null) {
            System.out.println("Taková osoba tady není...");
            return "";
        }

        if (selectedNpc.getTradeItems().isEmpty()) {
            System.out.println(selectedNpc.getName() + " nemá žádné obchodní nabídky.");
            return "";
        }

        System.out.println(selectedNpc.getName() + " chce vyměnit:");
        for (String offeredItemName : selectedNpc.getTradeItems().keySet()) {
            System.out.println("- " + offeredItemName + " za " + selectedNpc.getTradeItems().get(offeredItemName));
        }

        System.out.print("Co chceš nabídnout? \n > ");
        String offeredItem = scanner.nextLine().trim();

        boolean itemFoundInTrade = false;
        for (String item : selectedNpc.getTradeItems().keySet()) {
            if (item.equalsIgnoreCase(offeredItem)) {
                itemFoundInTrade = true;
                break;
            }
        }

        if (itemFoundInTrade && inventory.hasItem(offeredItem)) {
            String receivedItem = selectedNpc.getOfferedItem(offeredItem);
            System.out.println("Vyměnil jsi " + offeredItem + " za " + receivedItem);

            inventory.removeItem(offeredItem);
            inventory.addItem(new Item(receivedItem, "Npc", offeredItem));
        } else {
            System.out.println("Nemáš požadovaný předmět nebo NPC tuto výměnu nenabízí.");
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
