package game;

import game.objects.Item;
import game.objects.Npc;
import game.objects.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldMap {

    HashMap<Integer, Room> world = new HashMap<>();
    private int start = 1;
    private int currentPosition = start;


    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/game/files/map"))) {
            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if (lineCounter == 1) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean loadNPC() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/game/files/characters"))) {
            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if (lineCounter == 1) {
                    continue;
                }
                String[] split = line.split(";");

                int roomId = Integer.parseInt(split[0]);
                String npcName = split[1];

                Room room = world.get(roomId);
                if (room != null) {
                    Npc npc = new Npc();
                    npc.setName(npcName);
                    room.addNpc(npc);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadItems() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/game/files/items"))) {
            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if (lineCounter == 1) {
                    continue;
                }

                String[] split = line.split(";");
                int roomId = Integer.parseInt(split[0]);
                String itemName = split[1];

                Room room = world.get(roomId);
                if (room != null) {
                    Item item = new Item();
                    item.setItemName(itemName);
                    room.addItem(item);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public HashMap<Integer, Room> getWorld() {
        return world;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}