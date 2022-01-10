package com.guildedrose.menu;

import com.guildedrose.balance.BalanceInteractor;
import com.guildedrose.inventoryInteractor.InventoryInteractor;
import com.guildedrose.inventoryInteractor.InventoryUpdater;
import com.guildedrose.inventoryInteractor.InventoryViewer;
import com.guildedrose.items.Item;
import com.guildedrose.repositories.FileBalanceRepository;
import com.guildedrose.repositories.FileItemsRepository;
import com.guildedrose.shop.ShopInteractor;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class MenuInteractor {

    public void startMenu(){
        String choice;
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("========== Gilded Rose ==========");
            System.out.println("\tPour quitter :'0'");
            System.out.println("\tPour voir l'inventaire : '1'");
            System.out.println("\tVoir l'inventaire en fonction de la quantité : '2'");
            System.out.println("\tMettre à jour l'inventaire : '3'");
            System.out.println("\tAcheter un objet : '4'");
            System.out.println("\tVendre un objet : '5'");
            System.out.println("\tAfficher le solde du magasin : '6'");
            System.out.print("Que veux-tu ?  ");
            choice = input.nextLine();
            System.out.println();
            switch (choice) {
                case "0":
                    System.exit(0); case "1": System.out.println("===== Inventaire =====\n");
                    DisplayInventoryCommand();
                    break; case "2": System.out.println("===== Inventaire (par quantité) =====");
                    DisplayInventoryByCountCommand();
                    break; case "3": System.out.println("===== Mise à jour de l'inventaire =====");
                    UpdateInventoryCommand();
                    break; case "4": System.out.println("===== Achat d'un objet =====");
                    System.out.println("1.Aged\n2.Legendary\n3.Event\n4.Generic\n5.Conjured");
                    System.out.print("Selectionner le type d'objet à acheter : ");
                    String typeItem = input.nextLine();
                    System.out.print("Indiquez le nom de l'objet à acheter : ");
                    String nameItem = inputString.nextLine();
                    System.out.print("Indiquez le sellin de l'objet à acheter : ");
                    int sellinItem = input.nextInt();
                    System.out.print("Indiquez la qualité de l'objet à acheter : ");
                    int qualityItem = input.nextInt();
                    System.out.print("Indiquez le prix de l'objet à acheter : ");
                    int valueItem = input.nextInt();
                    switch (typeItem) {
                        case "1":
                            BuyItemCommand("Aged", nameItem, sellinItem, qualityItem, valueItem);
                            break; case "2": BuyItemCommand("Legendary", nameItem, sellinItem, qualityItem, valueItem);
                            break; case "3": BuyItemCommand("Event", nameItem, sellinItem, qualityItem, valueItem);
                            break; case "4": BuyItemCommand("Generic", nameItem, sellinItem, qualityItem, valueItem);
                            break; case "5": BuyItemCommand("Conjured", nameItem, sellinItem, qualityItem, valueItem);
                            break; default: throw new IllegalArgumentException("Expression Invalide");
                    }
                    System.out.println();
                    break; case "5": System.out.println("===== Vendre un objet =====");
                    System.out.println("Saisir l'id de l'objet à vendre");
                    int idItem = sc.nextInt();
                    SellItemCommand(idItem);
                    System.out.println();
                    break; case "6": System.out.println("===== Solde du magasin =====");
                    DisplayBalanceCommand();
                    System.out.println();
                    break; default: throw new IllegalArgumentException("Expression Invalide");
            }
        } while (true);
    }

    public static void DisplayInventoryCommand() {
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        for (Item item : inventoryViewer.GetInventory()) {
            System.out.println(item.toString());
        }
    }

    public static void DisplayInventoryByCountCommand() {
        InventoryViewer inventoryViewer = new InventoryInteractor(new FileItemsRepository());
        inventoryViewer.getInventoryByQuantity();
        Stream<Map.Entry<String, Long>> itemsSorted = inventoryViewer.getInventoryByQuantity();
        itemsSorted.forEach((i) -> System.out.println("\tItem : " + i.getKey() + " | Quantity : "+ i.getValue()));
    }

    public static void UpdateInventoryCommand() {
        InventoryUpdater inventoryUpdater = new InventoryInteractor(new FileItemsRepository());
        inventoryUpdater.UpdateInventory();
        System.out.println("=== Informations mise à jour ===");
    }

    public static void BuyItemCommand(String typeItem, String name, int sellin, int quality, int price) {
        ShopInteractor shopInteractor = new ShopInteractor(new FileItemsRepository(), new FileBalanceRepository());
        shopInteractor.BuyItemFromInventory(typeItem, name, sellin, quality, price);
        System.out.println("=== Item acheté ===");
    }

    public static void SellItemCommand(int idItem) {
        ShopInteractor shopInteractor = new ShopInteractor(new FileItemsRepository(), new FileBalanceRepository());
        shopInteractor.SellItemFromInventory(idItem);
        System.out.println("Item vendu !");
    }

    public static void DisplayBalanceCommand(){
        BalanceInteractor balanceInteractor = new BalanceInteractor(new FileBalanceRepository());
        System.out.println("Solde du magasin : "+balanceInteractor.getBalance());
    }
}
