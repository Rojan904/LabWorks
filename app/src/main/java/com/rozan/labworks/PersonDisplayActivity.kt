package com.rozan.labworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class PersonDisplayActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var tvName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvMobile: TextView
    private lateinit var tvGender: TextView
    private var listname=arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_display)

        listView=findViewById(R.id.listView)
        tvName=findViewById(R.id.tvName)
        tvAddress=findViewById(R.id.tvAddress)
        tvMobile=findViewById(R.id.tvMobile)
        tvGender=findViewById(R.id.tvGender)

        if(intent!=null){
            var list=intent.getSerializableExtra("personList") as ArrayList<Person>

            for(i in list.indices){
                val name=list[i].Name
                listname.add(name)
            }

            val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,listname)
            listView.adapter=adapter


            listView.setOnItemClickListener{parent,view,position,id->
                val name=list[id.toInt()].Name
                val address=list[id.toInt()].Address
                val mobile=list[id.toInt()].Mobile
                val gender=list[id.toInt()].Gender

                tvName.text="$name"
                tvAddress.text="$address"
                tvMobile.text="$mobile"
                tvGender.text="$gender"

            }

        }

    }
}
