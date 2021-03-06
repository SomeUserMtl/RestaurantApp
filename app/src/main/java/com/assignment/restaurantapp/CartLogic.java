package com.assignment.restaurantapp;
import java.util.ArrayList;
import java.util.HashMap;

public class CartLogic {

    static class CartItem {
        Product product;
        int quantity;
        double total;

        CartItem(Product product, int quantity, double total){
            this.product = product;
            this.quantity = quantity;
            this.total = total;
        }
    }

    private static CartLogic instance;
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private HashMap<String, Integer> itemIndex = new HashMap<>();
    private double total;
    private int arrayIndex;

    public static CartLogic getInstance(){
        if(instance == null){
            instance = new CartLogic();
        }
        return instance;
    }

    public boolean addProductToCart(Product product, String quantity){

        if (quantity.isEmpty() || quantity.equals("0"))
            return false;
        int quantityInt = Integer.parseInt(quantity);

        Integer index = isInCart(product);
        if(index == null){
            CartItem newCartItem = new CartItem(product, quantityInt, product.getPrice() * quantityInt);
            cartItems.add(newCartItem);
            itemIndex.put(product.getName(), arrayIndex);
            total += newCartItem.total;
            arrayIndex++;
        }
        else {
            CartItem cartItem = cartItems.get(index);
            cartItem.quantity += quantityInt;
            cartItem.total = cartItem.product.getPrice() * cartItem.quantity;
            total += cartItem.product.getPrice() * quantityInt;
        }
        return true;
    }

    private Integer isInCart(Product product) {
        if (itemIndex.containsKey(product.getName()))
            return itemIndex.get(product.getName());
        return null;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<CartItem> getCartProducts() {
        return cartItems;
    }

    public void clear(){
        cartItems.clear();
        itemIndex.clear();
        total = 0.0;
        arrayIndex = 0;
    }
}