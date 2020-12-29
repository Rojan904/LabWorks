package com.rozan.labworks

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.OneShotPreDrawListener.add

class Lab6 : AppCompatActivity() {
    private lateinit var etName:EditText
    private lateinit var etAddress:EditText
    private lateinit var etMobile:EditText
    private lateinit var rdgGender:RadioGroup
    private lateinit var btnSubmit:Button
    private lateinit var rdoMale:RadioButton
    private lateinit var rdoFemale:RadioButton
    private var personList=ArrayList<Person>()
    private var gender="Male"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6)

        binding()

        btnSubmit.setOnClickListener {
            val Name = etName.text.toString()
            val Address = etAddress.text.toString()
            val Mobile = etMobile.text.toString()

            val person = Person(Name,Address,Mobile,gender.toString())
            personList.add(person)

            onClick()
        }
    }
    private fun binding(){
        etName=findViewById(R.id.etName)
        etAddress=findViewById(R.id.etAddress)
        etMobile=findViewById(R.id.etMobile)
        rdgGender=findViewById(R.id.rdgGender)
        btnSubmit=findViewById(R.id.btnSubmit)
        rdoMale=findViewById(R.id.rdoMale)
        rdoFemale=findViewById(R.id.rdoFemale)
        rdgGender.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId==R.id.rdoMale) {
                gender = "Male"
            }
            if (checkedId==R.id.rdoFemale) {
                gender = "Female"
            }
        }



    }
    private fun onClick(){


            val intent= Intent(this,PersonDisplayActivity::class.java)
            intent.putExtra("personList",personList)
            startActivity(intent)
        }

    }

