package com.guildedrose;

import com.guildedrose.repositories.FileItemsRepository;
import com.guildedrose.inventoryInteractor.Shop;

public class App {

    public static void main(String[] args) {

        Shop shop = new Shop(new FileItemsRepository());
        shop.UpdateQuality();
    }

}

