package com.example.harih.jobtracker

class Company{

    var compname : String = ""
    var role : String = ""
    var dateapply : String = ""
    var locationjob : String = ""
    var contactname : String = ""
    var contactemail : String = ""
    var contactnumber : String = ""
    var statusjob : String = ""
    var compid: Int = 0

    constructor(compname:String, role:String, dateapply:String, locationjob:String, contactname: String, contactemail:String, contactnumber:String, status:String, compid: Int){
        this.compname=compname
        this.role=role
        this.dateapply=dateapply
        this.locationjob=locationjob
        this.contactname=contactname
        this.contactemail=contactemail
        this.contactnumber=contactnumber
        this.statusjob=status
        this.compid=compid
    }

    constructor()

}