package com.guildedrose.inventoryInteractor;

import com.guildedrose.entities.Item;

import java.util.ArrayList;

public interface InventoryVewer {
    ArrayList<Item> GetInventory();
    ArrayList<Item> GetInventoryByQuantity();
}
