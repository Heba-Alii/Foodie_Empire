package com.example.foodieempire.view.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRegisterContainerView);
        NavController navController = navHostFragment.getNavController();
        setSupportActionBar(binding.toolBar);
        NavigationUI.setupWithNavController(binding.toolBar, navController);

    }
}