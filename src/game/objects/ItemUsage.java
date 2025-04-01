package game.objects;

/**
 * Represents an item usage rule, defining which item can be used in which room.
 */
public class ItemUsage {

    private String itemName;
    private int roomId;

    public ItemUsage(String itemName, int roomId) {
        this.itemName = itemName;
        this.roomId = roomId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


}
