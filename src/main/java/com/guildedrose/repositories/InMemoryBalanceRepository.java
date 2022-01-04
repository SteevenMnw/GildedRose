package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;

public class InMemoryBalanceRepository implements BalanceRepository {
    int balance;

    public InMemoryBalanceRepository(int balance){
        this.balance = balance;
    }


    @Override
    public int GetBalance() {
        return balance;
    }

    @Override
    public void SaveBalance(int balance) {
        this.balance = balance;
    }
}
