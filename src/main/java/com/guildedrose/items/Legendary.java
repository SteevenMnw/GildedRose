package com.guildedrose.items;

public class Legendary extends Item {

    public Legendary(String nom, int sellin, int quality) {
        super(nom, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality = 80;
    }


}
