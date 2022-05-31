package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {

    final String KEY = "key";
//    String intentIn;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        product = intent.getParcelableExtra(KEY);


        TextView name = findViewById(R.id.tv_name);
        TextView descText = findViewById(R.id.tv_description_text);
        TextView price = findViewById(R.id.tv_price);

        name.setText(product.getName());
        String desc = product.getDescription();
        descText.setText(desc);
        String amount = "$" + product.getPrice();
        price.setText(amount);

        addToCart();
    }

//    @Override
//    public void onRestart() {
//        EditText et = findViewById(R.id.et_quantity);
//        et.getText().clear();
//        super.onRestart();
//    }

    private void addToCart() {
        Button btn = findViewById(R.id.btn_add_to_cart);
        btn.setOnClickListener(view -> {

            EditText et = findViewById(R.id.et_quantity);
            int etText = Integer.parseInt(et.getText().toString());
            product.addQuantity(etText);
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