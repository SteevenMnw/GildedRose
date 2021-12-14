package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;
import java.util.ArrayList;

public class InventoryInteractor implements InventoryUpdater, InventoryViewer {
    private InventoryRepository inventoryRepository;

    public InventoryInteractor(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void UpdateQuality() {
        ArrayList<Item> items = this.inventoryRepository.GetInventoryRepository();
        for(Item item : items){
            item.update();
        }
        this.inventoryRepository.SaveInventoryRepository(items);
    }

    @Override
    public ArrayList<Item> GetInventoryViewer() {
        return inventoryRepository.GetInventoryRepository();
    }

    @Override
    public ArrayList<Item> GetInventoryByQuantity() {
        return null;
    }
}
