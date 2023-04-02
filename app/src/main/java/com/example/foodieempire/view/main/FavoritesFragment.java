package com.example.foodieempire.view.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.controller.LocalBuilder;
import com.example.foodieempire.databinding.FragmentFavoritesBinding;
import com.example.foodieempire.model.pojo.Meal;
import com.example.foodieempire.view.home.FavoritesAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    FragmentFavoritesBinding binding;
    List<Meal> meal = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View favoriteFragment = inflater.inflate(R.layout.fragment_favorites, container, false);
        binding = FragmentFavoritesBinding.bind(favoriteFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                LocalBuilder localBuilder = LocalBuilder.getInstance(getActivity());
                meal = localBuilder.mealsDao().getAllFavMeals();
                if (meal == null) {
                    binding.favImage.setVisibility(View.VISIBLE);

                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            FavoritesAdapter favoritesAdapter = new FavoritesAdapter(meal);
                            binding.favRecycler.setLayoutManager(new
                                    GridLayoutManager(getActivity(), 2));
                            binding.favRecycler.setAdapter(favoritesAdapter);
                        }
                    });
                }
            }
        }).start();

    }


}