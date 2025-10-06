package com.eco.summaytask12.data.model.shareholder

import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.person.Gender
import java.util.Date

class ShareHolder(
    name: String,
    birthOfDate: Date,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    var companyName: String,
    var sharesOwned: Double,
    var vision: String? = null,
) : Employee(name, birthOfDate, gender, address, phone, email, department) {
    override fun getContactInfo(): String {
        return """Shareholder Info:
        Name: $name
        Company: $companyName
        Shares Owned: $sharesOwned
        Vision: ${vision ?: "Chưa có"}
        """.trimIndent()
    }

    fun updateShares(newShares: Double) {
        sharesOwned = newShares
    }


}