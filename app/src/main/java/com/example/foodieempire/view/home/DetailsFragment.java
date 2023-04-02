package com.example.foodieempire.view.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.foodieempire.R;
import com.example.foodieempire.controller.AppController;
import com.example.foodieempire.controller.MealDetailsCallback;
import com.example.foodieempire.databinding.FragmentDetailsBinding;
import com.example.foodieempire.model.pojo.Details;

import java.util.ArrayList;
import java.util.Objects;

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
    public void getDetails(ArrayList<Details> details) {
        binding.mealDetailsText.setText(details.get(0).getStrMeal());
        binding.descDetails.setText(details.get(0).getStrInstructions());
        Glide.with(getActivity()).load(details.get(0).getStrMealThumb()).into(binding.mealDetailsImage);
        binding.ingredientOne.setText(details.get(0).getStrIngredient1());
        binding.measureOne.setText(details.get(0).getStrMeasure1());
        binding.ingredientTwo.setText(details.get(0).getStrIngredient2());
        binding.measureTwo.setText(details.get(0).getStrMeasure2());
        binding.ingredientThree.setText(details.get(0).getStrIngredient3());
        binding.measureThree.setText(details.get(0).getStrMeasure3());
        binding.ingredientFour.setText(details.get(0).getStrIngredient4());
        binding.measureFour.setText(details.get(0).getStrMeasure4());
        binding.ingredientFive.setText(details.get(0).getStrIngredient5());
        binding.measureFive.setText(details.get(0).getStrMeasure5());

        binding.youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(details.get(0).getStrYoutube(), "")) {
                    Toast.makeText(getActivity(), "Sorry this video is not available", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(details.get(0).getStrYoutube()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.google.android.youtube");
                    startActivity(intent);
                }
            }
        });
    }
}
