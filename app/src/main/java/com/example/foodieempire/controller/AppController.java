package com.example.foodieempire.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodieempire.model.pojo.CategoryRoot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppController {
    CategoryCallback categoryCallback;

    public AppController(CategoryCallback categoryCallback) {
        this.categoryCallback = categoryCallback;
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
}
