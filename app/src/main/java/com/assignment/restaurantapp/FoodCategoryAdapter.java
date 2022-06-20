package com.assignment.restaurantapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.ViewHolder> {
    ArrayList<Category> categories;

    Context context;

    public FoodCategoryAdapter(Context context, ArrayList<Category> categories){
        this.categories = categories;
        this.context = context;
    }

    public void notifyChange(){
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_category_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.card_image.setImageResource(categories.get(position).getImg());
        holder.card_text.setText(categories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView card_image;
        TextView card_text;
        public ViewHolder(View view) {
            super(view);
            card_image = view.findViewById(R.id.card_image);
            card_text = view.findViewById(R.id.card_text);
        }
    }
}