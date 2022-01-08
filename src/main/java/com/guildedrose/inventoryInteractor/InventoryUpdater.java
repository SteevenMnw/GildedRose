package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface InventoryUpdater {
    void UpdateInventory();
    void SaveInventory(ArrayList<Item> items);
}
