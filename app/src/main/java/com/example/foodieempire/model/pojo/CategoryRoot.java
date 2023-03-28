package com.example.foodieempire.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryRoot implements Serializable {
    private ArrayList<Category> categories;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public CategoryRoot(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
