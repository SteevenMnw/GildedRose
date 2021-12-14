package com.guildedrose.repositories;

import com.guildedrose.inventoryInteractor.InventoryRepository;
import com.guildedrose.items.Item;
import com.guildedrose.items.*;
import java.io.*;
import java.util.ArrayList;

public class FileItemsRepository implements InventoryRepository {

    ArrayList<Item> items = new ArrayList<>();

    @Override
    public ArrayList<Item> getInventory() {
        String x = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader("inventory.txt"));
            while((x = read.readLine()) != null){
                String[] item = x.split(",");
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
        System.out.println(items.toString());
        return items;
    }

    @Override
    public void saveInventory(ArrayList<Item> items) {
        try {
            BufferedWriter fichier = new BufferedWriter(new FileWriter("inventory.txt"));

            for (Item item: items){
                fichier.write(String.format("%s,%d,%s,%s,%s,%s",item.getClass().getSimpleName(),item.getId(), item.getNom(), item.getSellin(), item.getQuality(), item.getPrice()));
                fichier.newLine();
            }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
