import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy = new HashMap<>();
    private ArrayList<String> commands = new ArrayList<>();

    private void provedPrikaz() {
        System.out.print(">> ");
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
        inicializace();
        do {
            provedPrikaz();
        } while (!exit);
    }

    private void inicializace() {
        WorldMap worldMap = new WorldMap();
        worldMap.loadMap();
        prikazy.put("jdi", new Movement(worldMap, scanner));
    }
}
