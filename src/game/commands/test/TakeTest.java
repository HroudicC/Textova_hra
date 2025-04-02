package game.commands.test;

import game.WorldMap;
import game.commands.Take;
import game.objects.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Take command.
 */
class TakeTest {

    private WorldMap worldMap;
    private Inventory inventory;
    private Take take;

    /**
     * Sets up the test environment before each test.
     * Initializes the world and loads the map, NPCs, and items.
     */
    @BeforeEach
    void setUp() {
        worldMap = new WorldMap();
        inventory = new Inventory();

        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
    }

    /**
     * Tests successfully picking up an item from a room.
     * Expects the item to be added to the player's inventory.
     */
    @Test
    void testTakeItemSuccess() {

        worldMap.setCurrentPosition(6);

        Scanner testScanner = new Scanner("Mince\n");
        take = new Take(worldMap, inventory, testScanner);

        String result = take.execute();

        assertEquals("Sebral jsi: Mince", result);
        assertTrue(inventory.hasItem("Mince"));
    }

    /**
     * Tests attempting to pick up an item in an empty room.
     * Expects a matching message that no items are available.
     */
    @Test
    void testTakeItemInEmptyRoom() {

        worldMap.setCurrentPosition(7);

        Scanner testScanner = new Scanner("Sroubovak\n");
        take = new Take(worldMap, inventory, testScanner);

        String result = take.execute();
        assertEquals("V místnosti není žádný předmět k sebrání.", result);
    }

    /**
     * Tests attempting to pick up an item that is not present in the room.
     * Expects a corresponding message that the item is not available.
     */
    @Test
    void testTakeWrongItem() {

        worldMap.setCurrentPosition(6);

        Scanner testScanner = new Scanner("Sroubovak\n");
        take = new Take(worldMap, inventory, testScanner);

        String result = take.execute();

        assertEquals("Tento předmět zde není.", result);
    }
}
