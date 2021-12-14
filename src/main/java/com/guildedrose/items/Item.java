package com.guildedrose.items;

public abstract class Item {

    public Item (int id, String nom, int sellin, int quality, int price){
        this.id = id;
        this.nom = nom;
        this.sellin = sellin;
        this.quality = quality;
        this.price = price;
    }

    protected int id;
    protected String nom;
    protected Integer sellin;
    protected int quality;
    protected int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected void CellQualityToFifty(){
        if(this.quality >= 50){
            this.quality = 50;
        }
    }

    protected void FloorQualityToZero(){
        if(this.quality <= 0){
            this.quality = 0;
        }
    }

    public abstract void update();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSellin() {
        return sellin;
    }

    public void setSellin(int sellin) {
        this.sellin = sellin;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return nom +','+ sellin +',' + quality+','+price;
    }

    public String toStringLeg() {
        return "Item{" +
                "nom='" + nom + '\'' +
                ", quality=" + quality +
                '}';
    }
}
