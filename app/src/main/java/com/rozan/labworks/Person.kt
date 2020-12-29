package com.rozan.labworks

import java.io.Serializable

class Person:Serializable {
    var Name:String;
    var Address:String;
    var Mobile:String;
    var Gender:String;

    constructor(Name: String, Address: String, Mobile: String, Gender: String) {
        this.Name = Name;
        this.Address = Address;
        this.Mobile = Mobile;
        this.Gender = Gender;
    }



    override fun toString(): String {
        return "Person(Name='$Name', Address='$Address', Mobile='$Mobile', Gender='$Gender')"
    }


}