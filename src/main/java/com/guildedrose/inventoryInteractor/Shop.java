package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;
import com.guildedrose.repositories.ItemsRepository;

import java.util.ArrayList;

public class Shop implements InventoryUpdater, InventoryViewer {
    private ItemsRepository repository;

    public Shop(ItemsRepository repository){
        this.repository = repository;
    }

    @Override
    public void UpdateQuality() {
        ArrayList<Item> items = repository.getInventory();

        for(Item item : items){
            item.update();
        }

        repository.saveInventory(items);
    }

    @Override
    public ArrayList<Item> GetInventory(){
        return repository.getInventory();
    }

    @Override
    public ArrayList<Item> GetInventoryByQuantity() {
        return null;
    }
}
