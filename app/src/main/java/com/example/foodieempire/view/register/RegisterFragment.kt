package com.example.foodieempire.view.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.foodieempire.R
import com.example.foodieempire.controller.AppSharedPreference.writeToSharedPrefernce
import com.example.foodieempire.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {
    var binding: FragmentRegisterBinding? = null
    var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val registerFragment = inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.bind(registerFragment)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.registerBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val name = binding!!.nameET.text.toString()
                val phone = binding!!.phoneET.text.toString()
                val mail = binding!!.mailET.text.toString()
                val pass = binding!!.passET.text.toString()
                if (isDataNotValid(name, mail, pass, phone)) {
                    Toast.makeText(activity, "Complete Your Data Please", Toast.LENGTH_SHORT).show()
                } else addToFirebaseAuth(mail, pass)
                writeToSharedPreference(name, phone, mail)
            }

            private fun writeToSharedPreference(name: String, phone: String, mail: String) {
                writeToSharedPrefernce(activity!!, name, phone, mail)
            }
        })
    }

    private fun addToFirebaseAuth(mail: String, pass: String) {
        firebaseAuth.createUserWithEmailAndPassword(mail, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    binding!!.registerBtn.visibility = View.GONE
                    binding!!.registerProgress.visibility = View.VISIBLE
                    findNavController(binding!!.root).navigate(R.id.action_registerFragment_to_mainActivity)
                    requireActivity().finish()
                } else {
                    binding!!.registerProgress.visibility = View.GONE
                    Log.d("TAG", "onComplete: " + task.exception!!.message)
                    Toast.makeText(activity, task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun isDataNotValid(name: String, mail: String, pass: String, phone: String): Boolean {
        return name.isEmpty() || mail.isEmpty() || pass.isEmpty() || phone.isEmpty()
    }
}