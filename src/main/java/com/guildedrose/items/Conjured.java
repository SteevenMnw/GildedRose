package com.guildedrose.items;

public class Conjured extends Item {

    public Conjured(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }

    public Conjured(int id, String nom, int sellin, int quality, int price) {
        super(id, nom, sellin, quality, price);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality -= 2;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}
