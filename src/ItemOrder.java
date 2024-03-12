public class ItemOrder {

    private Item item;
    private int itemAmount;

    public ItemOrder (Item userItem, int userItemAmount) {
        item = userItem;
        itemAmount = userItemAmount;
    }
    public Item getItem() {
        return item;
    }
    public int getItemAmount() {
        return itemAmount;
    }
}



