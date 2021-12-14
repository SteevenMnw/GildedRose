package com.guildedrose;

import com.guildedrose.inventoryInteractor.InventoryViewer;
import com.guildedrose.items.Item;
import com.guildedrose.repositories.FileItemsRepository;
import com.guildedrose.inventoryInteractor.Shop;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        System.out.println("===  Bienvenue dans mon shop mon gars !  ===");
        System.out.println("- Dis-moi ce que tu es venu faire : ");
        System.out.println("- Voir l'inventaire de mon magasin ? - tape '1'");
        System.out.println("- Voir l'invantaire en fonction de la quantité ? - tape '2'");
        System.out.println("- Mettre à jour l'inventaire ? -tape '3'");
        String s = System.console().readLine("que veux-tu : ");

        InventoryViewer viewer = new Shop(new FileItemsRepository());
        ArrayList<Item> items = viewer.GetInventory();

        for(Item item: items){
            System.out.println(item.getNom());
        }
    }

}

