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
        cartProducts.add(product);
    }

    public double getTotal() {
        return total;
    }

    public void updateTotal(Product product, int quantity){
        this.total += (product.getPrice() * quantity);
    }

    public ArrayList<Product> getCartProducts(){
        return cartProducts;
    }

    public void clear(){
        for (Product product : cartProducts) {
            product.addQuantity(0);
        }
        cartProducts.clear();
        total = 0;
    }
}
