package com.example.foodieempire.view.register;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterFragment extends Fragment {
    FragmentRegisterBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View registerFragment = inflater.inflate(R.layout.fragment_register, container, false);
        binding = FragmentRegisterBinding.bind(registerFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.nameET.getText().toString();
                String mail = binding.mailET.getText().toString();
                String pass = binding.passET.getText().toString();
                if (isDataNotValid(name, mail, pass)) {
                    Toast.makeText(getActivity(), "Complete Your Data Please", Toast.LENGTH_SHORT).show();
                } else
                    addToFirebaseAuth(mail, pass);
            }
        });


    }

    private void addToFirebaseAuth(String mail, String pass) {
        firebaseAuth.createUserWithEmailAndPassword(mail, pass)

                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registerFragment_to_loginFragment);

                        } else {
                            Log.d("TAG", "onComplete: " + task.getException().getMessage());
                            Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private boolean isDataNotValid(String name, String mail, String pass) {
        return name.isEmpty() || mail.isEmpty() || pass.isEmpty();
    }
}