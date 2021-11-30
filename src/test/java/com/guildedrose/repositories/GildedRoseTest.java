package com.guildedrose.repositories;

import com.guildedrose.entities.Item;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @org.junit.jupiter.api.Test
    void modifySellInPositiveNumber() {
        Item item = new Item();
        item.setSellin(5);

        GildedRose gr = new GildedRose();
        gr.modifySellIn(item,1);

        assertEquals(4,item.getSellin());
    }

    @org.junit.jupiter.api.Test
    void modifySellInZero() {
        Item item = new Item();
        item.setSellin(5);

        GildedRose gr = new GildedRose();
        gr.modifySellIn(item,0);

        assertEquals(0,item.getSellin());
    }

    @org.junit.jupiter.api.Test
    void modifyQuantityPositive() {
        Item item = new Item();
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.modifyQuality(item,1);

        assertEquals(7,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyQuantityNegative() {
        Item item = new Item();
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.modifyQuality(item,-1);

        assertEquals(5,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyQualityZero() {
        Item item = new Item();
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.modifyQuality(item,0);

        assertEquals(0,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameSulfuras() {
        Item item = new Item();
        item.setNom("Sulfuras");
        item.setSellin(0);
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(0,item.getSellin());
        assertEquals(6,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameAgesBrie() {
        Item item = new Item();
        item.setNom("Aged Brie");
        item.setSellin(6);
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(5,item.getSellin());
        assertEquals(7,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameAgesBrieSellInZero() {
        Item item = new Item();
        item.setNom("Aged Brie");
        item.setSellin(0);
        item.setQuality(2);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(0,item.getSellin());
        assertEquals(4,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameBackstagePassesSellInSuperiorTen() {
        Item item = new Item();
        item.setNom("Backstage passes");
        item.setSellin(12);
        item.setQuality(2);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(11,item.getSellin());
        assertEquals(3,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameBackstagePassesSellInInferiorTen() {
        Item item = new Item();
        item.setNom("Backstage passes");
        item.setSellin(9);
        item.setQuality(2);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(8,item.getSellin());
        assertEquals(4,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameBackstagePassesSellInInferiorFive() {
        Item item = new Item();
        item.setNom("Backstage passes");
        item.setSellin(3);
        item.setQuality(2);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(2,item.getSellin());
        assertEquals(5,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void modifyByNameBackstagePassesSellInZero() {
        Item item = new Item();
        item.setNom("Backstage passes");
        item.setSellin(0);
        item.setQuality(2);

        GildedRose gr = new GildedRose();
        gr.modifyByName(item);

        assertEquals(0,item.getSellin());
        assertEquals(0,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void decreaseQualityNormalItem() {
        Item item = new Item();
        item.setSellin(8);
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.decreaseQuality(item);

        assertEquals(5,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void decreaseQualityNormalItemWithZeroQuality() {
        Item item = new Item();
        item.setQuality(0);

        GildedRose gr = new GildedRose();
        gr.decreaseQuality(item);

        assertEquals(0,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void decreaseQualityNormalItemWithZeroSellIn() {
        Item item = new Item();
        item.setSellin(0);
        item.setQuality(10);

        GildedRose gr = new GildedRose();
        gr.decreaseQuality(item);

        assertEquals(8,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void decreaseQualityNormalItemWithSellIn() {
        Item item = new Item();
        item.setSellin(1);
        item.setQuality(10);

        GildedRose gr = new GildedRose();
        gr.decreaseQuality(item);

        assertEquals(9,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void decreaseQualityLegendaryItem() {
        Item item = new Item();
        item.setQuality(6);
        item.setLegendary(1);

        GildedRose gr = new GildedRose();
        gr.decreaseQuality(item);

        assertEquals(6,item.getQuality());
    }

    @org.junit.jupiter.api.Test
    void decreaseQualitySpecialItem() {
        Item item = new Item();
        item.setNom("Aged Brie");
        item.setQuality(6);

        GildedRose gr = new GildedRose();
        gr.decreaseQuality(item);

        assertEquals(6,item.getQuality());
    }
}