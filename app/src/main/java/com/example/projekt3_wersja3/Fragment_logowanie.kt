package com.example.projekt3_wersja3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_logowanie.*
import androidx.navigation.NavController

import android.R
import androidx.navigation.Navigation
import androidx.fragment.app.FragmentActivity
import android.app.Activity
import android.widget.Toast

class Fragment_logowanie : BaseFragment (){
    private val fbAuth = FirebaseAuth.getInstance()
    private val lOG_DEBUG = "LOG_DEBUG"
    private var myContext: FragmentActivity? = null


    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.projekt3_wersja3.R.layout.fragment_logowanie, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLoginClick()


    }



    private fun setupLoginClick() {
        loginBT.setOnClickListener {
            val email = mailTV.text?.trim().toString()
            val pass = passwordTV.text?.trim().toString()
            fbAuth.signInWithEmailAndPassword(email, pass)

                        .addOnSuccessListener {authRes ->
                            if(authRes.user != null) startApp()

                        }


                        .addOnFailureListener { exc ->
                            Snackbar.make(requireView(), "nie udało sie zalogować", Snackbar.LENGTH_LONG).show()
                            Log.d(lOG_DEBUG, exc.message.toString())
                }
        }



                }
}