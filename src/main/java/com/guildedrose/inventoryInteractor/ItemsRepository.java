package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;

import java.util.ArrayList;

public interface ItemsRepository {
    ArrayList<Item> getInventory();

    void saveInventory(ArrayList<Item> items);
}
