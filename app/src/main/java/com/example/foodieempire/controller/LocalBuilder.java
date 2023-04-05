package com.example.foodieempire.controller;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.foodieempire.model.data.MealsDao;
import com.example.foodieempire.model.pojo.Details;
import com.example.foodieempire.model.pojo.Meal;

@Database(entities = Meal.class, version =1)
public abstract class LocalBuilder extends RoomDatabase {
    private static LocalBuilder dbInstance;

    public abstract MealsDao mealsDao();

    public static LocalBuilder getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder
                    (context.getApplicationContext(),
                            LocalBuilder.class, "MealsDB").build();
        }
        return dbInstance;
    }


}
