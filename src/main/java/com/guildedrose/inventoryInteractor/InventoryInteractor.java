package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;
import java.util.ArrayList;

public class InventoryInteractor implements InventoryUpdater, InventoryViewer {
    private ItemsRepository itemsRepository;

    public InventoryInteractor(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void UpdateQuality() {
        ArrayList<Item> items = this.itemsRepository.GetInventoryRepository();
        for(Item item : items){
            item.update();
        }
        this.itemsRepository.SaveInventoryRepository(items);
    }

    @Override
    public ArrayList<Item> GetInventoryViewer() {
        return itemsRepository.GetInventoryRepository();
    }

    @Override
    public ArrayList<Item> GetInventoryByQuantity() {
        ArrayList<Item> items = this.itemsRepository.GetInventoryRepository();
        Item itemtmp = null;
        for (Item item:items) {
            //if (items[i] === item.getClass());
        }
        return items;
    }
}
