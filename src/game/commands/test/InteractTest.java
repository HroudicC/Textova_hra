package game.commands.test;

import game.WorldMap;
import game.commands.Interact;
import game.objects.Inventory;
import game.objects.Npc;
import game.objects.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * Test class for the Interact command.
 */
class InteractTest {

    private Inventory inventory;
    private WorldMap worldMap;
    private Interact interact;

    /**
     * Sets up the test environment before each test.
     * Initializes inventory, world, and loads the map, NPCs, and items.
     */
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        worldMap = new WorldMap();

        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
    }

    /**
     * Tests interaction in a room with no NPCs.
     * Expects a message indicating the absence of people in the room.
     */
    @Test
    void testInteractWithNoNpcInRoom() {

        worldMap.setCurrentPosition(1);

        interact = new Interact(inventory, worldMap, new Scanner(System.in));

        String result = interact.execute();

        assertEquals("V místnosti se nenachází žádná osoba.", result);
    }

    /**
     * Tests interaction with an NPC that has no trade offers.
     * Creates a new npc without trade and expects a report of lack of trading offers.
     */
    @Test
    void testInteractWithNpcNoTrade() {

        Room currentRoom = worldMap.getWorld().get(1);
        Npc npc = new Npc("TestNPC", new HashMap<>());

        worldMap.setCurrentPosition(1);
        currentRoom.addNpc(npc);

        Scanner testScanner = new Scanner("TestNPC\n");

        Interact interact = new Interact(inventory, worldMap, testScanner);
        String result = interact.execute();

        assertEquals("TestNPC nemá žádné obchodní nabídky.", result);
    }


}
