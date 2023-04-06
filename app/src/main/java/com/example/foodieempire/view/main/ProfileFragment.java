package com.example.foodieempire.view.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.FragmentProfileBinding;
import com.example.foodieempire.view.register.RegistrationActivity;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View profileFragment = inflater.inflate(R.layout.fragment_profile, container, false);
        binding = FragmentProfileBinding.bind(profileFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_profileFragment_to_registrationActivity);
                getActivity().finish();
            }
        });

    }
}