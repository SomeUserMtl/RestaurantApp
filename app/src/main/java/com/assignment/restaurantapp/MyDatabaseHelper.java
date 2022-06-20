package com.assignment.restaurantapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, "Database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS items (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                        "name TEXT UNIQUE, " +
                        "category TEXT, " +
                        "img INTEGER, " +
                        "description TEXT, " +
                        "price TEXT)");
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS categories (" +
                        "name TEXT PRIMARY KEY UNIQUE, " +
                        "img INTEGER)");
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS orders (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                        "name TEXT UNIQUE, " +
                        "img INTEGER, " +
                        "description TEXT, " +
                        "quantity INTEGER, " +
                        "price TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //insert a record into the database
    public void insertItem(String name, int img, String description, double price) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("img", img);
        contentValues.put("description", description);
        contentValues.put("price", price);
        db.insert("items", null, contentValues);
    }

    //insert a record into order
    public void insertOrder(String name, int img, String description, int quantity, double price) {
        //check if name exists in the database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orders WHERE name = '" + name + "'", null);
        //if name exists, update the quantity
        if (cursor.getCount() > 0) {
            db.execSQL("UPDATE orders SET quantity = quantity + " + quantity + " WHERE name = '" + name + "'");
            //multiply the price with the new quantity
            db.execSQL("UPDATE orders SET price = price + " + (price * quantity) + " WHERE name = '" + name + "'");
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("img", img);
            contentValues.put("description", description);
            contentValues.put("quantity", quantity);
            contentValues.put("price", price);
            db.insert("orders", null, contentValues);
        }
    }

    //insert a category into the category table
    public void insertCategory(String name, int img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("img", img);
        db.insert("categories", null, contentValues);
    }

    //get all the records from the categopry table
    public ArrayList<Category> getCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Category> categories = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM categories", null);
        if (cursor.moveToFirst()) {
            do {
                categories.add(new Category(cursor.getString(0), cursor.getInt(1)));
            } while (cursor.moveToNext());
        }
        return categories;
    }
}
