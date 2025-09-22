package com.eco.summaytask12.data.model

class Founder(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    private var companyName: String,
    private var vision: String? = null,
) : Person(
    name = name,
    birthOfDate = birthOfDate,
    gender = gender,
    address = address,
    phone = phone,
    email = email
) {
    override fun greet() {
        println("Hello, I'm the founder of $companyName. My vision is: $vision")
    }

    override fun run() {
        println("The founder is running")
    }

    override fun walk() {
        println("The founder is walking")
    }
    
}
