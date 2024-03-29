package com.guildedrose.repositories;

import com.guildedrose.inventoryInteractor.ItemsRepository;
import com.guildedrose.items.*;
import java.util.ArrayList;

public class InMemoryItemsRepository implements ItemsRepository {

    ArrayList<Item> items = new ArrayList<>();

    public InMemoryItemsRepository(){
        items.add(new Aged(1,"Aged Brie",15,7, 8000));
        items.add(new Conjured(2,"Conjured Item",8,22, 5000));
        items.add(new Legendary(3,"Sulfuras",0,10, 1000));
        items.add(new Generic(4,"Item normal",15,33, 10000));
        items.add(new Event(5,"Backstage passes",23,4,15000));
        items.add(new Aged(6,"Aged Brie",15,7, 8000));
        items.add(new Event(7,"Backstage passes",23,4,15000));
        items.add(new Conjured(8,"Conjured Item",8,22, 5000));
        items.add(new Legendary(9,"Sulfuras",0,10, 1000));
        items.add(new Aged(10,"Aged Brie",15,7, 8000));
        items.add(new Event(11,"Backstage passes",23,4,15000));
        items.add(new Event(12,"Backstage passes",23,4,15000));
        items.add(new Legendary(13,"Sulfuras",0,10, 1000));
        items.add(new Relic(14,"La canne", 0, 10000));
    }

    @Override
    public ArrayList<Item> GetInventoryRepository() {
        return items;
    }

    @Override
    public void SaveInventoryRepository(ArrayList<Item> items) {
        this.items = items;
    }
}
