package com.example.projekt3_wersja3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_rejestracja.*
import androidx.navigation.fragment.findNavController

class Fragment_rejestracja : BaseFragment (){
    private val REG_DEBUG = "REG_DEBUG"
    private val fbAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rejestracja, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSignUpClick()
    }

    private fun setupSignUpClick() {
        zarejestrujBT.setOnClickListener {
            val email = mailTV_rejestracja.text?.trim().toString()
            val pass = hasloTV.text?.trim().toString()
            val repeatPass = haslo2TV.text?.trim().toString()

            if (pass == repeatPass) {
                fbAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnSuccessListener { authRes ->
                        if (authRes.user != null) startApp()
                    }


                    .addOnFailureListener { exc ->
                        Snackbar.make(requireView(), "podaj poprawnego meila oraz te same hasła", Snackbar.LENGTH_LONG).show()
                        Log.d(REG_DEBUG, exc.message.toString())


                    }
            }
        }

    }
}




