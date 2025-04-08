package game.commands.test;

import game.commands.Movement;
import game.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Movement command.
 */
class MovementTest {

    private WorldMap worldMap;
    private Movement movement;

    /**
     * Sets up the test environment before each test.
     * Initializes the world and loads the map, NPCs, and items.
     */
    @BeforeEach
    void setUp() {
        worldMap = new WorldMap();

        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
    }

    /**
     * Tests movement to an unlocked room.
     * Expects the player to successfully move to the target room.
     * ChatGPT helped me with this first test, and then I did the rest by myself.
     */
    @Test
    void testMoveToUnlockedRoom() {

        worldMap.setCurrentPosition(7);

        Scanner testScanner = new Scanner("5\n");
        movement = new Movement(worldMap, testScanner);
        movement.execute();

        assertEquals(5, worldMap.getCurrentPosition());
    }

    /**
     * Tests movement to a locked room.
     * Expects the player to remain in the current room.
     */
    @Test
    void testMoveToLockedRoom() {

        worldMap.setCurrentPosition(7);

        Scanner testScanner = new Scanner("4\n");
        movement = new Movement(worldMap, testScanner);
        movement.execute();

        assertEquals(7, worldMap.getCurrentPosition());
    }

    /**
     * Tests movement with invalid input.
     * Expects the player to remain in the current room.
     */
    @Test
    void testMoveWithInvalidInput() {

        worldMap.setCurrentPosition(1);

        Scanner testScanner = new Scanner("invalid\n");
        movement = new Movement(worldMap, testScanner);
        movement.execute();

        assertEquals(1, worldMap.getCurrentPosition());
    }



}


