package com.guildedrose.repositories;

import com.guildedrose.inventoryInteractor.InventoryRepository;
import com.guildedrose.items.Item;
import com.guildedrose.items.*;
import java.io.*;
import java.util.ArrayList;

public class FileItemsRepository implements InventoryRepository {

    ArrayList<Item> items = new ArrayList<>();
    public FileItemsRepository(){}

    @Override
    public ArrayList<Item> GetInventoryRepository() {
        String line = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader("inventory.txt"));
            while((line = read.readLine()) != null){
                String[] item = line.split(",");
                switch (item[1]){
                    case "Aged":
                        items.add(new Aged(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "Conjured":
                        items.add(new Conjured(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "Event":
                        items.add(new Event(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "Generic":
                        items.add(new Generic(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                    case "Legendary":
                        items.add(new Legendary(Integer.parseInt(item[0]),item[2], Integer.parseInt(item[3]), Integer.parseInt(item[4]), Integer.parseInt(item[5])));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void SaveInventoryRepository(ArrayList<Item> items) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"));
            for (Item item: items){
                writer.write(String.format("%d,%s,%s,%d,%d,%d",item.getId(), item.getClass().getSimpleName(), item.getName(), item.getSellin(), item.getQuality(), item.getPrice()));
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
