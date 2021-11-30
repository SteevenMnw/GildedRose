/*package com.guildedrose.repositories;

import com.guildedrose.entities.Item;

import java.util.Arrays;

public class GildedRose {

    public void display(Item[] items) {
        for ( Item item : items) {
            if(item.getLegendary() != 1){
                System.out.println(item.toString());
            }
            else{
                System.out.println(item.toStringLeg());
            }
        }
    }

    public void modifySellIn(Item item, int number){
        if(number == 0){
            item.setSellin(0);
        }
        else {
            item.setSellin(item.getSellin() - number);
        }
    }

    public void modifyQuality(Item item, int number){
        if(item.getLegendary() == 1){
            item.setQuality(80);
        }
        else if(number == 0){
            item.setQuality(0);
        }
        else if(number == 50){
            item.setQuality(50);
        }
        else {
            item.setQuality(item.getQuality() + number);
        }
    }

    public void modifyByName(Item item){
        if(item.getNom() != "Sulfuras"){
            if(item.getSellin() != 0){
                modifySellIn(item, 1);
            }
            else{
                modifySellIn(item, 0);
            }
        }

        if(item.getNom() == "Aged Brie"){
            if(item.getQuality() < 50){
                if(item.getSellin() != 0){
                    modifyQuality(item, 1);
                }
                else{
                    modifyQuality(item, 2);
                }
            }
            else{
                modifyQuality(item, 50);
            }
        }

        if(item.getNom() == "Backstage passes"){
            if(item.getQuality() < 50 && item.getSellin() > 10){
                modifyQuality(item, 1);
            }
            else if(item.getQuality() < 49 && item.getSellin() <= 10 && item.getSellin() > 5){
                modifyQuality(item, 2);
            }
            else if(item.getQuality() < 48 && item.getSellin() <= 5 && item.getSellin() > 0){
                modifyQuality(item, 3);
            }
            else if(item.getSellin() == 0){
                modifyQuality(item, 0);
            }
        }
        if(item.getLegendary() == 1){
            modifyQuality(item,1);
        }
    }

    public void decreaseQuality(Item item){
        if (item.getNom() != "Backstage passes" && item.getLegendary() != 1 && item.getNom() != "Aged Brie") {
            if(item.getSellin() != 0){
                if(item.getQuality() > 0){
                    modifyQuality(item, -1);
                }
                else{
                    modifyQuality(item, 0);
                }
            }
            else {
                if(item.getQuality() > 0){
                    modifyQuality(item, -2);
                }
                else{
                    modifyQuality(item, 0);
                }
            }
        }
        else if (item.getLegendary() == 1){
            modifyQuality(item, 1);
        }
    }
}
*/