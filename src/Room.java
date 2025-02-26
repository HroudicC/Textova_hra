import java.util.ArrayList;

public class Room {

    private int id;
    private String locationName;
    private ArrayList<Integer> availableRooms;

    public Room(int id, String locationName, ArrayList<Integer> availableRooms) {
        this.id = id;
        this.locationName = locationName;
        this.availableRooms = availableRooms;
    }

    public int getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public ArrayList<Integer> getAvailableRooms() {
        return availableRooms;
    }
}
