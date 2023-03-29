package com.example.foodieempire.controller;

import com.example.foodieempire.model.pojo.Category;

import java.util.ArrayList;

public interface CategoryCallback {
    void getCategories(ArrayList<Category> categories);


}
