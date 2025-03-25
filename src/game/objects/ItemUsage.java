package game.objects;

public class ItemUsage {

    private String itemName;
    private int roomId;
    private String action;

    public ItemUsage(String itemName, int roomId, String action) {
        this.itemName = itemName;
        this.roomId = roomId;
        this.action = action;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
