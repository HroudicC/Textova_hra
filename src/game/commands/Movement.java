package game.commands;

import game.objects.Room;
import game.WorldMap;

import java.util.Scanner;

/**
 * Represents a command that allows the player to move between rooms.
 */
public class Movement extends Command {

    private WorldMap worldMap;
    private Scanner scanner;

    public Movement(WorldMap worldMap, Scanner scanner) {
        this.worldMap = worldMap;
        this.scanner = scanner;
    }

    /**
     * Executes the movement command, prompting the player to move to a connected room.
     * @return A message indicating the result of the movement attempt.
     */
    @Override
    public String execute() {
        return  move();
    }

    @Override
    public boolean exit() {
        return false;
    }


    /**
     * Handles the logic for moving between rooms, checking for valid inputs
     * and whether the target room is accessible.
     * @return A message indicating success or failure of the movement attempt.
     */
    private String move() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());

        System.out.println("Právě se nacházíš v: " + currentRoom.getLocationName() + "\nMůžeš jít do:");

        for (int roomId : currentRoom.getAvailableRooms()) {
            Room availableRoom = worldMap.getWorld().get(roomId);
            System.out.println(roomId + " - " + availableRoom.getLocationName() );
        }

        System.out.print("Zadej číslo místnosti: \n > ");
        String input = scanner.nextLine();

        if (!input.matches("\\d+")) {
            return "Neplatný vstup!";
        }

        int targetRoomId = Integer.parseInt(input);
        Room targetRoom = worldMap.getWorld().get(targetRoomId);

        if (targetRoom.isLocked()) {
            return "Tato místnost je zamčena a nemůžeš do ní vstoupit.";
        }

        if (!currentRoom.getAvailableRooms().contains(targetRoomId)) {
            return "Tam jít nemůžeš!";
        }

        worldMap.setCurrentPosition(targetRoomId);
        return "Přesunul ses do: " + targetRoom.getLocationName();
    }


}
