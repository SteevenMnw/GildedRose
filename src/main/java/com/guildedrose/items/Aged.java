package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class Aged extends Item {

    public Aged(String nom, int sellin, int quality) {
        super(nom, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality ++;

        this.CellQualityToFifty();
        this.FloorQualityToZero();
    }

}