package com.guildedrose.repositories;

import com.guildedrose.fileInteractor.InventoryRead;
import com.guildedrose.entities.Item;
import com.guildedrose.items.*;

import java.io.*;
import java.util.ArrayList;

public class FileItemsRepository implements ItemsRepository {


    ArrayList<Item> items = new ArrayList<>();

    @Override
    public ArrayList<Item> getInventory() {

        String x = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader("inventory.txt"));
            while((x = read.readLine()) != null){
                String[] item = x.split(",");
                switch (item[0]){
                    case "Aged":
                        items.add(new Aged(item[1],Integer.parseInt(item[2]),Integer.parseInt(item[3])));
                        break;
                    case "Conjured":
                        items.add(new Conjured(item[1],Integer.parseInt(item[2]),Integer.parseInt(item[3])));
                        break;
                    case "Event":
                        items.add(new Event(item[1],Integer.parseInt(item[2]),Integer.parseInt(item[3])));
                        break;
                    case "Generic":
                        items.add(new Generic(item[1],Integer.parseInt(item[2]),Integer.parseInt(item[3])));
                        break;
                    case "Legendary":
                        items.add(new Legendary(item[1],Integer.parseInt(item[2]),Integer.parseInt(item[3])));
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void saveInventory(ArrayList<Item> items) {
        try {
            BufferedWriter fichier = new BufferedWriter(new FileWriter("inventory.txt"));

            for (Item item: items){
                fichier.write(String.format("%s,%s,%d,%d", item.getClass().getSimpleName(), item.getNom(), item.getSellin(), item.getQuality()));
                fichier.newLine();
            }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
