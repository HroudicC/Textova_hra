package game;

import game.commands.*;
import game.objects.Inventory;
import game.objects.ItemUsageRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy = new HashMap<>();
    private ArrayList<String> commands = new ArrayList<>();

    private void provedPrikaz() {
        System.out.print("Zadej příkaz \n >> ");
        String prikaz = scanner.nextLine();
        commands.add(prikaz);

        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
        } else {
            System.out.println("Neplatný příkaz.");
        }
    }

    public void start() {
        System.out.println("Nacházíš se ve své cele.");
        inicializace();
        do {
            provedPrikaz();
        } while (!exit);
    }

    private void inicializace() {
        WorldMap worldMap = new WorldMap();
        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
        ItemUsageRules.inicializace();
        Inventory inventory = new Inventory();
        ItemUsageRules itemUsageRules = new ItemUsageRules(worldMap, inventory);
        prikazy.put("jdi", new Movement(worldMap, scanner));
        prikazy.put("pruzkum", new Explore(worldMap));
        prikazy.put("vzit", new Take(worldMap, inventory, scanner));
        prikazy.put("konec", new Exit());
        prikazy.put("inventar", new OpenInventory(inventory));
        prikazy.put("promluvit", new Interact(inventory, worldMap, scanner));
        prikazy.put("pouzit", new Use(inventory, scanner, worldMap, itemUsageRules));
        prikazy.put("pomoc", new Help(this));
    }

    public HashMap<String, Command> getPrikazy() {
        return prikazy;
    }

    public void setPrikazy(HashMap<String, Command> prikazy) {
        this.prikazy = prikazy;
    }
}
