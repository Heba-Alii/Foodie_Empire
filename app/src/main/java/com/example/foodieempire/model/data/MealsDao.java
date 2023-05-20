package com.example.foodieempire.model.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodieempire.model.pojo.Details;
import com.example.foodieempire.model.pojo.Meal;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface MealsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavMeals(Meal meal);

    @Query("select * from meals_table")
    List<Meal> getAllFavMeals();

    @Query("delete from meals_table where idMeal= :id")
    void deleteItem(String id);

    @Query("delete from meals_table")
    void deleteAllFavorite();

    @Query("SELECT EXISTS(SELECT * FROM MEALS_TABLE WHERE idMeal= :id )")
    boolean isFav(String id);
}
