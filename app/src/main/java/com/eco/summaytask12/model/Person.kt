package com.eco.summaytask12.model

import com.eco.summaytask12.extension.normalizeUserName
import com.eco.summaytask12.extension.stringToDate
import com.eco.summaytask12.extension.toGender
import java.util.Calendar
import java.util.Date

abstract class Person(
    var name: String,
    var birthOfDate: Date,
    var gender: Gender,
    var address: String,
    var phone: String,
    var email: String
) {
    constructor(
        name: String,
        birthOfDate: String,
        gender: Gender,
        address: String,
        phone: String,
        email: String
    ) : this(name.normalizeUserName(), birthOfDate.stringToDate(), gender, address, phone, email)

    constructor(
        name: String,
        birthOfDate: String,
        gender: String,
        address: String,
        phone: String,
        email: String
    ) : this(name.normalizeUserName(), birthOfDate.stringToDate(), gender.toGender(), address, phone, email)

    val contactInfo: String by lazy {
        """
    $name's Contact Information:
    Email: $email
    Phone: $phone
    Address: $address
""".trimIndent()
    }
    val age: Int
        get() {
            val currentTime = Calendar.getInstance()
            val birthCalendar = Calendar.getInstance().apply { time = birthOfDate }
            return currentTime.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR)
        }

    abstract fun greet()
    abstract fun run()
    abstract fun walk()
}