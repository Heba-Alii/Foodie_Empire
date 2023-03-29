package com.example.foodieempire.controller;

import com.example.foodieempire.model.data.APIInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofit {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private APIInterface apiInterface;
    public static AppRetrofit instance;

    public AppRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        apiInterface = retrofit.create(APIInterface.class);
    }

    public static AppRetrofit getInstance() {
        if (instance == null) {
            instance = new AppRetrofit();
        }
        return instance;
    }

    public APIInterface getApiInterface() {
        return apiInterface;
    }
}
