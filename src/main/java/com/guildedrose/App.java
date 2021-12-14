package com.guildedrose;

import com.guildedrose.entities.Item;
import com.guildedrose.inventoryInteractor.InventoryViewer;
import com.guildedrose.repositories.FileItemsRepository;
import com.guildedrose.inventoryInteractor.Shop;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        InventoryViewer viewer = new Shop(new FileItemsRepository());
        ArrayList<Item> items = viewer.GetInventory();

        for(Item item: items){
            System.out.println(item.getNom());
        }
    }

}

