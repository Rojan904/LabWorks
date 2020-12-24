package com.rozan.labworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class Lab5Task1 : AppCompatActivity(),View.OnClickListener {
    private lateinit var etFullName:EditText
    private lateinit var etEmail:EditText
    private lateinit var rdoStudent:RadioButton
    private lateinit var rdoStaff:RadioButton
    private lateinit var tvBatch:TextView
    private lateinit var spinBatch:Spinner
    private lateinit var tvId:TextView
    private lateinit var etId:EditText

    private var selectedItem=""
    private var item= arrayOf("25A","25B","25C","25D")
    private var department= arrayOf("Academic","Accounting","Hostel Management")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5_task1)

        etFullName=findViewById(R.id.etFullName)
        etEmail=findViewById(R.id.etEmail)
        rdoStudent=findViewById(R.id.rdoStudent)
        rdoStaff=findViewById(R.id.rdoStaff)
        tvBatch=findViewById(R.id.tvBatch)
        spinBatch=findViewById(R.id.spinBatch)
        tvId=findViewById(R.id.tvId)
        etId=findViewById(R.id.etId)

        rdoStudent.setOnClickListener(this)
        rdoStudent.isChecked=true
        rdoStaff.setOnClickListener(this)
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
        spinBatch.adapter=adapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.rdoStudent->{
                if (rdoStudent.isChecked){
                    tvBatch.text="Batch"
                    tvId.isVisible=true
                    etId.isVisible=true
                    val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
                    spinBatch.adapter=adapter
                    spinBatch.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            selectedItem=parent?.getItemAtPosition(position).toString()
                        }

                    }
                }

            }
            R.id.rdoStaff->{
                if (rdoStaff.isChecked){
                    tvBatch.text="Department"
                    tvId.isVisible=false
                    etId.isVisible=false
                    val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,department)
                    spinBatch.adapter=adapter
                    spinBatch.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            selectedItem=parent?.getItemAtPosition(position).toString()
                        }

                    }
                }
            }

        }
    }
}