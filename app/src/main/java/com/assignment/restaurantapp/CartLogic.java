package com.assignment.restaurantapp;

import java.util.ArrayList;

public class CartLogic {

    private static CartLogic isntance;
    ArrayList<Product> cartProducts = new ArrayList<>();
    double total;

    public static CartLogic getInstance(){
        if(isntance == null){
            isntance = new CartLogic();
        }
        return isntance;
    }

    public void addProductToCart(Product product){
        total += product.getPrice() * product.getQuantity();
        cartProducts.add(product);
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Product> getCartProducts(){
        return cartProducts;
    }

    public void clear(){
        cartProducts.clear();
        total = 0;
    }
}
