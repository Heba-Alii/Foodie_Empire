package com.example.foodieempire.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodieempire.R
import com.example.foodieempire.controller.AppController
import com.example.foodieempire.controller.CategoryCallback
import com.example.foodieempire.databinding.FragmentHomeBinding
import com.example.foodieempire.model.pojo.Category

class HomeFragment : Fragment(), CategoryCallback, StrCategoryInterface {
    var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeFragment = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(homeFragment)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.homeProgress.visibility = View.VISIBLE
        super.onViewCreated(view, savedInstanceState)
        val slideModels = ArrayList<SlideModel>()
        slideModels.add(SlideModel(R.drawable.logo, ScaleTypes.FIT))
        slideModels.add(SlideModel(R.drawable.desc, ScaleTypes.FIT))
        slideModels.add(SlideModel(R.drawable.fooddish, ScaleTypes.FIT))
        slideModels.add(SlideModel(R.drawable.meals, ScaleTypes.FIT))
        slideModels.add(SlideModel(R.drawable.categories, ScaleTypes.FIT))
        binding!!.imageSlider.setImageList(slideModels, ScaleTypes.FIT)
        val appController = AppController(this@HomeFragment, context)
        appController.getAllCategory()
    }

    override fun getCategories(categories: ArrayList<Category>) {
        val categoryAdapter = CategoryAdapter(categories, this@HomeFragment)
        binding!!.homeRecycler.layoutManager = GridLayoutManager(activity, 2)
        binding!!.homeRecycler.adapter = categoryAdapter
        binding!!.homeProgress.visibility = View.GONE
    }


    override fun getStrCategory(categoryName: String?) {
        val bundle = Bundle()
        bundle.putString("strCategory", categoryName)
        findNavController(binding!!.root).navigate(
            R.id.action_homeFragment_to_mealsFragment,
            bundle
        )
    }
}