package pos;

import java.util.ArrayList;
import models.OrderDetail;

public class StateManager {

  private static ArrayList<OrderDetail> orderedItems;

  public static ArrayList<OrderDetail> getOrderedItems() {
    return orderedItems;
  }

  public static OrderDetail getOrderedItem(int index) {
    if (orderedItems != null && !orderedItems.isEmpty()) {
      return orderedItems.get(index);
    } else {
      return null;
    }
  }

  public static void setOrderedItem(OrderDetail orderDetail) {
    if (orderedItems == null) {
      orderedItems = new ArrayList<>();
    }
    orderedItems.add(orderDetail);
  }

  public static void setOrderedItem(OrderDetail orderDetail, int index) {
    orderedItems.set(index, orderDetail);
  }

  public static void removeOrderedItem(int index) {
    orderedItems.remove(index);
  }

  public static void reset() {
    orderedItems = null;
  }

}
