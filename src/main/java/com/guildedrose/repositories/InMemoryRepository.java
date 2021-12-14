package com.guildedrose.repositories;

import com.guildedrose.TestBufferedReader;
import com.guildedrose.TestBufferedWriter;
import com.guildedrose.entities.Item;
import com.guildedrose.items.*;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements IInventoryRepository{

    ArrayList<Item> items = new ArrayList<>();

    public InMemoryRepository(){
        /*TestBufferedReader read = new TestBufferedReader("inventory.txt");
        ArrayList test = read.lecture();*/

        items.add(new Aged("Aged Item",15,7));
        items.add(new Conjured("Conjured Item",8,22));
        items.add(new Legendary("Sulfuras",0,10));
        items.add(new Generic("Item normal",15,33));
        items.add(new Event("Backstage passes",23,4));
    }

    @Override
    public ArrayList<Item> getInventory() {
        return items;
    }

    @Override
    public void saveInventory(ArrayList<Item> items) {
        TestBufferedWriter write = new TestBufferedWriter("inventory.txt");
        write.traitement(items);
    }
}
