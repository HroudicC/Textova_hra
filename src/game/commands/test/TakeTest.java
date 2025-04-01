package game.commands.test;

import game.WorldMap;
import game.commands.Take;
import game.objects.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TakeTest {

    private WorldMap worldMap;
    private Inventory inventory;
    private Take take;

    @BeforeEach
    void setUp() {
        worldMap = new WorldMap();
        inventory = new Inventory();

        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
    }


    @Test
    void testTakeItemSuccess() {

        worldMap.setCurrentPosition(6);

        Scanner testScanner = new Scanner("Mince\n");
        take = new Take(worldMap, inventory, testScanner);

        String result = take.execute();

        assertEquals("Sebral jsi: Mince", result);
        assertTrue(inventory.hasItem("Mince"));
    }

    @Test
    void testTakeItemInEmptyRoom() {

        worldMap.setCurrentPosition(7);

        Scanner testScanner = new Scanner("Sroubovak\n");
        take = new Take(worldMap, inventory, testScanner);

        String result = take.execute();
        assertEquals("V místnosti není žádný předmět k sebrání.", result);
    }

    @Test
    void testTakeWrongItem() {

        worldMap.setCurrentPosition(6);

        Scanner testScanner = new Scanner("Sroubovak\n");
        take = new Take(worldMap, inventory, testScanner);

        String result = take.execute();

        assertEquals("Tento předmět zde není.", result);
    }
}
