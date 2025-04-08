package game;

import game.commands.*;
import game.objects.Inventory;
import game.objects.ItemUsageRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Represents the game console where the player interacts with the game.
 * This class manages command execution, initializes the game world,
 * and handles user input.
 */
public class Console {

    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy = new HashMap<>();
    private ArrayList<String> commands = new ArrayList<>();

    /**
     * Reads and processes a user command.
     * If the command exists in the available commands, it executes the corresponding action.
     * Otherwise, it informs the user that the command is invalid.
     */
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

    /**
     * Starts the game loop, displaying an introductory message and initializing the game world.
     * The loop continues until the player finishes the game.
     */
    public void start() {
        System.out.println("Nacházíš se v hlavní cele. Nevíš proč ani za co, takže tvým úkolem je dostat se odsud co nejrychleji pryč. \n" +
                "Pokud nevíš, co dělat, napiš příkaz 'pomoc' a zobrazí se ti všechny dostupné příkazy. Všechna slova piš bez diakritiky! Hodně štěstí...");
        inicializace();
        do {
            provedPrikaz();
        } while (!exit);
    }

    /**
     * Initializes the game world, loading the map, NPCs, and items from files.
     * It also initializes item usage rules and registers all available commands.
     */
    private void inicializace() {
        WorldMap worldMap = new WorldMap();
        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
        ItemUsageRules.initializeItems();
        Inventory inventory = new Inventory();
        ItemUsageRules itemUsageRules = new ItemUsageRules(worldMap, inventory, scanner);
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
}
