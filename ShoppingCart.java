
import java.util.ArrayList;
public class ShoppingCart {
    private ArrayList<ItemOrder> list;
    private ItemOrder useritemOrder;
    public ShoppingCart(ArrayList<ItemOrder> userArrayList) {
        list = userArrayList;
    }
    public void addItemOrder(ItemOrder userItemOrder) {
        list.add(userItemOrder);
    }
    public void removeItemOrder(ItemOrder userItemOrder) {
        list.remove(userItemOrder);
    }
    //could be used to search for an item order in the shopping cart, but isn't needed in the GUI application
    public void SearchForItemOrder(ItemOrder userItemOrder) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(userItemOrder)) {
                System.out.println("Item order at position " + i);
            }
        }
    }
    public ArrayList<ItemOrder> getArrayList() {
        return list;
    }
}

