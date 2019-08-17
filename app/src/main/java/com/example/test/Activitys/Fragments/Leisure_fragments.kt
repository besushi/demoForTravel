package com.example.test.Activitys.Fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_leisure.*
import java.util.*


class Leisure_fragments : Fragment() {
    val leisures = arrayOf("קריוקי","חדר בריחה")





    var currentleisure: String? = null
    var currentdate: String? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_leisure, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPointer()
    }

    private fun setPointer() {


        msg.setText("סוג פנאי :")




        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, leisures)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner_sample.setAdapter(aa)


        spinner_sample.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentleisure = leisures[position]
            }

        }




        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH) + 1
        val year = c.get(Calendar.YEAR)
        Log.e("Calendar" ,"$day $month $year")
        currentdate = "$day/$month/$year"
        calendar_btn.setText("$day/"+month+"/$year")


        calendar_btn.setOnClickListener {

            val dpd =
                DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    calendar_btn.setText("$dayOfMonth/"+(monthOfYear+1)+"/$year")
                    currentdate = "$dayOfMonth/"+(monthOfYear+1)+"/$year"
                }, year, month, day)

            //show datepicker
            dpd.show()
        }



        show_btn.setOnClickListener {
            Toast.makeText(activity,"סוג פנאי:$currentleisure\nבתאריך : $currentdate  ", Toast.LENGTH_SHORT).show()
        }
    }



}