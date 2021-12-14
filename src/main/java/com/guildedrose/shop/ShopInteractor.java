package com.guildedrose.shop;

import com.guildedrose.inventoryInteractor.ItemsRepository;
import com.guildedrose.items.Item;

import java.util.ArrayList;

public class ShopInteractor implements ShopBuyItem, ShopSellItem{

    private ItemsRepository itemsRepository;
    private BalanceRepository balanceRepository;

    public ShopInteractor(ItemsRepository itemsRepository, BalanceRepository balanceRepository){
        this.itemsRepository = itemsRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void BuyItemFromInventory(Item item) {
        ArrayList<Item> items = itemsRepository.getInventory();
        for (Item i: items){
            if (i == item){
                items.remove(item);
            }
        }
    }

    @Override
    public void SellItemFromInventory(Item item) {
        ArrayList<Item> items = itemsRepository.getInventory();
        items.add(item);
    }
}
