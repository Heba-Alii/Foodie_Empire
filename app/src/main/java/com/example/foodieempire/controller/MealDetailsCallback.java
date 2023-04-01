package com.example.foodieempire.controller;

import com.example.foodieempire.model.pojo.Details;
import com.example.foodieempire.model.pojo.DetailsRoot;

import java.util.ArrayList;

public interface MealDetailsCallback {
    void getDetails(ArrayList<Details> details);
}
