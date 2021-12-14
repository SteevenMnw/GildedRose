package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface InventoryViewer {
    ArrayList<Item> GetInventory();
    ArrayList<Item> GetInventoryByQuantity();
}
