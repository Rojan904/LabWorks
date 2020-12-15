package com.rozan.labworks

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import java.util.*

class Lab3Task1 : AppCompatActivity() {
private lateinit var tvName:TextView
    private lateinit var tvPost:TextView
    private lateinit var tvJoinDate:TextView
    private lateinit var tvAddress:TextView
    private lateinit var tvPhone:TextView

    private lateinit var etName:EditText
    private lateinit var spinnerPost:Spinner
    private lateinit var etJoinDate:EditText
    private lateinit var etAddress:EditText
    private lateinit var etPhone:EditText

    private lateinit var btnSubmit:Button

    private lateinit var tvNameDisplay:TextView
    private lateinit var tvPostDisplay:TextView
    private lateinit var tvJoinDateDisplay:TextView
    private lateinit var tvAddressDisplay:TextView
    private lateinit var tvPhoneDisplay:TextView

    private val post=arrayOf("Manager","Accountant","Clerk")
    private var selectedItem=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_task1)

        tvName=findViewById(R.id.tvName)
        tvPost=findViewById(R.id.tvPost)
        tvJoinDate=findViewById(R.id.tvJoin)
        tvAddress=findViewById(R.id.tvAddress)
        tvPhone=findViewById(R.id.tvNo)

        etName=findViewById(R.id.etName)
        spinnerPost=findViewById(R.id.spinnerPost)
        etJoinDate=findViewById(R.id.etJoin)
        etAddress=findViewById(R.id.etAddress)
        etPhone=findViewById(R.id.etNo)

        btnSubmit=findViewById(R.id.btnSubmit)

        tvNameDisplay=findViewById(R.id.tvNameDisplay)
        tvPostDisplay=findViewById(R.id.tvPostDisplay)
        tvJoinDateDisplay=findViewById(R.id.tvJoinDisplay)
        tvAddressDisplay=findViewById(R.id.tvAddressDisplay)
        tvPhoneDisplay=findViewById(R.id.tvPhoneDisplay)



    val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,post)
    spinnerPost.adapter=adapter
    spinnerPost.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
             selectedItem=parent?.getItemAtPosition(position).toString()
//            Toast.makeText(this@Lab3Task1,"Selected Post: $selectedItem",Toast.LENGTH_SHORT).show()
        }

    }

        etJoinDate.setOnClickListener{
            loadCalendar()
        }
        btnSubmit.setOnClickListener {
            showDetails()
        }

    }
    private fun loadCalendar(){
        val calendar= Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog= DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view,years,months,days->
            etJoinDate.setText("$days/${months+1}/$years")

        },
            year,
            month,
            day
        )
        datePickerDialog.show()
}
    private fun showDetails(){
        tvNameDisplay.isVisible=true
        tvPostDisplay.isVisible=true
        tvAddressDisplay.isVisible=true
        tvJoinDateDisplay.isVisible=true
        tvPhoneDisplay.isVisible=true

        val name=etName.text.toString()
        val post=selectedItem
        val address=etAddress.text.toString()
        val date=etJoinDate.text.toString()
        val number=etPhone.text.toString()

        tvNameDisplay.text="Employee Name: $name"
        tvPostDisplay.text="Employee Post: $post"
        tvAddressDisplay.text="Address: $address"
        tvJoinDateDisplay.text="Join Date: $date"
        tvPhoneDisplay.text="Phone Number: $number"

    }


}