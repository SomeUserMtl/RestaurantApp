package com.assignment.restaurantapp;
import java.util.ArrayList;
import java.util.HashMap;
public class CartLogic {

    private static CartLogic instance;
    HashMap<String, Integer> productQuantity = new HashMap<>();
    ArrayList<Product> cartProducts = new ArrayList<>();
    double total;
    int prevQuantity;


    public static CartLogic getInstance(){
        if(instance == null){
            instance = new CartLogic();
        }
        return instance;
    }

    public void addProductToCart(Product product, int quantity){

        if(productQuantity.containsKey(product.getName())){
            //noinspection ConstantConditions
            prevQuantity = productQuantity.get(product.getName());
            productQuantity.put(product.getName(), quantity += prevQuantity);
        }
        else{
            productQuantity.put(product.getName(), quantity);
            cartProducts.add(product);
        }
        total += product.price * (quantity - prevQuantity);
    }

    public double getTotal() {
        return total;
    }

    public HashMap<String, Integer> getProductQuantity() {
        return productQuantity;
    }

    public ArrayList<Product> getCartProducts() {
        return cartProducts;
    }

    public void clear(){
        cartProducts.clear();
        productQuantity.clear();
        total = 0.0;
        prevQuantity = 0;
    }
}