package com.example.weatherrecyclerview

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherHolder(itemView:View):RecyclerView.ViewHolder(itemView) {


        val nameDay=itemView.findViewById<TextView>(R.id.nameDay)
        val temp=itemView.findViewById<TextView>(R.id.temp)
        val image=itemView.findViewById<ImageView>(R.id.image)
    val linear: LinearLayout = itemView.findViewById(R.id.linear)



    fun bind(item:Day){
        nameDay.text=item.name
        temp.text="${item.temp} \u2103"
        image.setImageResource(item.image)
        linear.setBackgroundColor(itemView.context.getColor(item.linear))


    }
}