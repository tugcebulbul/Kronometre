package com.tugcebulbul.kronometre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KayitAdapter(private val kayitListesi: ArrayList<String>)
    : RecyclerView.Adapter<KayitAdapter.KayitViewHolder>() {


    class KayitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sureTextView: TextView = itemView.findViewById(R.id.textViewSure)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KayitViewHolder {
        val gorunum = LayoutInflater.from(parent.context).inflate(R.layout.kayit_gorunumu, parent, false)
        return KayitViewHolder(gorunum)
    }

    override fun getItemCount(): Int {
        return kayitListesi.size
    }

    override fun onBindViewHolder(holder: KayitViewHolder, position: Int) {
        holder.sureTextView.text = kayitListesi[position]
    }

}