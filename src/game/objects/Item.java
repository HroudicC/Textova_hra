package game.objects;

/**
 * Represents an item in the game. Each item has a name, a holder (who has it or if it is in room),
 * and a required item needed for trade or interaction (if needed).
 */
public class Item {

  private String itemName;
  private String holder;
  private String requiredItem;

 public Item(String itemName, String holder, String requiredItem) {
  this.itemName = itemName;
  this.holder = holder;
  this.requiredItem = requiredItem;
 }

 public String getItemName() {
  return itemName;
 }

 @Override
 public String toString() {
  return itemName;
 }
}
