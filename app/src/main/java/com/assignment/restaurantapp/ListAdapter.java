package com.assignment.restaurantapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    private ArrayList<Product> data;
    private Context context;

    public ListAdapter(Context context, ArrayList<Product> data){
        this.data = data;
        this.context = context;
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
        View v = View.inflate(context,R.layout.product_list_item, null);
        TextView tv_name = v.findViewById(R.id.tv_item_name);
        tv_name.setText(data.get(i).getName());
        return v;
    }
}
