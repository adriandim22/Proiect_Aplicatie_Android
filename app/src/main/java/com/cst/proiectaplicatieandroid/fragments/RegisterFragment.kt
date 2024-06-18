package com.cst.proiectaplicatieandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cst.proiectaplicatieandroid.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        auth = Firebase.auth

        val emailEditText = view.findViewById<EditText>(R.id.email)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val confirmPassEditText = view.findViewById<EditText>(R.id.confirm_pass)
        val btnRegister = view.findViewById<Button>(R.id.registerButton)

        btnRegister.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPassEditText.text.toString().trim()

            if (!validateForm(email, password, confirmPassword)) {
                return@setOnClickListener
            }

            registerUser(email, password)
        }

        return view
    }
    private fun validateForm(email: String, password: String, confirmPassword: String): Boolean {
        when {
            email.isEmpty() || password.isEmpty() -> {
                Toast.makeText(context, "Email and password cannot be empty.", Toast.LENGTH_SHORT).show()
                return false
            }
            password != confirmPassword -> {
                Toast.makeText(context, "Passwords do not match.", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> return true
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("RegisterFragment", "createUserWithEmail:success")
                Toast.makeText(context, "Registration successfully.", Toast.LENGTH_SHORT).show()
                // navigate to login fragment or main activity here
                findNavController().navigate(R.id.loginFragment)
            } else {
                Log.w("RegisterFragment", "createUserWithEmail:failure", task.exception)
                Toast.makeText(context, "Registration failed.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}