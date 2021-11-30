package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class Legendary extends Item {

    public Legendary(String nom, int sellin, int quality) {
        super(nom, sellin, quality);
    }

    @Override
    public void update() {
        this.quality = 80;
    }


}
