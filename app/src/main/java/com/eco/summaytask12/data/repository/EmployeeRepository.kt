package com.eco.summaytask12.data.repository

import com.eco.summaytask12.data.mock.MockEmployeeData
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.employee.dev.DeveloperLevel
import com.eco.summaytask12.data.model.employee.manger.Manager
import kotlinx.coroutines.delay

class EmployeeRepository {
    private val mockEmployees: MutableList<Employee> = MockEmployeeData.mockEmployees
    private val mockAndroidDevelopers: List<AndroidDeveloper>
        get() = MockEmployeeData.mockAndroidDevelopers
    private val mockManager: List<Manager>
        get() = MockEmployeeData.mockManagers

    suspend fun getAllManagers(): List<Manager> {
        println("Fetching all Managers...")
        delay(1000)
        println("Successfully fetched ${mockManager.size} Managers")
        return mockManager
    }

    suspend fun getAllEmployees(): List<Employee> {
        println("Fetching all Employees...")
        delay(1000)
        println("Successfully fetched ${mockEmployees.size} Employees")
        return mockEmployees
    }

    suspend fun getAllAndroidDevelopers(): List<AndroidDeveloper> {
        println("Fetching all Android Developers.")
        delay(1500)
        println("Successfully fetched ${mockAndroidDevelopers.size} Android Developers")
        return mockAndroidDevelopers
    }


    suspend fun addEmployees(employees: List<Employee>) {
        delay(1000)
        mockEmployees.addAll(employees)
        println(employees[0])
        println("Successfully added ${employees.size} employees")
    }

    fun getAllInternAndroidDevelopers(): List<AndroidDeveloper> {
        return mockAndroidDevelopers.filter { it.level == DeveloperLevel.INTERN }
    }

    fun searchEmployeeByName(name: String): Employee? {
        return mockEmployees.find { it.name == name }
    }

    suspend fun getStatistics(): Map<String, Any> {
        println("Calculating statistics...")
        delay(2000)
        val totalDevelopers = mockAndroidDevelopers.size
        val totalEmployees = mockEmployees.size
        val seniorDevs = mockAndroidDevelopers.count { it.experience >= 3.0 }
        val stats = mapOf(
            "totalAndroidDevelopers" to totalDevelopers,
            "totalEmployees" to totalEmployees,
            "seniorDevelopers" to seniorDevs,
            "totalSkills" to mockAndroidDevelopers.flatMap { it.skills }.toSet()
        )
        println("Statistics calculated successfully")
        return stats
    }
}
