package com.example.etitips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.country_card.view.*

class CountryCardAdapter(val countryList: ArrayList<CountryCardItem>, val clickListener: (CountryCardItem) -> Unit) : RecyclerView.Adapter<CountryCardAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(countryItem: CountryCardItem, clickListener: (CountryCardItem) -> Unit) {
            itemView.countryFlag.setImageResource(countryItem.getImageResource())
            itemView.countryName.text = countryItem.getText()
            itemView.setOnClickListener { clickListener(countryItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.country_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder).bind(countryList[position], clickListener)
    }
}