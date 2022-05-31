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
    ActivityProductDetailsBinding binding;
    final String KEY = "key";
    Product product;
    CartLogic cl = CartLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        product = intent.getParcelableExtra(KEY);

        for (Product p : cl.getCartProducts()) {
            if (p.getName().equals(product.getName()))
                product = p;
        }

        binding.tvName.setText(product.getName());
        binding.tvDescriptionText.setText(product.getDescription());
        String amount = "$" + product.getPrice();
        binding.tvPrice.setText(amount);
        binding.ivImg.setImageResource(product.getImg());

        addToCart();
    }

    @Override
    public void onRestart() {
        binding.etQuantity.getText().clear();
        super.onRestart();
    }

    private void addToCart() {
        binding.btnAddToCart.setOnClickListener(view -> {

            String quantity = binding.etQuantity.getText().toString();

            if (quantity.isEmpty() || quantity.equals("0"))
                return;

            if (!cl.getCartProducts().contains(product)) {
                cl.addProductToCart(product);
                product.addQuantity(Integer.parseInt(quantity));
            }else {
                product.updateQuantity(Integer.parseInt(quantity));
            }
            cl.updateTotal(product, Integer.parseInt(quantity));

            Intent intent = newIntent();
            startActivity(intent);
        });
    }
    public Intent newIntent() {
        return new Intent(this, Cart.class);
    }

}