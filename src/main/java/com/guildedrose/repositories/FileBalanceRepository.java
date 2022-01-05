package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;
import java.io.*;

public class FileBalanceRepository implements BalanceRepository {

    @Override
    public int GetBalance() {
        String line = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader("balance.txt"));
            line = read.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(line);
    }

    @Override
    public void SaveBalance(int balance) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("balance.txt"));
            writer.write(String.format("%d", balance));
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
