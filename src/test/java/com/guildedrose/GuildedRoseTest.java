package com.guildedrose;

import com.guildedrose.items.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuildedRoseTest {

    @Test
    void testSellInAndQualityAgedItem() {
        Aged agedBrie = new Aged("Aged Brie", 5, 8, 10);
        agedBrie.update();
        assertEquals(4, agedBrie.getSellin());
        assertEquals(9, agedBrie.getQuality());
    }

    @Test
    void testMaxQualityAgedItem() {
        Aged agedBrie = new Aged("Aged Brie", 10, 50, 5);
        agedBrie.update();
        assertEquals(50, agedBrie.getQuality());
    }

    @Test
    void testSellInAndQualityConjuredItem() {
        Conjured conjuredItem = new Conjured("Conjured", 10, 15, 10);
        conjuredItem.update();
        assertEquals(9, conjuredItem.getSellin());
        assertEquals(13, conjuredItem.getQuality());
    }

    @Test
    void testMinQualityConjuredItem() {
        Conjured conjuredItem = new Conjured("Conjured", 10, 1, 20);
        conjuredItem.update();
        assertEquals(0, conjuredItem.getQuality());
    }

    @Test
    void testSellInAndQualityLegendayItem() {
        Legendary sulfuras = new Legendary("Sulfuras", 10, 15, 15);
        sulfuras.update();
        assertEquals(10, sulfuras.getSellin());
        assertEquals(15, sulfuras.getQuality());
    }

    @Test
    void testSellInAndQualityGenericItem() {
        Generic normal = new Generic(1,"normal Item", 7, 8, 10);
        normal.update();
        assertEquals(6, normal.getSellin());
        assertEquals(7, normal.getQuality());
    }

    @Test
    void testQualityIfSellInNegative() {
        Generic normal = new Generic(2,"normal Item", 0, 6, 53);
        normal.update();
        assertEquals(-1, normal.getSellin());
        assertEquals(4, normal.getQuality());
    }

    @Test
    void testSellInAndQualityEventItem() {
        Event backstagePasses = new Event(3,"Backstage passes", 15, 30, 10);
        backstagePasses.update();
        assertEquals(14, backstagePasses.getSellin());
        assertEquals(31, backstagePasses.getQuality());
    }

    @Test
    void testQualityWhenSellInBetween10And5() {
        Event backstagePasses = new Event(4,"Backstage passes", 8, 15, 20);
        backstagePasses.update();
        assertEquals(17, backstagePasses.getQuality());
    }

    @Test
    void testQualityWhenSellInBetween5And0() {
        Event backstagePasses = new Event(5,"Backstage passes", 4, 17, 15);
        backstagePasses.update();
        assertEquals(20, backstagePasses.getQuality());
    }

    @Test
    void testQualityWhenSellInInf0() {
        Event backstagePasses = new Event(6,"Backstage passes", 0, 30, 50);
        backstagePasses.update();
        assertEquals(-1, backstagePasses.getSellin());
        assertEquals(0, backstagePasses.getQuality());
    }

    @Test
    void testQualityRelic() {
        Relic relic = new Relic(7, "Relic", 10, 50, 15000);
        relic.update();
        assertEquals(10.5, relic.getQuality());
    }

    @Test
    void testQualityRelicOver100() {
        Relic relic = new Relic(7, "Relic", 99, 50, 15000);
        relic.update();
        assertEquals(100, relic.getQuality());
    }

}
