package com.example.foodieempire.view.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.foodieempire.R
import com.example.foodieempire.controller.AppSharedPreference
import com.example.foodieempire.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    var binding: FragmentLoginBinding? = null
    var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val loginFragment = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(loginFragment)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.loginBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val mail = binding!!.mailET.text.toString()
                val pass = binding!!.passET.text.toString()
                val name = binding!!.nameET.text.toString()
                if (isDataEmpty(mail, pass, name)) {
                    Toast.makeText(activity, "Please Complete Your Data", Toast.LENGTH_SHORT).show()
                } else {
                    loginWithFirebaseAuth(mail, pass)
                    writeToSharedPref(name)
                }
            }

            private fun writeToSharedPref(name: String) {
                AppSharedPreference.writeToSharedPrefernce(activity, name)
            }
        })
    }

    private fun loginWithFirebaseAuth(mail: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                binding!!.loginBtn.visibility = View.GONE
                binding!!.loginProgress.visibility = View.VISIBLE
                findNavController(binding!!.root).navigate(R.id.action_loginFragment_to_mainActivity)
                requireActivity().finish()
            } else {
                binding!!.loginProgress.visibility = View.GONE
                Toast.makeText(activity, task.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isDataEmpty(mail: String, pass: String, name: String): Boolean {
        return mail.isEmpty() || pass.isEmpty() || name.isEmpty()
    }
}