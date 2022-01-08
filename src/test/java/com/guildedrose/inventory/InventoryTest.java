package com.guildedrose.inventory;

import com.guildedrose.items.*;
import com.guildedrose.repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class InventoryTest {

    ArrayList<Item> items = new ArrayList<>();
    InMemoryItemsRepository inMemoryItemsRepository = new InMemoryItemsRepository();


    @Test
    public void testGetInventory() {
        items.add(new Aged(1,"Aged Item",15,7, 8000));
        items.add(new Conjured(2,"Conjured Item",8,22, 5000));
        items.add(new Legendary(3,"Sulfuras",0,10, 1000));
        items.add(new Generic(4,"Item normal",15,33, 10000));
        items.add(new Event(5,"Backstage passes",23,4,15000));

        assertEquals(items, inMemoryItemsRepository.GetInventoryRepository());
    }
}
