package com.example.foodieempire.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodieempire.model.pojo.CategoryRoot;
import com.example.foodieempire.model.pojo.Details;
import com.example.foodieempire.model.pojo.DetailsRoot;
import com.example.foodieempire.model.pojo.Meal;
import com.example.foodieempire.model.pojo.MealRoot;
import com.example.foodieempire.view.home.FavotiteInterface;
import com.example.foodieempire.view.home.MealIDInterface;
import com.example.foodieempire.view.main.FavoritesFragment;
import com.example.foodieempire.view.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppController {
    CategoryCallback categoryCallback;
    MealsCallBack mealsCallBack;
    MealDetailsCallback mealDetailsCallback;


    public AppController(MealsCallBack mealsCallBack) {
        this.mealsCallBack = mealsCallBack;
    }

    public AppController(CategoryCallback categoryCallback) {
        this.categoryCallback = categoryCallback;
    }

    public AppController(MealDetailsCallback mealDetailsCallback) {
        this.mealDetailsCallback = mealDetailsCallback;
    }

    public void getAllCategory() {
        Call<CategoryRoot> call = AppRetrofit.getInstance().getApiInterface().getAllCategory();
        call.enqueue(new Callback<CategoryRoot>() {
            @Override
            public void onResponse(Call<CategoryRoot> call, Response<CategoryRoot> response) {
                categoryCallback.getCategories(response.body().getCategories());
            }

            @Override
            public void onFailure(Call<CategoryRoot> call, Throwable t) {
            }
        });
    }

    public void getAllMeals(String strcCategory) {
        Call<MealRoot> call = AppRetrofit.getInstance().getApiInterface().getAllMeals(strcCategory);
        call.enqueue(new Callback<MealRoot>() {
            @Override
            public void onResponse(Call<MealRoot> call, Response<MealRoot> response) {
                mealsCallBack.getMeals(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealRoot> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getMealDetails(String mealId) {
        Call<Details> call = AppRetrofit.getInstance().getApiInterface().getMealDetails(mealId);
        call.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {

                if (response.isSuccessful()) {
                    mealDetailsCallback.getDetails(response.body());
                } else {
                    Log.e("TAG", "onResponse: " + response.message());
                }
                Log.e("TAG", "onResponsedetails: " + response.body().getStrMeal());
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

}
