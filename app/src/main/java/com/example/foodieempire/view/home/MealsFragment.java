package com.example.foodieempire.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.controller.AppController;
import com.example.foodieempire.controller.MealsCallBack;
import com.example.foodieempire.databinding.FragmentMealsBinding;
import com.example.foodieempire.model.pojo.Meal;

import java.util.ArrayList;


public class MealsFragment extends Fragment implements MealsCallBack {
    FragmentMealsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mealsFragment = inflater.inflate(R.layout.fragment_meals, container, false);
        binding = FragmentMealsBinding.bind(mealsFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String strCategory = getArguments().getString("strCategory", "");
        AppController appController = new AppController(MealsFragment.this);
        appController.getAllMeals(strCategory);
    }

    @Override
    public void getMeals(ArrayList<Meal> meals) {
        MealsAdapter mealsAdapter = new MealsAdapter(meals);
        binding.homeRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.homeRecycler.setAdapter(mealsAdapter);
    }
}