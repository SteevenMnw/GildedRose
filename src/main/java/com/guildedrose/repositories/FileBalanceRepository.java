package com.guildedrose.repositories;

import com.guildedrose.shop.BalanceRepository;
import java.io.*;

public class FileBalanceRepository implements BalanceRepository {

    @Override
    public double GetBalance() {
        String line = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader("balance.txt"));
            line = read.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(line.replace(",", "."));
    }

    @Override
    public void SaveBalance(double balance) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("balance.txt"));
            writer.write(String.format("%2f", balance));
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
