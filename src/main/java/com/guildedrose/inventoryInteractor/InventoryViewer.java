package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

public interface InventoryViewer {
    ArrayList<Item> GetInventory();
    Stream<Map.Entry<String, Long>> getInventoryByQuantity();
}
