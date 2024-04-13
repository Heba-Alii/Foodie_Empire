package com.example.foodieempire.controller

import com.example.foodieempire.model.data.APIInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppRetrofit {
    val apiInterface: APIInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface = retrofit.create(APIInterface::class.java)
    }

    companion object {
        private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        var instance: AppRetrofit? = null
        @JvmStatic
        fun getInstance(): AppRetrofit? {
            if (instance == null) {
                instance = AppRetrofit()
            }
            return instance
        }
    }
}