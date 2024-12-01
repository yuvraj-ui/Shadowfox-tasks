package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryData {
    private static List<InventoryItem> inventory = new ArrayList<>();

    public static void addItem(InventoryItem item) {
        inventory.add(item);
    }

    public static List<InventoryItem> getAllItems() {
        return new ArrayList<>(inventory); // Return a copy for safety
    }

    public static Optional<InventoryItem> findItem(String itemID) {
        return inventory.stream()
                .filter(item -> item.getItemID().equals(itemID))
                .findFirst();
    }

    public static boolean updateItem(InventoryItem updatedItem) {
        Optional<InventoryItem> existingItem = findItem(updatedItem.getItemID());
        if (existingItem.isPresent()) {
            int index = inventory.indexOf(existingItem.get());
            inventory.set(index, updatedItem);
            return true;
        } else {
            return false;
        }
    }

    public static boolean deleteItem(String itemID) {
        Optional<InventoryItem> itemToDelete = findItem(itemID);
        return itemToDelete.map(item -> inventory.remove(item)).orElse(false);
    }
}