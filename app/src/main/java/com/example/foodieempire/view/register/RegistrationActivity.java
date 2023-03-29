package com.example.foodieempire.view.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.ActivityRegistrationBinding;
import com.example.foodieempire.view.main.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (firebaseAuth.getCurrentUser() == null) {

            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRegisterContainerView);
            NavController navController = navHostFragment.getNavController();
            Toolbar toolbar = findViewById(R.id.tool_bar);
            setSupportActionBar(toolbar);
            NavigationUI.setupActionBarWithNavController(this, navController);

        } else {
            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}