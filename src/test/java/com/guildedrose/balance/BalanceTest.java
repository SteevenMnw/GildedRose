package com.guildedrose.balance;

import com.guildedrose.items.*;
import com.guildedrose.repositories.InMemoryBalanceRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceTest {

    Item[] items = new Item[]{
            new Aged("Dexterity Vest", 10, 20, 450),
            new Aged("Aged Brie", 2, 0, 20),
            new Event("Elixir of the Mongoose", 5, 7, 150),
            new Legendary("Sulfuras, Hand of Ragnaros", 0, 80, 1000),
            new Legendary("Sulfuras, Hand of Ragnaros", -1, 80, 1500),
            new Conjured("Backstage passes to a TAFKAL80ETC concert", 15, 20, 150),
            new Generic("Backstage passes to a TAFKAL80ETC concert", 10, 49, 120),
            new Generic("Backstage passes to a TAFKAL80ETC concert", 5, 49, 70),
            new Conjured("Conjured Mana Cake", 3, 6, 15)
    };

    Item itemToBuy = new Aged("Peluche", 20, 25, 100);

    InMemoryBalanceRepository inMemoryBalanceRepository = new InMemoryBalanceRepository(1000000);

    @Test
    public void testGetBalance() {
        assertEquals(1000000, inMemoryBalanceRepository.GetBalance());
    }

    @Test
    public void testSaveBalance() {
        items = new Item[]{
                itemToBuy
        };

        inMemoryBalanceRepository.SaveBalance(inMemoryBalanceRepository.GetBalance()-itemToBuy.getPrice());

        assertEquals(999900, inMemoryBalanceRepository.GetBalance());
    }
}
