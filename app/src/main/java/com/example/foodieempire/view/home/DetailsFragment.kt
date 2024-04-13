package com.example.foodieempire.view.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.foodieempire.R
import com.example.foodieempire.controller.AppController
import com.example.foodieempire.controller.MealDetailsCallback
import com.example.foodieempire.databinding.FragmentDetailsBinding
import com.example.foodieempire.model.pojo.Details

class DetailsFragment : Fragment(), MealDetailsCallback {
    lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detailsFragment = inflater.inflate(R.layout.fragment_details, container, false)
        binding = FragmentDetailsBinding.bind(detailsFragment)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appController = AppController(this@DetailsFragment)
        val idMeal = requireArguments().getString("mealId", "gtg")
        appController.getMealDetails(idMeal)
    }

    override fun getDetails(details: ArrayList<Details>) {
        binding.mealDetailsText.text = details[0].strMeal
        binding.descDetails.text = details[0].strInstructions
        Glide.with(requireActivity()).load(details[0].strMealThumb).into(binding.mealDetailsImage)
        binding.ingredientOne.text = details[0].strIngredient1
        binding.measureOne.text = details[0].strMeasure1
        binding.ingredientTwo.text = details[0].strIngredient2
        binding.measureTwo.text = details[0].strMeasure2
        binding.ingredientThree.text = details[0].strIngredient3
        binding.measureThree.text = details[0].strMeasure3
        binding.ingredientFour.text = details[0].strIngredient4
        binding.measureFour.text = details[0].strMeasure4
        binding.ingredientFive.text = details[0].strIngredient5
        binding.measureFive.text = details[0].strMeasure5
        binding.youtubeButton.setOnClickListener {
            if (details[0].strYoutube == "") {
                Toast.makeText(activity, "Sorry this video is not available", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(details[0].strYoutube))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setPackage("com.google.android.youtube")
                startActivity(intent)
            }
        }
    }
}