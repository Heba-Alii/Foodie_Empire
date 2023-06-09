package com.example.foodieempire.view.register;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.FragmentWelcomeScreenBinding;
import com.google.firebase.auth.FirebaseAuth;


public class WelcomeScreenFragment extends Fragment {
    FragmentWelcomeScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View welcomeScreenFragment = inflater.inflate(R.layout.fragment_welcome_screen, container, false);
        binding = FragmentWelcomeScreenBinding.bind(welcomeScreenFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SpannableString login = new SpannableString(getString(R.string.loged));
        login.setSpan(new UnderlineSpan(), 0, login.length(), 0);
        binding.login.setText(login);
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.getRoot()).
                        navigate(R.id.action_welcomeScreenFragment_to_registerFragment);
            }
        });
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_welcomeScreenFragment_to_loginFragment);
            }
        });
    }
}