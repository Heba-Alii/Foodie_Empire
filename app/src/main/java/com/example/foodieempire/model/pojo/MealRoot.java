package com.example.foodieempire.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class MealRoot implements Serializable {
    private ArrayList<Meal> meals;

    public MealRoot(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
