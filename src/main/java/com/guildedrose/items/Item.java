package com.guildedrose.items;

public abstract class Item {

    protected int id;
    protected String name;
    protected int sellin;
    protected double quality;
    protected int price;

    public Item(String name, int sellin, int quality, int price) {
        this.name = name;
        this.sellin = sellin;
        this.quality = quality;
        this.price = price;
    }

    public Item (int id, String name, int sellin, int quality, int price){
        this.id = id;
        this.name = name;
        this.sellin = sellin;
        this.quality = quality;
        this.price = price;
    }

    public Item (int id, String name, double quality, int price){
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.price = price;
    }

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

    protected void CellQualityToHundred(){
        if(this.quality >= 100){
            this.quality = 100;
        }
    }

    protected void FloorQualityToZero(){
        if(this.quality <= 0){
            this.quality = 0;
        }
    }

    public abstract void update();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellin() {
        return sellin;
    }

    public void setSellin(int sellin) {
        this.sellin = sellin;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return name +','+ sellin +',' + quality+','+price;
    }

    public String toStringLeg() {
        return "Item{" +
                "nom='" + name + '\'' +
                ", quality=" + quality +
                '}';
    }
}
