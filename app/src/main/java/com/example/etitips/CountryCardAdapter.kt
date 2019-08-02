package com.example.etitips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryCardAdapter(countryList: ArrayList<CountryCardItem>) : RecyclerView.Adapter<CountryCardAdapter.ViewHolder>() {
    private val mCountryList = countryList

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryFlag: ImageView
        var countryName: TextView

        init {
            countryFlag = itemView.findViewById(R.id.countryFlag)
            countryName = itemView.findViewById(R.id.countryName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mCountryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = mCountryList[position]

        holder.countryFlag.setImageResource(currentItem.getImageResource())
        holder.countryName.setText(currentItem.getText())
    }
}