package com.guildedrose.shop;

import com.guildedrose.inventoryInteractor.ItemsRepository;
import com.guildedrose.items.*;
import java.util.ArrayList;

public class ShopInteractor implements ShopBuyItem, ShopSellItem, ItemsRepository, BalanceRepository{

    private final ItemsRepository itemsRepository;
    private final BalanceRepository balanceRepository;

    public ShopInteractor(ItemsRepository itemsRepository, BalanceRepository balanceRepository){
        super();
        this.itemsRepository = itemsRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void BuyItemFromInventory(String typeItem, String name, int sellin, int quality, int price) {
        ArrayList<Item> items = itemsRepository.GetInventoryRepository();
        Item item = createItem(items,typeItem,name,sellin,quality,price);
        items.add(item);
        itemsRepository.SaveInventoryRepository(items);
        balanceRepository.SaveBalance(balanceRepository.GetBalance() - item.getPrice());
    }

    @Override
    public void SellItemFromInventory(int index) {
        ArrayList<Item> items = itemsRepository.GetInventoryRepository();
        double balance = balanceRepository.GetBalance();
        for (Item item: items){
            if (item.getId() == index){
                balance += item.getPrice();
            }
        }
        items.removeIf(item -> item.getId() == index);
        balanceRepository.SaveBalance(balance);
        itemsRepository.SaveInventoryRepository(items);

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
            case "Relic":
                item = new Relic(getMaxIndex(items)+1, name, quality, price);
                break;
        }
        return item;
    }

    @Override
    public ArrayList<Item> GetInventoryRepository() {
        return itemsRepository.GetInventoryRepository();
    }

    @Override
    public void SaveInventoryRepository(ArrayList<Item> items) {
        itemsRepository.SaveInventoryRepository(items);
    }

    @Override
    public double GetBalance() {
        return balanceRepository.GetBalance();
    }

    @Override
    public void SaveBalance(double balance) {
        balanceRepository.SaveBalance(balance);
    }
}
