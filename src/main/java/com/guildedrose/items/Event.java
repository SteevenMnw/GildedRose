package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class Event extends Item {

    public Event(String nom, int sellin, int quality) {
        super(nom, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;

        if(this.quality < 50 && this.sellin > 10){
            this.quality ++;
        }
        if(this.quality < 49 && this.sellin <= 10 && this.sellin > 5){
            this.quality += 2;
        }
        if(this.quality < 48 && this.sellin <= 5 && this.sellin > 0){
            this.quality += 3;
        }
        if (this.sellin == 0){
            this.quality = 0;
        }

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }

}
