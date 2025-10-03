package com.eco.summaytask12.data.model.company

import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.founder.Founder
import java.util.Calendar

class Company(
    val name: String,
    val address: String,
    val founder: Founder,
    private val employees: MutableList<Employee>,
    private val description: String? = "Xin chao moi nguoi",
    private val foundedYear: Int = 2020,
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

    override fun toString(): String {
        return "Company(name='$name', address='$address', founder=$founder, employees=$employees, description=$description, foundedYear=$foundedYear), totalEmployees=$totalEmployees"
    }

    fun addEmployees(employees: List<Employee>) {
        this.employees.addAll(employees)
    }
}