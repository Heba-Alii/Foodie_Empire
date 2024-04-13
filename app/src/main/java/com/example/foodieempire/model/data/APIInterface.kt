package com.example.foodieempire.model.data

import com.example.foodieempire.model.pojo.CategoryRoot
import com.example.foodieempire.model.pojo.DetailsRoot
import com.example.foodieempire.model.pojo.MealRoot
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @get:GET("categories.php")
    val allCategory: Call<CategoryRoot?>?

    @GET("filter.php?c=")
    fun getAllMeals(@Query("c") strCategory: String?): Call<MealRoot?>?

    @GET("lookup.php?i=")
    fun getMealDetails(@Query("i") mealId: String?): Call<DetailsRoot?>?

    @GET("search.php?s=")
    fun getSearchMeals(@Query("s") mealName: String?): Call<MealRoot?>?
}