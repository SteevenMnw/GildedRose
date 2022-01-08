package com.guildedrose.items;

public class Event extends Item {

    public Event(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }

    public Event(int id, String name, int sellin, int quality, int price) {
        super(id, name, sellin, quality, price);
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
        if (this.sellin <= 0){
            this.quality = 0;
        }

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }

}
