package game.objects;

public class Item {

  private String itemName;


 public String getItemName() {
  return itemName;
 }

 public void setItemName(String itemName) {
  this.itemName = itemName;
 }


 @Override
 public String toString() {
  return itemName;
 }
}
