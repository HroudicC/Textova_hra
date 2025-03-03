import java.util.Scanner;

public class Movement extends Command {

    private WorldMap worldMap;
    private Scanner scanner;

    public Movement(WorldMap worldMap, Scanner scanner) {
        this.worldMap = worldMap;
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        move();
        return  "";
    }

    @Override
    public boolean exit() {
        return false;
    }


    private void move() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());

        System.out.println("Právě se nacházíš v: " + currentRoom.getLocationName() + "\nMůžeš jít do:");

        for (int roomId : currentRoom.getAvailableRooms()) {
            Room availableRoom = worldMap.getWorld().get(roomId);
            System.out.println(roomId + " - " + availableRoom.getLocationName());
        }

        System.out.print("Zadej číslo místnosti:\n>> ");
        String input = scanner.nextLine();

        if (!input.matches("\\d+")) {
            System.out.println("Neplatný vstup! Zkus to znovu.");
            return;
        }

        int targetRoomId = Integer.parseInt(input);
        if (!currentRoom.getAvailableRooms().contains(targetRoomId)) {
            System.out.println("Tam nemůžeš jít! Zkus to znovu.");
            return;
        }

        worldMap.setCurrentPosition(targetRoomId);
        System.out.println("Přesunul ses do: " + worldMap.getWorld().get(targetRoomId).getLocationName());
    }

}
