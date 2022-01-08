package com.guildedrose.inventoryInteractor;

import com.guildedrose.items.Item;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryInteractor implements InventoryUpdater, InventoryViewer {
    private ItemsRepository itemsRepository;

    public InventoryInteractor(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void UpdateInventory() {
        ArrayList<Item> items = this.itemsRepository.GetInventoryRepository();
        for(Item item : items){
            item.update();
        }
        this.itemsRepository.SaveInventoryRepository(items);
    }

    @Override
    public ArrayList<Item> GetInventory() {
        return itemsRepository.GetInventoryRepository();
    }

    @Override
    public Stream<Map.Entry<String, Long>> getInventoryByQuantity() {
        ArrayList<Item> items = itemsRepository.GetInventoryRepository();
        Stream<Map.Entry<String, Long>> itemsSorted = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return itemsSorted;
    }

    @Override
    public void SaveInventory(ArrayList<Item> items) {
        itemsRepository.SaveInventoryRepository(items);
    }


}
