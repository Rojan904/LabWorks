package com.rozan.labworks

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class Lab4Task1 : AppCompatActivity() {
    private lateinit var tvName:TextView
    private lateinit var tvDepartment:TextView
    private lateinit var tvAddress:TextView
    private lateinit var tvDate:TextView

    private lateinit var etName:EditText
    private lateinit var spinnerDepartment:Spinner
    private lateinit var etAddress:EditText
    private lateinit var etDate:EditText

    private lateinit var btnSubmit:Button
    private var selectedDepartment=""
    private val department= arrayOf("Account", "Client", "Clerk")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_task1)

        tvName=findViewById(R.id.tvName)
        tvDepartment=findViewById(R.id.tvDepartment)
        tvAddress=findViewById(R.id.tvAddress)
        tvDate=findViewById(R.id.tvDate)

        etName=findViewById(R.id.etName)
        spinnerDepartment=findViewById(R.id.spinnerDepartment)
        etAddress=findViewById(R.id.etAddress)
        etDate=findViewById(R.id.etDate)

        btnSubmit=findViewById(R.id.submit)

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,department)
        spinnerDepartment.adapter=adapter
        spinnerDepartment.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedDepartment=parent?.getItemAtPosition(position).toString()
            }

        }

        etDate.setOnClickListener {
            loadCalendar()
        }
        btnSubmit.setOnClickListener {
            submitData()
        }
    }
    private fun loadCalendar(){
        val calendar= Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                view,year,month,day->
            etDate.setText("$day/${month+1}/$year")
        },
            year,
            month,
            day

        )
        datePickerDialog.show()
    }
    private fun submitData() {
        val date=etDate.text.toString()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Your data")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setMessage(
            "Employee name : ${etName.text}" + "\n" +
                    "Employee department: $selectedDepartment" + "\n" +
                   "Join Date: $date" + "\n" +
                    "Employee address: ${etAddress.text}" + "\n"

        )
        builder.setPositiveButton("OK") { _: DialogInterface?, _ ->
            // Toast.makeText(applicationContext, "Pressed cancel", Toast.LENGTH_SHORT).show()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }
    }