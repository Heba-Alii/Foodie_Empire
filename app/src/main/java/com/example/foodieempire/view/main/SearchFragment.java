package com.example.foodieempire.view.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.controller.AppController;
import com.example.foodieempire.controller.MealDetailsCallback;
import com.example.foodieempire.databinding.FragmentSearchBinding;
import com.example.foodieempire.model.pojo.Details;
import com.example.foodieempire.view.home.MealsAdapter;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements MealDetailsCallback {
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
    public void getDetails(ArrayList<Details> details) {
        SearchAdapter searchAdapter = new SearchAdapter(details);
        binding.searchRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.searchRecycler.setAdapter(searchAdapter);
    }
}