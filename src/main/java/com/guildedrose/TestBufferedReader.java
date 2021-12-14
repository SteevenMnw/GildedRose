package com.guildedrose;

import com.guildedrose.entities.Item;

import java.io.*;
import java.util.ArrayList;

public class TestBufferedReader {
    protected String source;

    public TestBufferedReader(String source) {
        this.source = source;
    }

    public static void main(String args[]) {
        new TestBufferedReader("inventory.txt");
    }

    public ArrayList<String> lecture() {
        ArrayList<String> items = new ArrayList<>();
        try {
            String ligne ;
            BufferedReader fichier = new BufferedReader(new FileReader(source));

            while ((ligne = fichier.readLine()) != null) {
                items.add(ligne);
            }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}