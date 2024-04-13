package com.example.foodieempire.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodieempire.R
import com.example.foodieempire.controller.AppController
import com.example.foodieempire.controller.LocalBuilder.Companion.getInstance
import com.example.foodieempire.controller.MealsCallBack
import com.example.foodieempire.databinding.FragmentMealsBinding
import com.example.foodieempire.model.pojo.Meal
import com.example.foodieempire.view.favorite.FavotiteInterface

class MealsFragment : Fragment(), MealsCallBack, FavotiteInterface, MealIDInterface {
    var binding: FragmentMealsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mealsFragment = inflater.inflate(R.layout.fragment_meals, container, false)
        binding = FragmentMealsBinding.bind(mealsFragment)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val strCategory = requireArguments().getString("strCategory", "")
        val appController = AppController(this@MealsFragment)
        appController.getAllMeals(strCategory)
    }

    override fun getMeals(meals: ArrayList<Meal>) {
        val mealsAdapter = MealsAdapter(meals, this@MealsFragment, this@MealsFragment)
        binding!!.homeRecycler.layoutManager = GridLayoutManager(activity, 2)
        binding!!.homeRecycler.adapter = mealsAdapter
    }

    override fun addToFav(meal: Meal) {
        Thread {
            val localBuilder = getInstance(requireActivity())
            localBuilder!!.mealsDao()!!.insertFavMeals(meal)
        }.start()
    }

    override fun getMailId(mailId: String?) {
        val bundle = Bundle()
        bundle.putString("mealId", mailId)
        findNavController(binding!!.root).navigate(
            R.id.action_mealsFragment_to_detailsFragment,
            bundle
        )
    }
}