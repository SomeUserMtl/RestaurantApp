package com.assignment.restaurantapp;

public class Category {
    private String name;
    private int img;

    public Category(String n, int i){
        name = n;
        img = i;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    //setters
    public void setName(String n){
        name = n;
    }

    public void setImg(int i){
        img = i;
    }

}
