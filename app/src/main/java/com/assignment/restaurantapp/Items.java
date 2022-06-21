package com.assignment.restaurantapp;

public class Items {
    //add database items
    private int id;
    private String name;
    private String category;
    private int img;
    private String description;
    private double price;

    public Items(int id, String name, String category, int img, String description, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.img = img;
        this.description = description;
        this.price = price;
    }
    public Items() {
    }

    //getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
