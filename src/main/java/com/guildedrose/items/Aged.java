package com.guildedrose.items;

public class Aged extends Item {

    public Aged(int id, String nom, int sellin, int quality, int price) {
        super(id, nom, sellin, quality, price);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality ++;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }

}
