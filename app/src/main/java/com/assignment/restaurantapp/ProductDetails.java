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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        product = intent.getParcelableExtra(KEY);

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
        Button btn = findViewById(R.id.btn_add_to_cart);
        btn.setOnClickListener(view -> {

            String quantity = binding.etQuantity.getText().toString();

            if (quantity.isEmpty() || quantity.equals("0"))
                return;

            product.addQuantity(Integer.parseInt(quantity));
            if (!CartLogic.getInstance().getCartProducts().contains(product))
                CartLogic.getInstance().addProductToCart(product);

            Intent intent = newIntent();
            startActivity(intent);
        });
    }
    public Intent newIntent() {
        return new Intent(this, Cart.class);
    }

}