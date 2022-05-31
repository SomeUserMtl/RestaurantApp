package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.assignment.restaurantapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Database.populateCategories();
    }

    public void listViewer(View view) {
        FrameLayout frameLayout= (FrameLayout) view;
        TextView textView = (TextView) frameLayout.getChildAt(1);

        Intent intent = new Intent(this, ProductList.class);
        intent.putExtra(KEY,textView.getText().toString());
        startActivity(intent);
    }
}