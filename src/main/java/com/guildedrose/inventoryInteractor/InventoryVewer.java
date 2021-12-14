package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface InventoryVewer {
    ArrayList<Item> GetInventory();
    ArrayList<Item> GetInventoryByQuantity();
}
