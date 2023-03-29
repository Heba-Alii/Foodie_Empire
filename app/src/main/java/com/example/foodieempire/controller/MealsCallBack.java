package com.example.foodieempire.controller;

import com.example.foodieempire.model.pojo.Meal;

import java.util.ArrayList;

public interface MealsCallBack {
    void getMeals(ArrayList<Meal> meals);
}
