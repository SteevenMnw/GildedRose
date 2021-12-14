package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface InventoryRepository {
    ArrayList<Item> GetInventoryRepository();

    void SaveInventoryRepository(ArrayList<Item> items);
}
