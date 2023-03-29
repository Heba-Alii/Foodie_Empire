package com.example.foodieempire.model.data;

import com.example.foodieempire.model.pojo.CategoryRoot;
import com.example.foodieempire.model.pojo.MealRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("categories.php")
    Call<CategoryRoot> getAllCategory();
    @GET("filter.php?c=")
    Call<MealRoot> getAllMeals(@Query("c")String strCategory);
}
