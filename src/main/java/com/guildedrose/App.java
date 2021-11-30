package com.guildedrose;

import com.guildedrose.entities.Item;
import com.guildedrose.items.Conjured;
import com.guildedrose.items.Event;
import com.guildedrose.items.Generic;
import com.guildedrose.items.Legendary;
/*import com.guildedrose.repositories.GildedRose;*/

public class App {

    public static void main(String[] args) {

        int day = 1;

        Item item1 = new Conjured("Conjured Item",5,5);

        Item item2 = new Legendary("Sulfuras",0,10);

        Item item3 = new Generic("Item normal",1,10);

        Item item4 = new Event("Backstage passes",7,31);

        Item items [] = {item1, item2, item3, item4};

        for(int i = 0; i < day; i++){
            for ( Item item : items) {
                item.update();
            }
        }
        for( Item item: items){
            if(item instanceof Legendary){
                System.out.println(item.toStringLeg());
            }
            else {
                System.out.println(item);
            }
        }

    }

}

