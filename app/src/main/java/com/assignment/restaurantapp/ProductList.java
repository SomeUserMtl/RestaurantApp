package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.assignment.restaurantapp.databinding.ActivityProductListBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductList extends AppCompatActivity {
    ActivityProductListBinding binding;
    private static final String KEY = "key";
    Database db = Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intentIn = getIntent();
        String name = intentIn.getStringExtra(KEY);

        ListAdapter adapter = new ListAdapter(this,db.getProductCategories(name));

        binding.lvList.setAdapter(adapter);
        binding.lvList.setOnItemClickListener((adapterView, view, position, l) -> {
            Intent intentOut = newIntent();
            intentOut.putExtra(KEY, db.getProductCategories(name).get(position));
            startActivity(intentOut);
        });

        seeCart();
    }

    private void seeCart(){
        binding.btnSeeCart.setOnClickListener(view -> {
            Intent intent = newCartIntent();
            startActivity(intent);
        });
    }

    @Override
    public void onStart() {
        setTotal();
        super.onStart();
    }


    private void setTotal(){
        String total = "$" + CartLogic.getInstance().getTotal();
        binding.tvTotal.setText(total);
    }

    public Intent newCartIntent() {
        return new Intent(this, Cart.class);
    }

    private Intent newIntent(){
        return new Intent(this, ProductDetails.class);
    }
}