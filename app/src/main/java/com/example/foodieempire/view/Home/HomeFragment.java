package com.example.foodieempire.view.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.foodieempire.R;
import com.example.foodieempire.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeFragment = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(homeFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.firstphoto, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.secondphoto, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.thirdphot, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.fourthphot, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.fifthphoto, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sixthphoto, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sevenphot, ScaleTypes.FIT));
        binding.imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}