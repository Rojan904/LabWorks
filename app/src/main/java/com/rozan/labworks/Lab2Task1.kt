package com.rozan.labworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Lab2Task1 : AppCompatActivity() {
    private lateinit var tvValue:TextView
    private lateinit var btnIncrease: Button

    var value:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2_task1)

        tvValue=findViewById(R.id.tvValue)
        btnIncrease=findViewById(R.id.btnIncrease)



        btnIncrease.setOnClickListener {
            value+=1
            tvValue.text=value.toString()

        }
    }
}