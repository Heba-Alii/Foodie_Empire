package com.example.foodieempire.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.Serializable;

@Entity(tableName = "meals_table")
public class Meal implements Serializable {
    @NonNull
    @PrimaryKey
    private String idMeal;
    private String strMeal;
    private String strMealThumb;
    private String userId;


    public Meal(@NonNull String idMeal, String strMeal, String strMealThumb, String userId) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    @NonNull
    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }
}
