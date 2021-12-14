package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class Conjured extends Item {

    public Conjured(String nom, int sellin, int quality) {
        super(nom, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality -= 2;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }
}