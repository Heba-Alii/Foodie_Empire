package com.example.foodieempire.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailsRoot implements Serializable {
    public ArrayList<Details> details;

    public ArrayList<Details> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Details> details) {
        this.details = details;
    }

    public DetailsRoot(ArrayList<Details> details) {
        this.details = details;
    }
}
