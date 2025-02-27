import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WorldMap {


    HashMap<Integer, Room> world = new HashMap<>();
    private int start = 1;
    private int currentPosition = start;


    public boolean loadMap(){

        try (BufferedReader br = new BufferedReader(new FileReader("src/Map"))) {

            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if(lineCounter == 1){
                    continue;
                }
                String[] data = line.split(";");

                int id = Integer.parseInt(data[0]);
                String name = data[1];

                ArrayList<Integer> availableRooms = new ArrayList<>();
                if (data.length > 2 && !data[2].trim().isEmpty()) {
                    String[] rooms = data[2].trim().split(" ");
                    for (String room : rooms) {
                        availableRooms.add(Integer.parseInt(room));
                    }
                }


                Room room = new Room(id, name, availableRooms);
                 world.put(id, room);

            }

            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void konzole(){

            Scanner scanner = new Scanner(System.in);

            while (true) {
                Room room = world.get(currentPosition);
                System.out.println("Právě se nacházíš v: " + room.getLocationName());
                System.out.println("Můžeš jít do místností: " + room.getAvailableRooms());
                System.out.print("Zadej číslo místnosti nebo 0 pro ukončení: ");

                int input = scanner.nextInt();

                if (input == 0) {
                    System.out.println("Hra ukončena.");
                    break;
                }

                if (room.getAvailableRooms().contains(input)) {
                    currentPosition = input; // Přesun do nové místnosti
                } else {
                    System.out.println("Tam nemůžeš jít! Zkus to znovu.");
                }
            }

    }
}