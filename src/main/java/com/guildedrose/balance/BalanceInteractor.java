package com.guildedrose.balance;

import com.guildedrose.shop.BalanceRepository;

public class BalanceInteractor implements BalanceViewer{

    BalanceRepository balanceRepository;

    public BalanceInteractor(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public int getBalance() {
        return balanceRepository.GetBalance();
    }


}
