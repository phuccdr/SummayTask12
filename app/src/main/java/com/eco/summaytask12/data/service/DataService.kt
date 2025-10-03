package com.eco.summaytask12.data.service

import com.eco.summaytask12.data.repository.EmployeeRepository
import com.eco.summaytask12.data.repository.StudentRepository
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.employee.manger.Manager
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.internandroid.InternAndroidDeveloper

class DataService {
    
    private val employeeRepository = EmployeeRepository()
    private val studentRepository = StudentRepository()

    suspend fun getAllManagers():List<Manager> = employeeRepository.getAllManagers()
    
    suspend fun getAllEmployees(): List<Employee> = employeeRepository.getAllEmployees()
    
    suspend fun getAllAndroidDevelopers(): List<AndroidDeveloper> = employeeRepository.getAllAndroidDevelopers()
    
    suspend fun addEmployees(employees: List<Employee>) = employeeRepository.addEmployees(employees)
    
    fun getAllInternAndroidDevelopers(): List<AndroidDeveloper> =
        employeeRepository.getAllInternAndroidDevelopers()
    
    fun searchEmployeeByName(name: String): Employee? = employeeRepository.searchEmployeeByName(name)
    
    suspend fun getStatistics(): Map<String, Any> = employeeRepository.getStatistics()

    fun addStudent1(students: List<InternAndroidDeveloper>) = studentRepository.addStudent1(students)

    fun addStudent2(students: List<InternAndroidDeveloper>) = studentRepository.addStudent2(students)

    fun searchStudent1(name: String): InternAndroidDeveloper? = studentRepository.searchStudent1(name)

    fun searchStudent2(name: String): InternAndroidDeveloper? = studentRepository.searchStudent2(name)

    fun checkContainStudent1(student: InternAndroidDeveloper): Boolean = studentRepository.checkContainStudent1(student)

    fun checkContainStudent2(student: InternAndroidDeveloper): Boolean = studentRepository.checkContainStudent2(student)
}

