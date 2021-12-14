package com.guildedrose.items;

public class Legendary extends Item {

    public Legendary(String name, int sellin, int quality, int value) {
        super(name, sellin, quality, value);
    }

    public Legendary(int id, String name, int sellin, int quality, int price) {
        super(id, name, sellin, quality, price);
    }

    @Override
    public void update() {
        this.sellin --;
        this.quality = 80;
    }


}
