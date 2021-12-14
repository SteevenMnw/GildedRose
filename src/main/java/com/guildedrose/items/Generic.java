package com.guildedrose.items;

public class Generic extends Item {

    public Generic(int id, String nom, int sellin, int quality, int price) {
        super(id, nom, sellin, quality, price);
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
