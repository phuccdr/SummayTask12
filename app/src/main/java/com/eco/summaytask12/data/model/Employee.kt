package com.eco.summaytask12.data.model

open class Employee(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    var position: String,
    var department: String,
    private var salary: Double = 0.0,
) : Person(name, birthOfDate, gender, address, phone, email) {
    override fun greet() {
        println("Hello, I'm $name")
    }

    override fun run() {
        println("$name is running to the meeting")
    }

    override fun walk() {
        println("$name is walking around the office")
    }

    override fun toString(): String {
        return "Employee(name='$name', birthOfDate=$birthOfDate, gender=$gender, address='$address', phone='$phone', email='$email', position='$position', department='$department', salary=$salary)"
    }

}
