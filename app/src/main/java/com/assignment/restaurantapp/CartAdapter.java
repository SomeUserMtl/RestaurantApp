package com.assignment.restaurantapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    ArrayList<Product> data;
    Context m_context;

    public CartAdapter(Context context, ArrayList<Product> data){
        this.data = data;
        this.m_context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(m_context,R.layout.cart_list_item, null);


        TextView tv_name = v.findViewById(R.id.tv_cart_name);
        TextView tv_quantity = v.findViewById(R.id.tv_cart_quantity);
        TextView tv_price = v.findViewById(R.id.tv_cart_price);
        TextView tv_total = v.findViewById(R.id.tv_cart_total);

        tv_name.setText(data.get(i).getName());
        tv_quantity.setText(String.valueOf(data.get(i).getQuantity()));
        tv_price.setText(String.valueOf(data.get(i).getPrice()));
        tv_total.setText(String.valueOf(data.get(i).getPrice() * data.get(i).getQuantity()));
        return v;
    }

}