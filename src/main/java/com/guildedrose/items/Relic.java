package com.guildedrose.items;

import com.guildedrose.repositories.FileBalanceRepository;

public class Relic extends Item{
    
    FileBalanceRepository fileBalanceRepository = new FileBalanceRepository();
    
    public Relic(int id, String name, double quality, int price) {
        super(id, name, quality, price);
    }

    @Override
    public void update() {
        this.quality += (this.quality*5)/100;
        this.CellQualityToHundred();
        AddRelicPriceToBalance();
    }

    public void AddRelicPriceToBalance() {
        double balance = fileBalanceRepository.GetBalance();
        double newBalance = (this.getQuality() / 1000) * this.getPrice();
        fileBalanceRepository.SaveBalance(balance + Math.floor(newBalance));
    }
}
