package com.assignment.restaurantapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FoodListFragment extends Fragment {

    View v;
    MyDatabaseHelper myDatabaseHelper;
    String foodName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_food_list, container, false);

        //get arguments if not null
        Bundle bundle = getArguments();
        if (bundle != null) {
            foodName = bundle.getString("category");
        }

        addItems();
        return v;
    }

    private void addItems() {
        myDatabaseHelper = new MyDatabaseHelper(getContext());
        ArrayList<Items> items = myDatabaseHelper.getItems(foodName);

        RecyclerView rv_vertical = v.findViewById(R.id.vertical_view);
        FoodItemAdapter adapter = new FoodItemAdapter(getContext(), items);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rv_vertical.setLayoutManager(layoutManager);
        rv_vertical.setAdapter(adapter);
    }
}