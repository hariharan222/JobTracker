package com.example.harih.jobtracker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            startActivity(Intent(this, Add_Job_Activity::class.java))
        }



        try{
            var db = DatabaseHandler(this)
            var data = db.readData()
            val compid: ArrayList<String> = ArrayList()
            val complist: ArrayList<String> = ArrayList()
            val rolelist: ArrayList<String> = ArrayList()
            val dateapplied: ArrayList<String> = ArrayList()
            val statusjob: ArrayList<String> = ArrayList()
            val contactname: ArrayList<String> = ArrayList()
            val contactemail: ArrayList<String> = ArrayList()
            val contactnumber: ArrayList<String> = ArrayList()
            var size = data.size
            for(i in 0..(data.size-1)){
                compid.add(data.get(i).compid.toString())
                complist.add(data.get(i).compname.toString())
                rolelist.add(data.get(i).role.toString())
                dateapplied.add(data.get(i).dateapply.toString())
                statusjob.add(data.get(i).statusjob.toString())
                contactname.add(data.get(i).contactname.toString())
                contactemail.add(data.get(i).contactemail.toString())
                contactnumber.add(data.get(i).contactnumber.toString())
                recyclerView_main.layoutManager=LinearLayoutManager(this)
                recyclerView_main.adapter=MainAdapter(complist,rolelist,dateapplied,statusjob,compid,contactname,contactemail,contactnumber,size)
            }

        }catch (e: Exception){
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()

        }



    }

}


