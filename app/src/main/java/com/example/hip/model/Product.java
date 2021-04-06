package com.example.hip.model;

public class Product {
    private int rsImg;
    private String name;
    private boolean isConhang;
    private double price;
    private String date;
    private int quantity;

    public String getName() {
        return name;
    }

    public boolean isConhang() {
        return isConhang;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(String name, boolean isConhang, double price, String date, int quantity, int img) {
        this.name = name;
        this.isConhang = isConhang;
        this.price = price;
        this.date = date;
        this.quantity = quantity;
        this.rsImg = img;
    }
    public int getrsImg(){return this.rsImg;}
}
