package com.example.foodieempire.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailsRoot implements Serializable {
    public ArrayList<Details> meals;

    public DetailsRoot(ArrayList<Details> meals) {
        this.meals = meals;
    }

    public ArrayList<Details> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Details> meals) {
        this.meals = meals;
    }
}
