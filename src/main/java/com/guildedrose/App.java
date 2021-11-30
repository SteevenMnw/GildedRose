package com.guildedrose;

import com.guildedrose.entities.Item;
import com.guildedrose.repositories.GildedRose;

public class App {

    public static void main(String[] args) {
        GildedRose gr = new GildedRose();

        int day = 16;

        Item item1 = new Item();
        item1.setNom("Aged Brie");
        item1.setSellin(2);
        item1.setQuality(5);

        Item item2 = new Item();
        item2.setNom("Sulfuras");
        item2.setQuality(10);
        item2.setLegendary(1);

        Item item3 = new Item();
        item3.setNom("Backstage passes");
        item3.setSellin(10);
        item3.setQuality(0);

        Item item4 = new Item();
        item4.setNom("Item normal");
        item4.setSellin(10);
        item4.setQuality(31);

        Item items [] = {item1, item2, item3, item4};

        for(int i = 0; i < day; i++){
            for ( Item item : items) {
                gr.modifyByName(item);
                gr.decreaseQuality(item);
            }
        }
        gr.display(items);

    }

}

