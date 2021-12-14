package com.guildedrose;

import com.guildedrose.inventoryInteractor.*;
import com.guildedrose.items.*;
import com.guildedrose.repositories.*;
import com.guildedrose.shop.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        boolean arret = false;
        while (!arret) {
            System.out.println("- Dis-moi ce que tu es venu faire : ");
            System.out.println("- Pour quitter, tappez 0");
            System.out.println("- Voir l'inventaire de mon magasin ? - tape '1'");
            System.out.println("- Voir l'invantaire en fonction de la quantité ? - tape '2'");
            System.out.println("- Mettre à jour l'inventaire ? - tape '3'");
            System.out.println("- Acheter un item ? - tape '4'");
            System.out.println("- Vendre un item ? - tape '5'");
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
                case "4":
                    System.out.println("Quel item acheter ?");
                    System.out.println("1.Aged\n2.Legendary\n3.Event\n4.Generic\n5.Conjured");

                    System.out.print("Selectionner le type d'item à acheter : ");
                    int typeItem = input.nextInt();

                    System.out.print("Indiquez le nom de l'item à acheter : ");
                    String nameItem = inputString.nextLine();

                    System.out.print("Indiquez le sellin de l'item à acheter : ");
                    int sellinItem = input.nextInt();

                    System.out.print("Indiquez la quality de l'item à acheter : ");
                    int qualityItem = input.nextInt();

                    System.out.print("Indiquez le prix de l'item à acheter : ");
                    int valueItem = input.nextInt();

                    switch (typeItem) {
                        case 1:
                            BuyItemCommand("Aged", nameItem, sellinItem, qualityItem, valueItem);
                            break;
                        case 2:
                            BuyItemCommand("Legendary", nameItem, sellinItem, qualityItem, valueItem);
                            break;
                        case 3:
                            BuyItemCommand("Event", nameItem, sellinItem, qualityItem, valueItem);
                            break;
                        case 4:
                            BuyItemCommand("Generic", nameItem, sellinItem, qualityItem, valueItem);
                            break;
                        case 5:
                            BuyItemCommand("Conjured", nameItem, sellinItem, qualityItem, valueItem);
                            break;
                        default:
                            String error = "Fait un effort !";
                            System.out.println(error);
                            break;
                    }
                    System.out.println("========================================");
                    break;
            }
        }
    }

    public static void DisplayInventoryCommand() {
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        for (Item item : inventoryViewer.GetInventory()) {
            System.out.println(item.toString());
        }
    }

    public static void DisplayInventoryByCountCommand() {
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        for (Item item : inventoryViewer.GetInventory()) {

            System.out.println(item.toString());
        }
    }

    public static void UpdateInventoryCommand() {
        InventoryUpdater inventoryUpdater = new InventoryInteractor(new FileItemsRepository());
        inventoryUpdater.UpdateQuality();
    }

    public static void BuyItemCommand(String typeItem, String name, int sellin, int quality, int price) {
        ShopInteractor shopInteractor = new ShopInteractor(new FileItemsRepository(), new FileBalanceRepository());
        shopInteractor.BuyItemFromInventory(typeItem, name, sellin, quality, price);
        System.out.println("Item acheté");
    }

    public static void SellItemCOmmand() {

    }

}

