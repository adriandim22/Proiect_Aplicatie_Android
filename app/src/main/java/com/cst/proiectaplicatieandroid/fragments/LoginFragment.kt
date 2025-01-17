package com.cst.proiectaplicatieandroid.fragments

import android.annotation.SuppressLint
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
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.cst.proiectaplicatieandroid.BuildConfig
import com.cst.proiectaplicatieandroid.R
import com.cst.proiectaplicatieandroid.models.api.LoginAPIRequestModel
import com.cst.proiectaplicatieandroid.models.api.LoginAPIResponseModel
import com.cst.proiectaplicatieandroid.utils.VolleyRequestQueue
import com.cst.proiectaplicatieandroid.utils.extensions.logErrorMessage
import com.cst.proiectaplicatieandroid.utils.extensions.showToast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.gson.Gson

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        auth = Firebase.auth

        // BUTTON LOGIN
        val btnLogin = view.findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val email = view.findViewById<EditText>(R.id.et_username).text.toString().trim()
            val password = view.findViewById<EditText>(R.id.et_password).text.toString().trim()
            signIn(email, password)
        }


        // BUTTON SignUP
        val btnSignUp = view.findViewById<Button>(R.id.btn_sign_up)
        btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        return view
    }

    private fun signIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Email and password cannot be empty.", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("LoginFragment", "signInWithEmail:success")
                // Navigate to next fragment
                findNavController().navigate(R.id.action_loginFragment_to_newsFragment)
            } else {
                Log.w("LoginFragment", "signInWithEmail:failure", task.exception)
                Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}










//private var usernameEditText : EditText?  = null
//private var passwordEditText : EditText?  = null


//    @SuppressLint("SetTextI18n")
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        usernameEditText = view.findViewById<EditText>(R.id.et_username)
//        passwordEditText = view.findViewById<EditText>(R.id.et_password)
//
//        if(BuildConfig.DEBUG) {
//            usernameEditText?.setText("mor_2314")
//            passwordEditText?.setText("83r5^_")
//        }
//
//        val button = view.findViewById<Button>(R.id.btn_sign_up)
//        button.setOnClickListener {
//            goToRegister()
//        }
//
//        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
//            doLogin()
//        }
//    }
//
//    private fun goToRegister() {
//        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
//        findNavController().navigate(action)
//    }
//
//    private fun goToNews() {
//        val action = LoginFragmentDirections.actionLoginFragmentToNewsFragment()
//        findNavController().navigate(action)
//    }
//
//    private fun doLogin() {
//
//        val username = when(usernameEditText?.text?.isNotEmpty()){
//            true -> usernameEditText?.text.toString()
//
//            else ->
//            {
//                getString(R.string.authentication_invalid_username).showToast(context)
//                return
//            }
//        }
//        val password = when(passwordEditText?.text?.isNotEmpty()) {
//            true -> passwordEditText?.text.toString()
//
//            else -> {
//                getString(R.string.authentication_invalid_password).showToast(context)
//                return
//            }
//        }
//
////        val loginAPIRequestModel = LoginAPIRequestModel(
////            username = username,
////            password = password
////        )
//
//        val url = "https://fakestoreapi.com/auth/login"
//
//        // Request a string response from the provided URL.
//        val stringRequest = object: StringRequest(
//            Request.Method.POST, url,
//            { response ->
//                Gson().fromJson(response, LoginAPIResponseModel::class.java).let {
//                    responseModel -> responseModel.token.showToast(context)
//                    goToNews()
//                }
//            },
//            {
//                "Login didn't work!".logErrorMessage()
//            }) {
//            override fun getParams(): MutableMap<String, String> {
//                val params: MutableMap<String,String> = HashMap()
//                params["username"] = username
//                params["password"] = password
//
//                return params
//            }
//
//        }
//
//        // Add the request to the RequestQueue.
//        VolleyRequestQueue.addToRequestQueue(stringRequest)
//    }