package com.example.harih.jobtracker

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


//class for recyclerview adapter
class MainAdapter(val comp: ArrayList<String>, val rolelist:ArrayList<String>,val dateapplied:ArrayList<String>,val statusjob:ArrayList<String>,val compid:ArrayList<String>,val contactname: ArrayList<String>,val contactmail: ArrayList<String>,val contactnumber: ArrayList<String>,val size: Int): RecyclerView.Adapter<CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.company_row, parent, false)

        return CustomViewHolder(cellForRow)
    }


    override fun getItemCount(): Int {

        return size

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


        holder.compname.text = comp[position]
        holder.rolename.text = rolelist[position]
        holder.dateapplied.text = dateapplied[position]
        holder.statusjob.text = "Status: " + statusjob[position]

        holder?.datavar = compid[position]
        holder?.dataname=comp[position]
        holder?.datarole=rolelist[position]
        holder?.datadt=dateapplied[position]
        holder?.datast=statusjob[position]
        holder?.datacname=contactname[position]
        holder?.conmail=contactmail[position]
        holder?.connum=contactnumber[position]

    }
}

    class CustomViewHolder(v: View, var datavar: String?=null, var dataname: String?=null, var datadt: String?=null, var datarole: String?=null, var datast: String? = null, var datacname: String? = null, var conmail: String? = null, var connum: String? = null): RecyclerView.ViewHolder(v){
        companion object {
            val DATA_MSG = "The ID"
            val DATA_NAME = "Company Name"
            val DATA_ROL= "job position"
            val DATA_DATE="date applied"
            val DATA_STATUS="job status"
            val DATA_CNAME="contact name"
            val DATA_CMAIL="contact mail"
            val DATA_CNUM="contact num"
        }

        val compname: TextView = itemView.findViewById(R.id.compname)
        val rolename: TextView =itemView.findViewById(R.id.rolename)
        val dateapplied : TextView =itemView.findViewById(R.id.date_applied)
        val statusjob : TextView =itemView.findViewById(R.id.statname)

        init {

            v.setOnClickListener {

                val intent = Intent(v.context, View_Job::class.java).apply{
                    putExtra(DATA_MSG, datavar)
                    putExtra(DATA_NAME, dataname)
                    putExtra(DATA_ROL,datarole)
                    putExtra(DATA_DATE,datadt)
                    putExtra(DATA_STATUS,datast)
                    putExtra(DATA_CNAME,datacname)
                    putExtra(DATA_CMAIL,conmail)
                    putExtra(DATA_CNUM,connum)
                }

                v.context.startActivity(intent)

            }
        }

    }
