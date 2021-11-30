package com.guildedrose.items;

import com.guildedrose.entities.Item;

public class Generic extends Item {

    public Generic(String nom, int sellin, int quality) {
        super(nom, sellin, quality);
    }

    @Override
    public void update() {
        this.sellin --;

        if(this.sellin >= 0){
            this.quality --;
        }
        else{
            this.quality -= 2;
        }
    }
}
