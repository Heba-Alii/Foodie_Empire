package com.example.foodieempire.view.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.foodieempire.R
import com.example.foodieempire.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentHomeContainerView) as NavHostFragment?
        val navController = navHostFragment!!.navController
        val bottomNavigationView = binding!!.bottomNavigation
        setupWithNavController(bottomNavigationView, navController)
    }
}