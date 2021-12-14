package com.guildedrose.repositories;

import com.guildedrose.entities.Item;

import java.util.ArrayList;

public interface IInventoryRepository {
    ArrayList<Item> getInventory();

    void saveInventory(ArrayList<Item> items);
}
