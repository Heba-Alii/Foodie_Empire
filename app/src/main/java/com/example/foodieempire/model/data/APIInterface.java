package com.example.foodieempire.model.data;

import com.example.foodieempire.model.pojo.CategoryRoot;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("categories.php")
    Call<CategoryRoot> getAllCategory();
}
