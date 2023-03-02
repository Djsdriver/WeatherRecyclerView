package com.example.weatherrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter: RecyclerView.Adapter<WeatherHolder>() {
    var days= ArrayList<Day>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.day_item,parent,false)
        return WeatherHolder(view)
    }

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(item = days[position])


    }
    fun add(day:Day){
        days.add(day)
        notifyItemInserted(0)
        notifyItemRangeChanged(0,days.size)
    }

    fun reverse(){
        days.reverse()
        notifyDataSetChanged()
    }

}


