package com.assignment.restaurantapp;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    static boolean dataLoaded = false;
    static HashMap<String, ArrayList<Product>> products = new HashMap<>();
//
    static ArrayList<Product> hamburgers = new ArrayList<>();
    static ArrayList<Product> steak = new ArrayList<>();
    static ArrayList<Product> salad = new ArrayList<>();
    static ArrayList<Product> drinks = new ArrayList<>();

//    private static Database instance;

//    public static Database getInstance(){
//        if (instance == null) {
//            if (!dataLoaded)
//                populateCategories();
//            instance = new Database();
//        }
//        return instance;
//    }

//    public ArrayList<Product> getProducts(String str) {
//        return products.get(str);
//    }

    public static void populateCategories(){
        if (!dataLoaded) {
            hamburgers.add(new Product("Burger",R.drawable.hamburgers, "this is a description example text to be used for Chicken Burger", 27.5));
            hamburgers.add(new Product("Beef Burger",R.drawable.hamburgers, "this is a description example text to be used for Beef Burger", 17.5));
            hamburgers.add(new Product("Pork Burger",R.drawable.hamburgers, "this is a description example text to be used for Pork Burger", 20.5));
            hamburgers.add(new Product("Fish Burger",R.drawable.hamburgers, "this is a description example text to be used for Fish Burger", 37.75));
            hamburgers.add(new Product("No Meat Burger", R.drawable.hamburgers, "this is a description example text to be used for No Meat Burger", 14.25));

            steak.add(new Product("Beef Steak",R.drawable.steaks, "this is a description example text to be used for No Beef Steak", 27.5));
            steak.add(new Product("Pork Steak",R.drawable.steaks, "this is description example text to be used for the Pork Steak", 17.5));
            steak.add(new Product("Fish Steak",R.drawable.steaks, "this is description example text to be used for the Fish Steak", 20.5));
            steak.add(new Product("Lamb Steak",R.drawable.steaks, "this is description example text to be used for the Lamb Steak", 37.75));

            salad.add(new Product("Green Salad",R.drawable.salads, "this is description example text to be used for the Green Salad", 27.5));
            salad.add(new Product("Caesar Salad",R.drawable.salads, "this is description example text to be used for the Caesar Salad", 17.5));
            salad.add(new Product("Israeli Salad",R.drawable.salads, "this is description example text to be used for the Israeli Salad", 20.5));

            drinks.add(new Product("Budweiser Beer",R.drawable.drinks, "this is description example text to be used for the Budweiser Beer", 27.5));
            drinks.add(new Product("Sleemen Beer",R.drawable.drinks, "this is description example text to be used for the Sleemen Beer", 17.5));
            drinks.add(new Product("Coke",R.drawable.drinks, "this is description example text to be used for the Coke", 20.5));
            drinks.add(new Product("Pepsi",R.drawable.drinks, "this is description example text to be used for the Pepsi", 37.75));
            drinks.add(new Product("Orange Crush",R.drawable.drinks, "this is description example text to be used for the Orange Crush", 14.25));

            products.put("Hamburgers", hamburgers);
            products.put("Steak", steak);
            products.put("Salad", salad);
            products.put("Drinks", drinks);

            dataLoaded = true;
        }
    }
}
