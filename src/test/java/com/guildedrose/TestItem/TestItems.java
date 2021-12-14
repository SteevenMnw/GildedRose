package com.guildedrose.TestItem;

import com.guildedrose.entities.Item;
import com.guildedrose.items.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestItems {

    @Test
    void AgedTest(){
        Item aged = new Aged("Aged Item",15,7);
        aged.update();
        // quality
        assertEquals(8,aged.getQuality());
        // sell in
        assertEquals(14,aged.getSellin());

        Item agedMaxQualityTest = new Aged("Aged Item",10,50);
        agedMaxQualityTest.update();
        //quality
        assertEquals(50,agedMaxQualityTest.getQuality());
        //sellin
        assertEquals(9,agedMaxQualityTest.getSellin());
    }

    @Test
    void ConjuredTest(){
        Item conjured = new Conjured("Conjured Item",8,22);
        conjured.update();
        // quality
        assertEquals(20,conjured.getQuality());
        // sell in
        assertEquals(7,conjured.getSellin());

        Item conjuredMinQualityTest = new Conjured("Conjured Item",8,1);
        conjuredMinQualityTest.update();
        // quality
        assertEquals(0,conjuredMinQualityTest.getQuality());
        // sell in
        assertEquals(7,conjuredMinQualityTest.getSellin());
    }

    @Test
    void LegendaryTest(){
        Item legendary = new Legendary("Sulfuras",0,10);
        legendary.update();
        // quality
        assertEquals(80,legendary.getQuality());
        // sell in
        assertEquals(-1,legendary.getSellin());
    }

    @Test
    void GenericTest(){
        Item generic = new Generic("Item normal",15,33);
        generic.update();
        // quality
        assertEquals(32,generic.getQuality());
        // sell in
        assertEquals(14,generic.getSellin());

        Item genericEndSellInTest = new Generic("Item normal",0,33);
        genericEndSellInTest.update();
        // quality
        assertEquals(31,genericEndSellInTest.getQuality());
        // sell in
        assertEquals(-1,genericEndSellInTest.getSellin());

        Item genericMinQualityTest = new Generic("Item normal",0,1);
        genericMinQualityTest.update();
        // quality
        assertEquals(0,genericMinQualityTest.getQuality());
        // sell in
        assertEquals(-1,genericMinQualityTest.getSellin());
    }

    @Test
    void EventTest(){
        Item event = new Event("Backstage passes",23,4);
        event.update();
        // quality
        assertEquals(5,event.getQuality());
        // sell in
        assertEquals(22,event.getSellin());

        Item eventLessThanOrTenDay = new Event("Backstage passes",8,4);
        eventLessThanOrTenDay.update();
        // quality
        assertEquals(6,eventLessThanOrTenDay.getQuality());
        // sell in
        assertEquals(7,eventLessThanOrTenDay.getSellin());

        Item eventLessThanOrFiveDay = new Event("Backstage passes",3,4);
        eventLessThanOrFiveDay.update();
        // quality
        assertEquals(7,eventLessThanOrFiveDay.getQuality());
        // sell in
        assertEquals(2,eventLessThanOrFiveDay.getSellin());

        Item eventSellInZero = new Event("Backstage passes",1,25);
        eventSellInZero.update();
        // quality
        assertEquals(0,eventSellInZero.getQuality());
        // sell in
        assertEquals(0,eventSellInZero.getSellin());
    }
}
