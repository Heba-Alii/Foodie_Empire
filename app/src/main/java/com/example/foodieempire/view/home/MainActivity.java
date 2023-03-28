package com.example.foodieempire.view.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.ActivityMainBinding;
import com.example.foodieempire.view.register.RegistrationActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentHomeContainerView);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = binding.bottomNavigation;
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }
}