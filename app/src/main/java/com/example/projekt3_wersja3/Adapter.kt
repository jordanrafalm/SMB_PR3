package com.example.projekt3_wersja3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val dataArray: ArrayList<DatabaseRow>): RecyclerView.Adapter<Adapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val Inflater = LayoutInflater.from(parent.context)
        val view = Inflater.inflate(R.layout.database_row,parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nazwaTV.text = dataArray[holder.adapterPosition].nazwa
        holder.cenaTV.text = dataArray[holder.adapterPosition].cena
        holder.iloscTV.text = dataArray[holder.adapterPosition].ilosc
    }


    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nazwaTV = view.findViewById(R.id.nazwaTV) as TextView
        val cenaTV = view.findViewById(R.id.cenaTV) as TextView
        val iloscTV = view.findViewById(R.id.iloscTV) as TextView

    }    }