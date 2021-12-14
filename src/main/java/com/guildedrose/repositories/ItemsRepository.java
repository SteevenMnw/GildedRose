package com.guildedrose.repositories;

import com.guildedrose.entities.Item;

import java.util.ArrayList;

public interface ItemsRepository {
    ArrayList<Item> getInventory();

    void saveInventory(ArrayList<Item> items);
}
