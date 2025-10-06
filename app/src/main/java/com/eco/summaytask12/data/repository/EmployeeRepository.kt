package com.eco.summaytask12.data.repository

import com.eco.summaytask12.data.mock.MockEmployeeData
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.backenddeveloper.BackendDeveloper
import com.eco.summaytask12.data.model.internandroid.InternAndroidDeveloper
import com.eco.summaytask12.data.model.dev.DeveloperLevel
import com.eco.summaytask12.data.model.manger.Manager
import com.eco.summaytask12.data.model.shareholder.ShareHolder
import kotlinx.coroutines.delay

class EmployeeRepository {
    private val mockEmployees: MutableList<Employee> = MockEmployeeData.mockEmployees
    private val mockAndroidDevelopers: List<AndroidDeveloper>
        get() = MockEmployeeData.mockAndroidDevelopers
    private val mockBackendDevelopers: List<BackendDeveloper>
        get() = MockEmployeeData.mockBackendDevelopers
    private val mockInternDevelopers: List<InternAndroidDeveloper>
        get() = MockEmployeeData.mockInternDevelopers
    private val mockManager: List<Manager>
        get() = MockEmployeeData.mockManagers
    private val mockShareholders: List<ShareHolder>
        get() = MockEmployeeData.mockShareholders

    fun getAllManagers(): List<Manager> {
        return mockManager
    }

    fun getAllEmployees(): List<Employee> {
        return mockEmployees
    }

    fun getAllAndroidDevelopers(): List<AndroidDeveloper> {
        return mockAndroidDevelopers
    }

    fun getAllBackendDevelopers(): List<BackendDeveloper> {
        return mockBackendDevelopers
    }

    fun getAllInternDevelopers(): List<InternAndroidDeveloper> {
        return mockInternDevelopers
    }

    fun getAllShareholders(): List<ShareHolder> {
        return mockShareholders.sortedByDescending { shareHolder ->
            shareHolder.sharesOwned
        }
    }

    fun addEmployees(employees: List<Employee>) {
        mockEmployees.addAll(employees)
    }

    fun getAllInternAndroidDevelopers(): List<AndroidDeveloper> {
        return mockAndroidDevelopers.filter { it.devLevel == DeveloperLevel.INTERN }
    }

    fun searchEmployeeByName(name: String): Employee? {
        return mockEmployees.find { it.name == name }
    }

    fun getStatistics(): Map<String, Any> {
        val totalDevelopers = mockAndroidDevelopers.size
        val totalBackendDevs = mockBackendDevelopers.size
        val totalEmployees = mockEmployees.size
        val seniorAndroidDevs = mockAndroidDevelopers.filter { it.experience >= 3.0 }
        val seniorBackendDevs = mockBackendDevelopers.count { it.experience >= 3.0 }
        val stats = mapOf("totalManagers" to mockManager.size,
            "totalEmployees" to totalEmployees,
            "totalAndroidDevelopers" to totalDevelopers,
            "totalBackendDevelopers" to totalBackendDevs,
            "seniorAndroidDevelopers" to seniorAndroidDevs,
            "seniorBackendDevelopers" to seniorBackendDevs,
            "totalAndroidSkills" to mockAndroidDevelopers.flatMap { it.techSkills }.toSet().size,
            "totalBackendSkills" to mockBackendDevelopers.flatMap { it.techSkills }.toSet().size,
            "allSkills" to (mockAndroidDevelopers + mockBackendDevelopers).flatMap { it.techSkills }
                .toSet())
        return stats
    }

//    fun getDevelopersByLevel(level: DeveloperLevel): List<AndroidDeveloper> {
//        return mockAndroidDevelopers.filter { it.devLevel == level }
//    }
//
//    fun searchEmployeesByDepartment(department: com.eco.summaytask12.data.model.employee.Department): List<Employee> {
//        return mockEmployees.filter { it.department == department }
//    }
}
