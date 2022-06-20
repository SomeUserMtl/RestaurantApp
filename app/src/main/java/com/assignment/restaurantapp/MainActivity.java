package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.assignment.restaurantapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set food category fragment
        FoodCategoryFragment foodCategoryFragment = new FoodCategoryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.food_category_fragment, foodCategoryFragment).commit();
    }
}