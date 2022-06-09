package com.example.projekt3_wersja3

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val BackgroundColor =  pref.getInt("BackgroundColor", Color.WHITE)
        fragmentContainerView3.setBackgroundColor(BackgroundColor)
        fragmentContainerView.setBackgroundColor(BackgroundColor)

    }

    fun ustawcolor(view: android.view.View) {
        val pref = getPreferences(Context.MODE_APPEND)
        val editor = pref.edit()

        fragmentContainerView3.setBackgroundColor(Color.GREEN)
        fragmentContainerView.setBackgroundColor(Color.GREEN)
        editor.putInt("BackgroundColor", Color.GREEN.toString().toInt())

        editor.commit()


        val toast = Toast.makeText(applicationContext, "zmieniono kolor na zielony", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()

    }

    fun ustawcolor2(view: android.view.View) {
        val pref = getPreferences(Context.MODE_APPEND)
        val editor = pref.edit()


        fragmentContainerView3.setBackgroundColor(Color.WHITE)
        fragmentContainerView.setBackgroundColor(Color.WHITE)
        editor.putInt("BackgroundColor", Color.WHITE.toString().toInt())

        editor.commit()


        val toast = Toast.makeText(applicationContext, "zmieniono kolor na biały", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()

    }
}