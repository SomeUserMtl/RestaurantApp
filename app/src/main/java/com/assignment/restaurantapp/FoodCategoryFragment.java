
package com.assignment.restaurantapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FoodCategoryFragment extends Fragment {

    View v;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_food_category, container, false);



        addCategoriestoDB();
        addCards();
        return v;
    }

    private void addCategoriestoDB() {
        myDatabaseHelper = new MyDatabaseHelper(getContext());
        myDatabaseHelper.insertCategory("Burger", R.drawable.hamburgers);
        myDatabaseHelper.insertCategory("Drinks", R.drawable.drinks);
        myDatabaseHelper.insertCategory("Steaks", R.drawable.steaks);
    }

    private void addCards() {

        ArrayList<Category> categories = myDatabaseHelper.getCategories();

        RecyclerView rv_horizontal = v.findViewById(R.id.horizontal_view);
        FoodCategoryAdapter adapter = new FoodCategoryAdapter(getContext(), categories);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rv_horizontal.setLayoutManager(layoutManager);
        rv_horizontal.setAdapter(adapter);
    }
}