package com.guildedrose.items;

public class Aged extends Item {

    public Aged(String name, int sellin, int quality, int price) {
        super(name, sellin, quality, price);
    }

    public Aged(int id, String name, int sellin, int quality, int value) {
        super(id, name, sellin, quality, value);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality ++;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }

}
