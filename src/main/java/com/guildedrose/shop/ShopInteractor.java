package com.guildedrose.shop;

import com.guildedrose.inventoryInteractor.InventoryRepository;
import com.guildedrose.items.*;
import java.util.ArrayList;

public class ShopInteractor implements ShopBuyItem, ShopSellItem{

    private final InventoryRepository inventoryRepository;
    private final BalanceRepository balanceRepository;

    public ShopInteractor(InventoryRepository inventoryRepository, BalanceRepository balanceRepository){
        this.inventoryRepository = inventoryRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void BuyItemFromInventory(String typeItem, String name, int sellin, int quality, int price) {
        ArrayList<Item> items = inventoryRepository.GetInventoryRepository();
        Item item = createItem(items,typeItem,name,sellin,quality,price);
        items.add(item);
        inventoryRepository.SaveInventoryRepository(items);
        balanceRepository.SaveBalance(balanceRepository.GetBalance() - item.getPrice());
    }

    @Override
    public void SellItemFromInventory(int index) {
        ArrayList<Item> items = inventoryRepository.GetInventoryRepository();
        int balance = balanceRepository.GetBalance();
        for (Item item: items){
            if (item.getId() == index){
                balance += item.getPrice();
            }
        }
        items.removeIf(item -> item.getId() == index);
        balanceRepository.SaveBalance(balance);
        inventoryRepository.SaveInventoryRepository(items);

    }
    public int getMaxIndex(ArrayList<Item> items){
        int res = 0;
        for (Item item: items){
            if (item.getId() > res){
                res = item.getId();
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
