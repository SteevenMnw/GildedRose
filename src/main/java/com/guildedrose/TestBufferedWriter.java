package com.guildedrose;

import com.guildedrose.entities.Item;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class TestBufferedWriter {
    protected String destination;

    public TestBufferedWriter(String destination) {
        this.destination = destination;
    }

    public static void main(String args[]) {
        new TestBufferedWriter("inventory.txt");
    }

    public void traitement(ArrayList<Item> items) {
        try {
            BufferedWriter fichier = new BufferedWriter(new FileWriter(destination));

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