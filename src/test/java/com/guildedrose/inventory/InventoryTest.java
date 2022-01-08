package com.guildedrose.inventory;

import com.guildedrose.inventoryInteractor.InventoryInteractor;
import com.guildedrose.items.*;
import com.guildedrose.repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InventoryTest {

    InventoryInteractor inventoryInteractor = new InventoryInteractor(new InMemoryItemsRepository());
    ArrayList<Item> items = new ArrayList<>();
    Stream<Map.Entry<String, Long>> itemsSorted = inventoryInteractor.getInventoryByQuantity();

    @Test
    public void testGetInventory() {
        assertNotNull(inventoryInteractor.GetInventory());
    }

    @Test
    public void testSaveInventory() {
        Event goldCrown = new Event("Gold Crown", 13, 20,300);
        items.add(goldCrown);
        inventoryInteractor.SaveInventory(items);
        assertEquals(inventoryInteractor.GetInventory().get(items.size() - 1), goldCrown);
    }

    @Test
    public void testGetInventoryByQuandtity() {
        Map<String, Long> itemsSortedByQuantity = new HashMap<>();
        itemsSorted.forEach((i) -> itemsSortedByQuantity.put(i.getKey(), i.getValue()));
        assertEquals(itemsSortedByQuantity.get("Backstage passes"), 4);
        assertEquals(itemsSortedByQuantity.get("Aged Brie"), 3);
        assertEquals(itemsSortedByQuantity.get("Sulfuras"), 3);
        assertEquals(itemsSortedByQuantity.get("Conjured Item"), 2);
        assertEquals(itemsSortedByQuantity.get("Item normal"), 1);
        assertEquals(itemsSortedByQuantity.get("La canne"), 1);
    }
}
