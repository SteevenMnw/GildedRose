package com.guildedrose;

import com.guildedrose.inventoryInteractor.InventoryUpdater;
import com.guildedrose.inventoryInteractor.InventoryViewer;
import com.guildedrose.items.Item;
import com.guildedrose.repositories.FileItemsRepository;
import com.guildedrose.inventoryInteractor.Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean arret = false;
        while (!arret) {
            System.out.println("- Dis-moi ce que tu es venu faire : ");
            System.out.println("- Pour quitter, tappez 0");
            System.out.println("- Voir l'inventaire de mon magasin ? - tape '1'");
            System.out.println("- Voir l'invantaire en fonction de la quantité ? - tape '2'");
            System.out.println("- Mettre à jour l'inventaire ? -tape '3'");
            System.out.print("Que veux-tu : ");
            String s = input.nextLine();

            switch (s) {
                case "0":
                    arret = true;
                    break;
                case "1":
                    DisplayInventoryCommand();
                    break;
                case "2":
                    DisplayInventoryByCountCommand();
                    break;
                case "3":
                    UpdateInventoryCommand();
                    break;
            }
        }
    }

    public static void  DisplayInventoryCommand(){
        InventoryViewer inventoryViewer = new Shop(new FileItemsRepository());
        for (Item item: inventoryViewer.GetInventory()){
            System.out.println(item.toString());
        }
    }
    public static void DisplayInventoryByCountCommand(){
        InventoryViewer inventoryViewer = new Shop(new FileItemsRepository());
        for (Item item: inventoryViewer.GetInventory()){

            System.out.println(item.toString());
        }
    }
    public static void UpdateInventoryCommand() {
        InventoryUpdater inventoryUpdater = new Shop(new FileItemsRepository());
        inventoryUpdater.UpdateQuality();
    }
}

