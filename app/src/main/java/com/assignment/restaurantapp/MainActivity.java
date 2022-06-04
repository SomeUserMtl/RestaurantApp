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
    }

    public void listViewer(View view) {
        FrameLayout frameLayout= (FrameLayout) view;
        TextView textView = (TextView) frameLayout.getChildAt(1);
        String KEY = "key";

        SharedPreferences sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE);
        sharedPreferences.edit().putString("key", textView.getText().toString()).apply();

        Intent intent = new Intent(this, ProductList.class);
        startActivity(intent);
    }
}