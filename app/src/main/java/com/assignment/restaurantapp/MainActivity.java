package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.assignment.restaurantapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDatabaseHelper myDatabaseHelper;
    String defaultFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addItemsToDB();
        drawerMenu();
        createFoodFragment();

    }

    private void createFoodFragment() {
        FoodCategoryFragment foodCategoryFragment = new FoodCategoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.food_category_fragment, foodCategoryFragment).commit();

    }
    //create food list fragment
    private void createFoodListFragment() {
        FoodListFragment foodListFragment = new FoodListFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("category", defaultFood);
        foodListFragment.setArguments(bundle1);
    }

        private void drawerMenu () {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);

            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.food_menu:
                        createFoodFragment();
                        break;
                    case R.id.orders_menu:
                        Intent intent = new Intent(MainActivity.this, Cart.class);
                        //startActivity(intent);
                        startActivity(intent);
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return false;
            });
        }

        private void addItemsToDB () {
            myDatabaseHelper = new MyDatabaseHelper(this);
            //insert items to database

//        steak.add(new Product("Beef Steak",R.drawable.steaks, "this is a description example text to be used for No Beef Steak", 27.5));
//        steak.add(new Product("Pork Steak",R.drawable.steaks, "this is description example text to be used for the Pork Steak", 17.5));
//        steak.add(new Product("Fish Steak",R.drawable.steaks, "this is description example text to be used for the Fish Steak", 20.5));
//        steak.add(new Product("Lamb Steak",R.drawable.steaks, "this is description example text to be used for the Lamb Steak", 37.75))
            myDatabaseHelper.insertItem("Burger", "Burger", R.drawable.hamburgers, "this is a description example text to be used for Chicken Burger", 27.5);
            myDatabaseHelper.insertItem("Beef Burger", "Burger", R.drawable.hamburgers, "this is a description example text to be used for Beef Burger", 17.5);
            myDatabaseHelper.insertItem("Pork Burger", "Burger", R.drawable.hamburgers, "this is a description example text to be used for Pork Burger", 20.5);

        }


        public void categorySelected (View view){
            CardView cardView = (CardView) view;
            TextView selectedCategory = cardView.findViewById(R.id.card_text);
            String category = selectedCategory.getText().toString();
            FoodListFragment foodListFragment = new FoodListFragment();
//        add products to bundle
            Bundle bundle = new Bundle();
            bundle.putString("category", category);
            foodListFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.food_list_fragment, foodListFragment).commit();
        }

        //item selected from food list fragment
        public void itemSelected (View view){
//            ConstraintLayout constraintLayout = (ConstraintLayout) view;
//            TextView selectedItem = constraintLayout.findViewById(R.id.tv_item_name);
//            String item = selectedItem.getText().toString();
            //start product details activity and add item to the intent
//            Intent intent2 = new Intent(MainActivity.this, ProductDetails.class);
//            intent2.putExtra("item", item);
//            startActivity(intent2);
    }
    }