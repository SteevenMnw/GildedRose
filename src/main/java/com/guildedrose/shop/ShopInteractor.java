package com.guildedrose.shop;

import com.guildedrose.inventoryInteractor.InventoryRepository;
import com.guildedrose.items.*;
import com.guildedrose.repositories.FileBalanceRepository;
import com.guildedrose.repositories.FileItemsRepository;

import java.util.ArrayList;

public class ShopInteractor implements ShopBuyItem, ShopSellItem{

    private FileItemsRepository fileItemsRepository;
    private FileBalanceRepository fileBalanceRepository;

    public ShopInteractor(FileItemsRepository fileItemsRepository, FileBalanceRepository fileBalanceRepository){
        this.fileItemsRepository = fileItemsRepository;
        this.fileBalanceRepository = fileBalanceRepository;
    }

    @Override
    public void BuyItemFromInventory(String typeItem, String name, int sellin, int quality, int price) {
        ArrayList<Item> items = fileItemsRepository.getInventory();
        Item item = createItem(items,typeItem,name,sellin,quality,price);
        items.add(item);
        fileItemsRepository.saveInventory(items);
        fileBalanceRepository.SaveBalance(fileBalanceRepository.GetBalance() - item.getPrice());
    }

    @Override
    public void SellItemFromInventory(int index) {
        ArrayList<Item> items = fileItemsRepository.getInventory();
        int balance = fileBalanceRepository.GetBalance();
        for (Item item: items){
            if (item.getId() == index){
                balance = balance + item.getPrice();
            }
        }
        items.removeIf(item -> item.getId() == index);
        fileBalanceRepository.SaveBalance(balance);
        fileItemsRepository.saveInventory(items);
    }
    public int getMaxIndex(ArrayList<Item> items){
        int res = 0;
        for (Item i: items){
            if (i.getId() > res){
                res = i.getId();
            }
        }
        return res;
    }

    private Item createItem(ArrayList<Item> items, String typeItem, String name, int sellin, int quality, int price) {
        Item item = null;
        switch (typeItem) {
            case "Aged":
                item = new Aged(getMaxIndex(items) + 1, name, sellin, quality, price);
                break;
            case "Legendary":
                item = new Legendary(getMaxIndex(items) + 1, name, sellin, quality, price);
                break;
            case "Event":
                item = new Event(getMaxIndex(items) + 1, name, sellin, quality, price);
                break;
            case "Generic":
                item = new Generic(getMaxIndex(items) + 1, name, sellin, quality, price);
                break;
            case "Conjured":
                item = new Conjured(getMaxIndex(items) + 1, name, sellin, quality, price);
                break;
        }
        return item;
    }
}
