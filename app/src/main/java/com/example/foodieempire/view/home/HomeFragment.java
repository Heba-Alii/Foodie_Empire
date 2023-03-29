package com.example.foodieempire.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.foodieempire.R;
import com.example.foodieempire.controller.AppController;
import com.example.foodieempire.controller.CategoryCallback;
import com.example.foodieempire.databinding.FragmentHomeBinding;
import com.example.foodieempire.model.pojo.Category;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements CategoryCallback, StrCategoryIntrface {

    FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeFragment = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(homeFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.logo, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.desc, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.fooddish, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.meals, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.categories, ScaleTypes.FIT));
        binding.imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        AppController appController = new AppController(HomeFragment.this);
        appController.getAllCategory();
    }

    @Override
    public void getCategories(ArrayList<Category> categories) {
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, HomeFragment.this);
        binding.homeRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.homeRecycler.setAdapter(categoryAdapter);
    }

    @Override
    public void getStrCategory(String categoryName) {
        Bundle bundle = new Bundle();
        bundle.putString("strCategory", categoryName);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_homeFragment_to_mealsFragment, bundle);
    }
}