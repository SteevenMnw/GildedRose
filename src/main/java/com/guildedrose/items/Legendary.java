package com.guildedrose.items;

public class Legendary extends Item {

    public Legendary(int id, String nom, int sellin, int quality, int price) {
        super(id, nom, sellin, quality, price);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality = 80;
    }


}
