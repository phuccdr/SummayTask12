package com.eco.summaytask12.data.model.employee

import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.person.Person
import java.util.Date

open class Employee(
    name: String,
    birthOfDate: Date,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    var department: Department,
) : Person(name, birthOfDate, gender, address, phone, email), Workable {
    override fun greet() {
        println("Hello, I'm $name")
    }

    override fun run() {
        println("$name is running to the meeting")
    }

    override fun walk() {
        println("$name is walking around the office")
    }

    override fun startWork() {
        println("$name is starting work")
    }

    override fun finishWork() {
        println("$name is finishing work")
    }

    override fun reportProgress() {
        println("$name is reporting progress")
    }

    override fun toString(): String {
        return "Employee(name='$name', birthOfDate=$birthOfDate, gender=$gender, address='$address', phone='$phone', email='$email', department='$department'."
    }

}
