package game.commands.test;

import game.commands.Movement;
import game.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    private WorldMap worldMap;
    private Movement movement;

    @BeforeEach
    void setUp() {
        worldMap = new WorldMap();

        worldMap.loadMap();
        worldMap.loadNPC();
        worldMap.loadItems();
    }

    @Test
    void testMoveToUnlockedRoom() {

        worldMap.setCurrentPosition(7);

        Scanner testScanner = new Scanner("5\n");
        movement = new Movement(worldMap, testScanner);
        movement.execute();

        assertEquals(5, worldMap.getCurrentPosition());
    }


    @Test
    void testMoveToLockedRoom() {

        worldMap.setCurrentPosition(7);

        Scanner testScanner = new Scanner("4\n");
        movement = new Movement(worldMap, testScanner);
        movement.execute();

        assertEquals(7, worldMap.getCurrentPosition());
    }

    @Test
    void testMoveWithInvalidInput() {

        worldMap.setCurrentPosition(1);

        Scanner testScanner = new Scanner("invalid\n");
        movement = new Movement(worldMap, testScanner);
        movement.execute();

        assertEquals(1, worldMap.getCurrentPosition());
    }



}


