package com.example.foodieempire.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodieempire.model.pojo.Meal

@Dao
interface MealsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavMeals(meal: Meal?)

    @get:Query("select * from meals_table")
    val allFavMeals: List<Meal?>?

    @Query("delete from meals_table where idMeal= :id")
    fun deleteItem(id: String?)

    @Query("delete from meals_table")
    fun deleteAllFavorite()

    @Query("SELECT EXISTS(SELECT * FROM MEALS_TABLE WHERE idMeal= :id )")
    fun isFav(id: String?): Boolean
}