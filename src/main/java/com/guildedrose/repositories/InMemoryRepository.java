package com.guildedrose.repositories;

import com.guildedrose.inventoryInteractor.InventoryRepository;
import com.guildedrose.items.Item;
import com.guildedrose.items.*;

import java.util.ArrayList;

public class InMemoryRepository implements InventoryRepository {

    ArrayList<Item> items = new ArrayList<>();

    public InMemoryRepository(){
        items.add(new Aged(0,"Aged Item",15,7, 8000));
        items.add(new Conjured(1,"Conjured Item",8,22, 5000));
        items.add(new Legendary(2,"Sulfuras",0,10, 1000));
        items.add(new Generic(3,"Item normal",15,33, 10000));
        items.add(new Event(4,"Backstage passes",23,4,15000));
    }

    @Override
    public ArrayList<Item> getInventory() {
        return items;
    }

    @Override
    public void saveInventory(ArrayList<Item> items) {
        this.items = items;
    }
}
