package com.example.harih.jobtracker

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext

val DATABASE_NAME = "jobtrack"
val TABLE_NAME = "applied_jobs"
val COL_ID="company_id"
val COL_COMP = "company_name"
val COL_ROL = "company_role"
val COL_DAT = "company_dat"
val COL_LOC = "company_loc"
val COL_CON_NAME = "company_contact_name"
val COL_CON_MAIL = "company_email"
val COL_CON_NUM = "company_number"
val COL_STAT = "company_stat"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE "+ TABLE_NAME +"("+ COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_COMP+" VARCHAR(256),"+
                COL_ROL +" VARCHAR(256), "+
                COL_DAT +" VARCHAR(256), "+
                COL_LOC +" VARCHAR(256),"+
                COL_CON_NAME+" VARCHAR(256),"+
                COL_CON_MAIL+" VARCHAR(256),"+
                COL_CON_NUM+" VARCHAR(256),"+
                COL_STAT+" VARCHAR(256))"
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val createTable = "CREATE TABLE "+ TABLE_NAME +"("+ COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_COMP+" VARCHAR(256),"+
                COL_ROL +" VARCHAR(256), "+
                COL_DAT +" VARCHAR(256), "+
                COL_LOC +" VARCHAR(256),"+
                COL_CON_NAME+" VARCHAR(256),"+
                COL_CON_MAIL+" VARCHAR(256),"+
                COL_CON_NUM+" VARCHAR(256),"+
                COL_STAT+" VARCHAR(256))"
        db?.execSQL(createTable)
    }

    fun insertData(insert_db: Company){
        val db = this.writableDatabase
        var cv = ContentValues()//need contentValues to insert data
        cv.put(COL_COMP,insert_db.compname)
        cv.put(COL_ROL,insert_db.role)
        cv.put(COL_DAT,insert_db.dateapply)
        cv.put(COL_LOC,insert_db.locationjob)
        cv.put(COL_CON_NAME,insert_db.contactname)
        cv.put(COL_CON_MAIL,insert_db.contactemail)
        cv.put(COL_CON_NUM,insert_db.contactnumber)
        cv.put(COL_STAT,insert_db.statusjob)
        var result = db.insert(TABLE_NAME,null,cv)

        if(result == (-1).toLong()){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }

    }

    fun readData() : MutableList<Company>{
        var list : MutableList<Company> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do{
                var data = Company()

                data.compid = result.getInt(result.getColumnIndex(COL_ID))
                data.compname = result.getString(result.getColumnIndex(COL_COMP))
                data.role = result.getString(result.getColumnIndex(COL_ROL))
                data.dateapply = result.getString(result.getColumnIndex(COL_DAT))
                data.locationjob = result.getString(result.getColumnIndex(COL_LOC))
                data.contactname = result.getString(result.getColumnIndex(COL_CON_NAME))
                data.contactemail = result.getString(result.getColumnIndex(COL_CON_MAIL))
                data.contactnumber = result.getString(result.getColumnIndex(COL_CON_NUM))
                data.statusjob=result.getString(result.getColumnIndex(COL_STAT))
                list.add(data)

            }while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun delData(delete_data: dataDelete){
        val db = this.writableDatabase
        val query = "delete from " + TABLE_NAME + " where "+ COL_ID +"="+delete_data.id
        val result = db.execSQL(query)
        println (result)

    }

    fun updateStatus(update: updateStatus){
        val db = this.writableDatabase
        val query = "update "+ TABLE_NAME +" set "+ COL_STAT + " = '" + update.stats + "' where "+ COL_ID +"="+update.id
        val result = db.execSQL(query)
        println (result)

    }

}