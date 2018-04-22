package com.example.harih.jobtracker

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_view_job.*

class View_Job : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_job)
        val companyid = intent.getStringExtra(CustomViewHolder.DATA_MSG)
        val companyname = intent.getStringExtra(CustomViewHolder.DATA_NAME)
        val companyRole = intent.getStringExtra(CustomViewHolder.DATA_ROL)
        val companydate = intent.getStringExtra(CustomViewHolder.DATA_DATE)
        val companystatus = intent.getStringExtra(CustomViewHolder.DATA_STATUS)
        val contactnname = intent.getStringExtra(CustomViewHolder.DATA_CNAME)
        val contactmail = intent.getStringExtra(CustomViewHolder.DATA_CMAIL)
        val contactnumber = intent.getStringExtra(CustomViewHolder.DATA_CNUM)

        companyName.text=companyname
        posCompany.text=companyRole
        dtApplied.text=companydate
        currStatus.text="Current Status: "+companystatus
        cName.text="Name : "+contactnname
        cMail.text="Email  : "+contactmail
        cNum.text= "Ph.No : "+contactnumber
        deleteButton.setOnClickListener {

            d("Hariharan",companyid)

            var delete_data = dataDelete(companyid.toInt())

            var db = DatabaseHandler(this)
            db.delData(delete_data)
            startActivity(Intent(this, MainActivity::class.java))
        }

        saveButton.setOnClickListener {
            var updateStatus = updateStatus(companyid.toInt(),statusSelector.selectedItem.toString())
            var db = DatabaseHandler(this)
            db.updateStatus(updateStatus)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}



class dataDelete{
    var id: Int=0
    constructor(id:Int){
        this.id=id
    }

}

class updateStatus{
    var id: Int=0
    var stats: String = ""
    constructor(id:Int, stats: String){
        this.id=id
        this.stats=stats

    }
}