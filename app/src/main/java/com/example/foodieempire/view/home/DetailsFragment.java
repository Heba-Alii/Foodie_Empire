package com.example.foodieempire.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.controller.AppController;
import com.example.foodieempire.controller.MealDetailsCallback;
import com.example.foodieempire.databinding.FragmentDetailsBinding;
import com.example.foodieempire.model.pojo.Details;

import java.util.ArrayList;

public class DetailsFragment extends Fragment implements MealDetailsCallback {
    FragmentDetailsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View detailsFragment = inflater.inflate(R.layout.fragment_details, container, false);
        binding = FragmentDetailsBinding.bind(detailsFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppController appController = new AppController(DetailsFragment.this);
        String idMeal = getArguments().getString("mealId", "gtg");

        appController.getMealDetails(idMeal);
    }


    @Override
    public void getDetails(Details details) {
        binding.mealDetailsText.setText(details.getStrMeal());
        binding.descDetails.setText(details.getStrInstructions());
        binding.ingredientOne.setText(details.getStrIngredient1());
    }
}
