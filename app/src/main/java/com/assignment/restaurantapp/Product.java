package com.assignment.restaurantapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    String name;
    String img;
    String description;
    double price;
    int quantity;

    public Product(String n, String i, String d, double p){
        name = n;
        img = i;
        description = d;
        price = p;
    }

    public void addQuantity(int q){
        quantity += q;
    }

    public int getQuantity() {
        return quantity;
    }

    protected Product(Parcel in) {
        name = in.readString();
        img = in.readString();
        description = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(img);
        parcel.writeString(description);
        parcel.writeDouble(price);
    }
}
