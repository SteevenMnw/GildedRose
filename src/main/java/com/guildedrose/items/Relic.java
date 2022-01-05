package com.guildedrose.items;

import com.guildedrose.repositories.FileBalanceRepository;

public class Relic extends Item{
    
    FileBalanceRepository fileBalanceRepository = new FileBalanceRepository();
    
    public Relic(int id, String name, int sellIn, int quality, int price) {
        super(id, name, sellIn, quality, price);
    }

    @Override
    public void update() {
        this.quality += (this.quality*5)/100;
        if (this.quality >= 100) {
            this.quality = 100;
        }
        AddRelicPriceToBalance();
    }
    public void AddRelicPriceToBalance() {
        int balance = fileBalanceRepository.GetBalance();
        double newBalance = ((double)this.getQuality() / 1000) * this.getPrice();
        fileBalanceRepository.SaveBalance(balance + (int) Math.floor(newBalance));
    }
}
