package com.assignment.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.assignment.restaurantapp.databinding.ActivityCartBinding;

public class Cart extends AppCompatActivity {
    ActivityCartBinding binding;
    CartLogic cl = CartLogic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String total = "$" + cl.getTotal();
        binding.tvTotal.setText(total);

        CartAdapter adapter = new CartAdapter(this,cl.getCartProducts(), cl.getProductQuantity());
        binding.lvList.setAdapter(adapter);

        clear();
    }

    private void clear(){
        binding.btnClear.setOnClickListener(v -> {
            cl.clear();
            binding.tvTotal.setText("$0.0");
            binding.lvList.setAdapter(null);
        });
    }
}