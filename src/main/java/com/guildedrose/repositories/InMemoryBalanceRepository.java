package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;

public class InMemoryBalanceRepository implements BalanceRepository {
    double balance;

    public InMemoryBalanceRepository(double balance){
        this.balance = 100000.00;
    }

    @Override
    public double GetBalance() {
        return balance;
    }

    @Override
    public void SaveBalance(double balance) {
        this.balance = balance;
    }
}
