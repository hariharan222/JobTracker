package com.example.harih.jobtracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_job.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Add_Job_Activity : AppCompatActivity() {

    fun datapp(): Boolean{
        val doa = dateText.text.toString()
        val df = SimpleDateFormat("dd/MM/yy")
        df.isLenient = false
        try {
            val date: Date = df.parse(doa)

            return true
        } catch (e: ParseException){
            return false
        }
        return false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_job)
        cancelButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        addButton.setOnClickListener {


            if(comText.text.isNotEmpty() && jobText.text.isNotEmpty() && dateText.text.isNotEmpty() && locText.text.isNotEmpty() && conText.text.isNotEmpty() && emailText.text.isNotEmpty() && phoneText.text.isNotEmpty()){


                if (datapp().equals(true)){
                    var insert_db = Company(comText.text.toString(),jobText.text.toString(),dateText.text.toString(),locText.text.toString(),conText.text.toString(),emailText.text.toString(),phoneText.text.toString(), spinnerStatus.selectedItem.toString(),0)
                    var db = DatabaseHandler(this)
                    db.insertData(insert_db)
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this,"Please enter date is the given format", Toast.LENGTH_SHORT).show()
                }


            }else{
                Toast.makeText(this,"Please enter data in all fields", Toast.LENGTH_SHORT).show()
            }


        }
    }
}


