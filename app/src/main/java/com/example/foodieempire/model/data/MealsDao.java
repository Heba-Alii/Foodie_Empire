package com.example.foodieempire.model.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodieempire.model.pojo.Meal;

import java.util.List;

@Dao
public interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavMeals(Meal meal);

    @Query("select * from meals_table")
    List<Meal> getAllFavMeals();
}
