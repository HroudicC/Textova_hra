package game;

import game.commands.*;
import game.objects.Inventory;

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
        Inventory inventory = new Inventory();
        prikazy.put("jdi", new Movement(worldMap, scanner));
        prikazy.put("pruzkum", new Explore(worldMap));
        prikazy.put("vzit", new Take(worldMap, inventory));
        prikazy.put("konec", new Exit());
        prikazy.put("inventar", new OpenInventory(inventory));
        prikazy.put("promluvit", new Interact(inventory, worldMap));
    }
}
