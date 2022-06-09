package com.example.projekt3_wersja3

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_produkty.*
import java.util.*
import kotlin.collections.ArrayList
 class ProduktyActivity : AppCompatActivity() {
     private lateinit var MyRef: DatabaseReference
     private lateinit var listOfItems: ArrayList<DatabaseRow>
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_produkty)


         val firebase = FirebaseDatabase.getInstance()
         MyRef = firebase.getReference("ArrayData")

         recyclerView.layoutManager = GridLayoutManager(applicationContext, 1)

         zapiszBT.setOnClickListener {
             val nazwa = nazwaET.text.toString()
             val cena = cenaET.text.toString()
             val ilosc = iloscET.text.toString()
             val firebaseInput = DatabaseRow(nazwa, cena, ilosc)


           //  MyRef.child("produkty").child(nazwa).setValue(firebaseInput)
             MyRef.child("${Date().time}").setValue(firebaseInput)
             nazwaET.text.clear()
             cenaET.text.clear()
             iloscET.text.clear()
         }



MyRef.addValueEventListener(object  : ValueEventListener {

    override fun onCancelled(databaseError: DatabaseError) {
    }
    override fun onDataChange(dataSnapshot: DataSnapshot) {
        listOfItems = ArrayList()
        for (i in dataSnapshot.children){
            val newRow = i.getValue(DatabaseRow::class.java)
            listOfItems.add(newRow!!)
        }
        setupAdapter(listOfItems)
    }

})}

private fun setupAdapter(arrayData: ArrayList<DatabaseRow>){
    recyclerView.adapter = Adapter(arrayData)
}
}
