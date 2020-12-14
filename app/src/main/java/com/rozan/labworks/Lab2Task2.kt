package com.rozan.labworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView

class Lab2Task2 : AppCompatActivity() {
    private lateinit var tvGender: TextView
    private lateinit var male: RadioButton
    private lateinit var female: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2_task2)

        tvGender=findViewById(R.id.tvGender)
        male=findViewById(R.id.male)
        female=findViewById(R.id.female)

        male.setOnClickListener {

            tvGender.text = "Male"
        }
       female.setOnClickListener {
           if(female.isChecked){
               tvGender.text="Female"
           }
       }

    }
}