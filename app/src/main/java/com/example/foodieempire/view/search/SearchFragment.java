package com.example.foodieempire.view.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodieempire.R;
import com.example.foodieempire.controller.AppController;
import com.example.foodieempire.controller.LocalBuilder;
import com.example.foodieempire.controller.MealsCallBack;
import com.example.foodieempire.databinding.FragmentSearchBinding;
import com.example.foodieempire.model.pojo.Meal;
import com.example.foodieempire.view.favorite.FavotiteInterface;
import com.example.foodieempire.view.home.MealIDInterface;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements MealsCallBack, FavotiteInterface, MealIDInterface {
    FragmentSearchBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View searchFragment = inflater.inflate(R.layout.fragment_search, container, false);
        binding = FragmentSearchBinding.bind(searchFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                AppController appController = new AppController(SearchFragment.this);
                appController.getMealBySearch(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    @Override
    public void getMeals(ArrayList<Meal> meals) {
        if (meals != null) {
            binding.searchImage.setVisibility(View.GONE);
            SearchAdapter searchAdapter = new SearchAdapter(meals, SearchFragment.this, SearchFragment.this);
            binding.searchRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            binding.searchRecycler.setAdapter(searchAdapter);
        } else {

            Toast.makeText(getActivity(), "Please enter right meal name", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void addToFav(Meal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LocalBuilder localBuilder = LocalBuilder.getInstance(getActivity());
                localBuilder.mealsDao().insertFavMeals(meal);
            }
        }).start();

    }

    @Override
    public void getMailId(String mailId) {
        Bundle bundle = new Bundle();
        bundle.putString("mealId", mailId);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_searchFragment_to_detailsFragment, bundle);

    }
}