package com.example.foodieempire.view.register;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodieempire.R;
import com.example.foodieempire.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View loginFragment = inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.bind(loginFragment);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = binding.mailET.getText().toString();
                String pass = binding.passET.getText().toString();
                if (isDataEmpty(mail, pass)) {
                    Toast.makeText(getActivity(), "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                } else {
                    loginWithFirebaseAuth(mail, pass);
                }
            }
        });
    }

    private void loginWithFirebaseAuth(String mail, String pass) {
        firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_loginFragment_to_mainActivity);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isDataEmpty(String mail, String pass) {
        return mail.isEmpty() || pass.isEmpty();
    }
}