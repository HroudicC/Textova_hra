package game.objects;

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

 public void setItemName(String itemName) {
  this.itemName = itemName;
 }

 public String getHolder() {
  return holder;
 }

 public void setHolder(String holder) {
  this.holder = holder;
 }

 public String getRequiredItem() {
  return requiredItem;
 }

 public void setRequiredItem(String requiredItem) {
  this.requiredItem = requiredItem;
 }

 @Override
 public String toString() {
  return itemName;
 }
}
