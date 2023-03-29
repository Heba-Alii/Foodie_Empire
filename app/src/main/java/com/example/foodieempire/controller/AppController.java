package com.example.foodieempire.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodieempire.model.pojo.CategoryRoot;
import com.example.foodieempire.model.pojo.MealRoot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppController {
    CategoryCallback categoryCallback;
    MealsCallBack mealsCallBack;

    public AppController(CategoryCallback categoryCallback) {
        this.categoryCallback = categoryCallback;
    }

    public AppController(MealsCallBack mealsCallBack) {
        this.mealsCallBack = mealsCallBack;
    }

    public void getAllCategory() {
        Call<CategoryRoot> call = AppRetrofit.getInstance().getApiInterface().getAllCategory();
        call.enqueue(new Callback<CategoryRoot>() {
            @Override
            public void onResponse(Call<CategoryRoot> call, Response<CategoryRoot> response) {
                categoryCallback.getCategories(response.body().getCategories());
                Log.e("Heba", "onResponse: " + response.body().getCategories().size());
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
                Log.e("TAG", "onResponse: " + response.body().getMeals().size());
            }

            @Override
            public void onFailure(Call<MealRoot> call, Throwable t) {

            }
        });
    }
}
