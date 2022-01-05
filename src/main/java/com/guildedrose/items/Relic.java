package com.guildedrose.items;

import com.guildedrose.shop.BalanceRepository;

public class Relic extends Item{

    private BalanceRepository balanceRepository;

    public Relic(String name, int quality, int price) {
        super(name, quality, price);
    }

    public Relic(int id, String name, int sellin, int quality, int price) {
        super(id, name, sellin, quality, price);
    }

    @Override
    public void update() {
        this.quality = (this.quality*5)/100;
        if (this.quality >= 100) {
            this.quality = 100;
        }
        AddRelicPriceToBalance();
    }

    public void AddRelicPriceToBalance(){
        int balance = balanceRepository.GetBalance();
        double newBalance = balance + (this.quality/1000) * balance;
        balanceRepository.SaveBalance((int) Math.floor(newBalance));
    }

}
