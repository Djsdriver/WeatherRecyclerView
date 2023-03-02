package com.example.weatherrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrecyclerview.MainActivity.Companion.colorList
import com.example.weatherrecyclerview.MainActivity.Companion.dayList
import com.example.weatherrecyclerview.MainActivity.Companion.imageList
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView
    lateinit var btnReverse: Button
    lateinit var btnAdd: FloatingActionButton
    var adapter=WeatherAdapter()

    private var index=0

    companion object{
        val dayList= listOf("Пн.","Вт.","Ср.","Чт.","Пт.","Сб.","Вс.")
        val colorList= listOf(R.color.purple_700,R.color.blue)
        val imageList= listOf(R.drawable.cloud, R.drawable.sun)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  btnReverse=findViewById(R.id.btnReverse)
        btnAdd=findViewById(R.id.btnAdd)


      recycler= findViewById(R.id.rcView)

        /*recycler.adapter=WeatherAdapter(
            days = List(7){
                Day(dayList[it], randomImage(), randomTemp(), randomColor())
            }

        )*/

        recycler.adapter=adapter

        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        btnAdd.setOnClickListener {
            adapter.add(Day(dayList[index], randomImage(), randomTemp(), randomColor()))
            if(index==6){
                index=0
            } else index++
        }

       /* btnReverse.setOnClickListener {
            adapter.reverse()
        }*/

    }
}

fun randomTemp(): Int = (-10..10).random()
fun randomImage(): Int = imageList[(0..1).random()]
fun randomColor(): Int = colorList[(0..1).random()]