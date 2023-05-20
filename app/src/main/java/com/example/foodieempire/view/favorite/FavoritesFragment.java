package com.example.foodieempire.view.favorite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.controller.LocalBuilder;
import com.example.foodieempire.databinding.FragmentFavoritesBinding;
import com.example.foodieempire.model.pojo.Meal;
import com.example.foodieempire.view.home.MealIDInterface;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FavoritesFragment extends Fragment implements MealIDInterface, DeleteFavItem {

    FragmentFavoritesBinding binding;
    List<Meal> meal = new ArrayList<>();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String uid=firebaseAuth.getCurrentUser().getUid();

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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!meal.isEmpty()) {
                            binding.favoriteImage.setVisibility(View.GONE);
                            binding.favText.setVisibility(View.GONE);

                            FavoritesAdapter favoritesAdapter = new FavoritesAdapter(meal, FavoritesFragment.this, FavoritesFragment.this);
                            binding.favRecycler.setLayoutManager(new
                                    GridLayoutManager(getActivity(), 2));
                            binding.favRecycler.setAdapter(favoritesAdapter);
                        }
                    }
                });
            }
        }).start();

    }

    @Override
    public void getMailId(String mailId) {
        Bundle bundle = new Bundle();
        bundle.putString("mealId", mailId);

        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_favoritesFragment_to_detailsFragment, bundle);

    }

    @Override
    public void deleteFav(String favId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LocalBuilder localBuilder = LocalBuilder.getInstance(getActivity());
                localBuilder.mealsDao().deleteItem(favId);
                meal = localBuilder.mealsDao().getAllFavMeals();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(meal, FavoritesFragment.this, FavoritesFragment.this);
                        binding.favRecycler.setLayoutManager(new
                                GridLayoutManager(getActivity(), 2));
                        binding.favRecycler.setAdapter(favoritesAdapter);
                    }
                });
            }
        }).start();
    }
}