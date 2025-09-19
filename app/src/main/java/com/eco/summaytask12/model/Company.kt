package com.eco.summaytask12.model

import java.util.Calendar

data class Company(
    val name: String,
    val address: String,
    val founder: Founder,
    val employees: MutableList<Employee>,
    val description: String? = "Xin chao moi nguoi",
    val foundedYear: Int = 2020,
) {
    val totalEmployees: Int get() = employees.size

    companion object {
        fun createStartup(
            name: String,
            address: String,
            founder: Founder,
        ): Company {
            return Company(
                name = name,
                address = address,
                founder = founder,
                employees = mutableListOf(),
                foundedYear = Calendar.getInstance().get(Calendar.YEAR)
            )
        }
    }
}