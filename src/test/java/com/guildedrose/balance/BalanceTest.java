package com.guildedrose.balance;

import com.guildedrose.items.*;
import com.guildedrose.repositories.*;
import com.guildedrose.shop.ShopInteractor;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BalanceTest {

    ShopInteractor shopInteractor = new ShopInteractor(new InMemoryItemsRepository(), new InMemoryBalanceRepository(100000));
    InMemoryBalanceRepository inMemoryBalanceRepository = new InMemoryBalanceRepository(100000);
    ArrayList<Item> items = shopInteractor.GetInventoryRepository();

    @Test
    public void testGetBalance() {
        assertEquals(100000, inMemoryBalanceRepository.GetBalance());
    }

    @Test
    public void testSaveBalance() {
        inMemoryBalanceRepository.SaveBalance(50000);
        assertEquals(50000, inMemoryBalanceRepository.GetBalance());
    }

    @Test
    public void testSellItemFromInventory() {
        //Aged Item - id:1,name:"Aged Item",sellIn:15,quality:7,price:8000
        shopInteractor.SellItemFromInventory(1);
        assertEquals(108000, shopInteractor.GetBalance());
        assertFalse(shopInteractor.GetInventoryRepository().contains(new Aged(1, "Aged Item", 15, 7, 8000)));
    }

    @Test
    public void testBuyItemFromInventory() {
        shopInteractor.BuyItemFromInventory("Event", "Gold Crown", 18, 30, 1500);
        assertEquals(98500, shopInteractor.GetBalance());
        assertEquals(items.get(items.size() - 1).getName(), "Gold Crown");
        assertEquals(items.get(items.size() - 1).getSellin(), 18);
        assertEquals(items.get(items.size() - 1).getQuality(), 30);
        assertEquals(items.get(items.size() - 1).getPrice(), 1500);
    }
}
