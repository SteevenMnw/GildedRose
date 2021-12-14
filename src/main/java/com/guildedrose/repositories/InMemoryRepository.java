package com.guildedrose.repositories;

import com.guildedrose.entities.Item;
import com.guildedrose.items.*;

import java.util.ArrayList;

public class InMemoryRepository implements ItemsRepository {

    ArrayList<Item> items = new ArrayList<>();

    public InMemoryRepository(){
        /*TestBufferedReader read = new TestBufferedReader("inventory.txt");
        ArrayList test = read.lecture();

        if(test.toString() != null){
            System.out.println(test.toString());
        }*/
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
        this.items = items;
    }
}
