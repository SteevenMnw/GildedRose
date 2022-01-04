package com.guildedrose.items;

public class Generic extends Item {

    public Generic(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }

    public Generic(int id, String name, int sellin, int quality, int price) {
        super(id, name, sellin, quality, price);
    }

    @Override
    public void update() {
        this.sellin --;

        if(this.sellin > 0){
            this.quality --;
        }
        else{
            this.quality -= 2;
        }

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
