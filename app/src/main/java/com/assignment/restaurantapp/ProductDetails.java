package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.assignment.restaurantapp.databinding.ActivityProductDetailsBinding;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {
    private ActivityProductDetailsBinding binding;
    private final String KEY = "item";
    private String product;
//    private final CartLogic cl = CartLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

//        Intent intent = getIntent();
//        product = intent.getStringExtra(KEY);

//        binding.tvName.setText(product.getName());
//        binding.tvDescriptionText.setText(product.getDescription());
//        String amount = "$" + product.getPrice();
//        binding.tvPrice.setText(amount);
//        binding.ivImg.setImageResource(product.getImg());

//        addToCart();
    }
//
//    @Override
//    public void onRestart() {
//        binding.etQuantity.getText().clear();
//        super.onRestart();
//    }

//    private void addToCart() {
//        binding.btnAddToCart.setOnClickListener(view -> {
//
//            String quantity = binding.etQuantity.getText().toString();
//
//            if (!cl.addProductToCart(product, quantity))
//                return;
//
//            Intent intent = newIntent();
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            Toast.makeText(this, quantity + " " + product.getName() + " added to Cart",
//                    Toast.LENGTH_SHORT).show();
//            startActivity(intent);
//        });
//    }
//    public Intent newIntent() {
//        return new Intent(this, ProductList.class);
//    }
}